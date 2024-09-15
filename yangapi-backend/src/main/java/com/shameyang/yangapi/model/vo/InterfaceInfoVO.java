package com.shameyang.yangapi.model.vo;

import com.shameyang.yangapicommon.model.entity.InterfaceInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author ShameYang
 * @date 2024/9/14 19:38
 * @description 接口信息封装视图
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceInfoVO extends InterfaceInfo {

    @Serial
    private static final long serialVersionUID = 6340181704318476109L;

    /**
     * 调用次数
     */
    private Integer totalNum;
}