package com.shameyang.yangapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shameyang.yangapicommon.model.entity.InterfaceInfo;

/**
* @author shameyang
* @description 针对表【interface_info(接口信息)】的数据库操作Service
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验接口参数
     * @param interfaceInfo
     * @param add
     */
    void validateInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}