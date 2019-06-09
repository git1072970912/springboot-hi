package com.qf.springboothi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author GuanYeFan
 * @Date 2019/6/3
 * 用户类
 */
@Entity
@Table(name = "user")
@Getter //生成get方法
@Setter //生成set方法
@ToString   //生成toString方法
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message = "姓名不能为空")    //数据校验
    private String name;
    @NotNull(message = "密码不能为空")
    private String password;
}
