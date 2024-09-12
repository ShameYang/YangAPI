package com.shameyang.yangapicommon.service;

import com.shameyang.yangapicommon.model.entity.User;

/**
* @author shameyang
* @description 内部用户服务
* @createDate 2024-08-22 17:00:49
*/
public interface InnerUserService {

    /**
     * 数据库中查询是否分配给用户密钥（accessKey）
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}