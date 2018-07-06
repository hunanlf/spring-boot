package com.yf.datasource.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by liufeng on 2018/7/6
 *  one 数据库配置数据源
 */
@Configuration
@MapperScan(basePackages = "com.yf.datasource.mapper.one",sqlSessionFactoryRef = "oneSqlSessionFactory")
public class DataSourceOneConfig {

    @Bean(name="oneDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource oneDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="oneSqlSessionFactory")
    public SqlSessionFactory  oneSqlSessionFactory(@Qualifier("oneDataSource")DataSource oneDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(oneDataSource);
        /*sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("如果是xml配置文件，则写路径在这里"));*/  //如classpath:mapper/*.xml
        return sqlSessionFactoryBean.getObject();
    }
    @Bean(name="oneDataSourceTransactionManager")
    public DataSourceTransactionManager oneDataSourceTransactionManager(@Qualifier("oneDataSource")DataSource oneDataSource){
        return new DataSourceTransactionManager(oneDataSource);
    }

    @Bean(name="oneSqlSessionTemplate")
    public SqlSessionTemplate oneSqlSessionTemplate(@Qualifier("oneSqlSessionFactory")SqlSessionFactory oneSqlSessionFactory){
        return new SqlSessionTemplate(oneSqlSessionFactory);
    }
}
