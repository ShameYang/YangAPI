package com.shameyang.yangapi.common;

import com.shameyang.yangapi.constant.CommonConstant;
import lombok.Data;

/**
 * @author ShameYang
 * @date 2024/8/22 23:14
 * @description 分页请求
 */
@Data
public class PageRequest {

    /**
     * 当前页号
     */
    private long current = 1;

    /**
     * 页面大小
     */
    private long pageSize = 10;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序顺序（默认升序）
     */
    private String sortOrder = CommonConstant.SORT_ORDER_ASC;
}