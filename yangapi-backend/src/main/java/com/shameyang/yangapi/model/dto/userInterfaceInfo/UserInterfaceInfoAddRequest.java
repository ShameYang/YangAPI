package com.shameyang.yangapi.model.dto.userInterfaceInfo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ShameYang
 * @date 2024/9/3 21:35
 * @description 创建请求
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -4792109653642836614L;

    /**
     * 调用用户 id
     */
    private Long userId;

    /**
     * 接口 id
     */
    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 0-正常 1-禁用
     */
    private Integer status;
}