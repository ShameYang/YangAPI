package com.shameyang.yangapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shameyang.yangapi.common.ErrorCode;
import com.shameyang.yangapi.exception.BusinessException;
import com.shameyang.yangapi.mapper.InterfaceInfoMapper;
import com.shameyang.yangapicommon.model.entity.InterfaceInfo;
import com.shameyang.yangapicommon.service.InnerInterfaceInfoService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ShameYang
 * @date 2024/9/12 19:14
 * @description 内部接口信息服务实现类
 */
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if (StringUtils.isAnyBlank(url, method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", url);
        queryWrapper.eq("method", method);
        return interfaceInfoMapper.selectOne(queryWrapper);
    }
}