package com.shameyang.yangapi.model.dto.userInterfaceInfo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ShameYang
 * @date 2024/9/3 21:35
 * @description 更新请求
 */
@Data
public class UserInterfaceInfoUpdateRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 2431549867054618352L;

    /**
     * 主键
     */
    private Long id;

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