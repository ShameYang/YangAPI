package com.shameyang.yangapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shameyang.yangapi.common.ErrorCode;
import com.shameyang.yangapi.exception.BusinessException;
import com.shameyang.yangapi.mapper.UserMapper;
import com.shameyang.yangapicommon.model.entity.User;
import com.shameyang.yangapicommon.service.InnerUserService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ShameYang
 * @date 2024/9/12 19:14
 * @description 内部用户服务实现类
 */
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("access_key", accessKey);
        return userMapper.selectOne(queryWrapper);

    }
}