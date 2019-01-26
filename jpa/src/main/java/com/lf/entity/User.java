package com.lf.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by liufeng on 2018/6/4
 */
@Entity
@Data
@Component
public class User {
    @Id              //主键
    @GeneratedValue  // 自增
    private Integer id;

    private String name;

    @Min(value = 18,message = "未满18岁，不准进入")   //年龄至少满18才通过
    private Integer age;

}
