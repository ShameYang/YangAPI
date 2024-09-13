package com.shameyang.yangapi.service.impl.inner;

import com.shameyang.yangapi.service.UserInterfaceInfoService;
import com.shameyang.yangapicommon.service.InnerUserInterfaceInfoService;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author ShameYang
 * @date 2024/9/12 19:13
 * @description 内部用户接口信息服务实现类
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }
}