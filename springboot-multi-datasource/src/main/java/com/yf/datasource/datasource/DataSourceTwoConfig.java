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
 */
@Configuration
@MapperScan(basePackages = "com.yf.datasource.mapper.two",sqlSessionFactoryRef = "twoSqlSessionFactory")
public class DataSourceTwoConfig {

    @Bean(name="twoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource twoDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="twoSqlSessionFactory")
    public SqlSessionFactory twoSqlSessionFactory(@Qualifier("twoDataSource")DataSource twoDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(twoDataSource);
        /*sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("如果是xml配置文件，则写路径在这里"));*/  //如classpath:mapper/*.xml
        return sqlSessionFactoryBean.getObject();
    }
    @Bean(name="twoDataSourceTransactionManager")
    public DataSourceTransactionManager twoDataSourceTransactionManager(@Qualifier("twoDataSource")DataSource twoDataSource){
        return new DataSourceTransactionManager(twoDataSource);
    }

    @Bean(name="twoSqlSessionTemplate")
    public SqlSessionTemplate twoSqlSessionTemplate(@Qualifier("twoSqlSessionFactory")SqlSessionFactory twoSqlSessionFactory){
        return new SqlSessionTemplate(twoSqlSessionFactory);
    }

}
