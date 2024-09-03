package com.shameyang.yangapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shameyang.yangapi.common.ErrorCode;
import com.shameyang.yangapi.exception.BusinessException;
import com.shameyang.yangapi.model.entity.UserInterfaceInfo;
import com.shameyang.yangapi.service.UserInterfaceInfoService;
import com.shameyang.yangapi.mapper.UserInterfaceInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author shameyang
* @description 用户调用接口信息服务实现类
* @createDate 2024-09-03 21:25:58
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，所有参数必须非空
        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于 0");
        }
    }
}