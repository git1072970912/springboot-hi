package com.qf.springboothi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author GuanYeFan
 * @Date 2019/6/4
 * 创建一个实体类接收异常处理返回的信息
 */
@Data
@AllArgsConstructor
public class ResultBean<T> {
    private String respCode;
    private T data;
}
