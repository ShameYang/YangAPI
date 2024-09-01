package com.shameyang.yangapi.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ShameYang
 * @date 2024/8/22 10:47
 * @description Id 请求
 */
@Data
public class IdRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -8685195229993731233L;

    /**
     * id
     */
    private Long id;
}