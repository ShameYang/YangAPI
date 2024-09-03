package com.shameyang.yangapi.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ShameYang
 * @date 2024/9/1 22:12
 * @description 接口调用请求
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -7134012072766703762L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户请求参数
     */
    private String userRequestParams;

}