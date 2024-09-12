package com.shameyang.yangapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shameyang.yangapicommon.model.entity.UserInterfaceInfo;

/**
* @author shameyang
* @description 用户调用接口信息服务
* @createDate 2024-09-03 21:25:58
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 参数校验
     * @param userInterfaceInfo
     * @param add
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}