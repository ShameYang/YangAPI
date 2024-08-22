package com.shameyang.yangapi.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ShameYang
 * @date 2024/8/21 15:37
 * @description 接口创建请求
 */
@Data
public class InterfaceInfoAddRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -283309175705087867L;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 响应头
     */
    private String responseHeader;

    /**
     * 请求类型
     */
    private String method;

}