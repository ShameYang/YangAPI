package com.shameyang.yangapicommon.service;

/**
* @author shameyang
* @description 内部用户调用接口信息服务
* @createDate 2024-09-03 21:25:58
*/
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}