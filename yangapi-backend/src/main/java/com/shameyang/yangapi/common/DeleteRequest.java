package com.shameyang.yangapi.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ShameYang
 * @date 2024/8/22 10:47
 * @description 删除请求
 */
@Data
public class DeleteRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -8679374692169179595L;

    /**
     * id
     */
    private Long id;
}