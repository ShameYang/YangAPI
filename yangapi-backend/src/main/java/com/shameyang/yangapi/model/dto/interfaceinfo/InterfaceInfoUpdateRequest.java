package com.shameyang.yangapi.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ShameYang
 * @date 2024/8/21 15:39
 * @description 接口更新请求
 */
@Data
public class InterfaceInfoUpdateRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -5348921101810464472L;

    /**
     * 主键
     */
    private Long id;

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
     * 接口状态(0-关闭，1-开启)
     */
    private Integer status;

    /**
     * 请求类型
     */
    private String method;

}