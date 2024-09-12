package com.shameyang.yangapicommon.service;

import com.shameyang.yangapicommon.model.entity.InterfaceInfo;

/**
* @author shameyang
* @description 内部接口信息服务
*/
public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询接口是否存在
     * @param path
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String path, String method);
}