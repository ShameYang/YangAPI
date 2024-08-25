package com.shameyang.yangapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shameyang.yangapi.annotation.AuthCheck;
import com.shameyang.yangapi.common.BaseResponse;
import com.shameyang.yangapi.common.DeleteRequest;
import com.shameyang.yangapi.common.ErrorCode;
import com.shameyang.yangapi.common.ResultUtils;
import com.shameyang.yangapi.constant.CommonConstant;
import com.shameyang.yangapi.exception.BusinessException;
import com.shameyang.yangapi.model.dto.interfaceinfo.InterfaceInfoAddRequest;
import com.shameyang.yangapi.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.shameyang.yangapi.model.dto.interfaceinfo.InterfaceInfoUpdateRequest;
import com.shameyang.yangapi.model.entity.InterfaceInfo;
import com.shameyang.yangapi.model.entity.User;
import com.shameyang.yangapi.service.InterfaceInfoService;
import com.shameyang.yangapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ShameYang
 * @date 2024/8/21 15:35
 * @description 接口管理
 */
@RestController
@RequestMapping("/interfaceInfo")
@Slf4j
public class InterfaceInfoController {

    @Resource
    InterfaceInfoService interfaceInfoService;

    @Resource
    UserService userService;

    /**
     * 创建
     * @param addRequest
     * @param request
     * @return
     */
    @PostMapping("/add")
    @Operation(summary = "创建接口")
    public BaseResponse<Long> addInterfaceInfo(@RequestBody InterfaceInfoAddRequest addRequest, HttpServletRequest request) {
        if (addRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        BeanUtils.copyProperties(addRequest, interfaceInfo);
        interfaceInfoService.validateInterfaceInfo(interfaceInfo, true);
        User loginUser = userService.getLoginUser(request);
        interfaceInfo.setUserId(loginUser.getId());
        boolean result = interfaceInfoService.save(interfaceInfo);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        long newInterfaceInfoId = interfaceInfo.getId();
        return ResultUtils.success(newInterfaceInfoId);
    }

    /**
     * 删除
     * @param deleteRequest
     * @param request
     * @return
     */
    @PostMapping("/delete")
    @Operation(summary = "删除接口")
    public BaseResponse<Boolean> deleteInterfaceInfo(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 存在性验证、权限检查
        InterfaceInfo oldInterfaceInfo = validateAndAuthorize(deleteRequest.getId(), request);
        boolean result = interfaceInfoService.removeById(oldInterfaceInfo.getId());
        return ResultUtils.success(result);
    }

    /**
     * 更新
     * @param updateRequest
     * @param request
     * @return
     */
    @PostMapping("/update")
    @Operation(summary = "更新接口")
    public BaseResponse<Boolean> updateInterfaceInfo(@RequestBody InterfaceInfoUpdateRequest updateRequest, HttpServletRequest request) {
        if (updateRequest == null || updateRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        BeanUtils.copyProperties(updateRequest, interfaceInfo);
        // 参数校验
        interfaceInfoService.validateInterfaceInfo(interfaceInfo, false);
        long id = updateRequest.getId();
        // 存在性验证、权限检查
        validateAndAuthorize(id, request);
        boolean result = interfaceInfoService.updateById(interfaceInfo);
        return ResultUtils.success(result);
    }

    /**
     * 根据 id 获取
     * @param id
     * @return
     */
    @GetMapping("/get")
    @Operation(summary = "根据 id 查询接口")
    public BaseResponse<InterfaceInfo> getInterfaceInfoById(long id) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        InterfaceInfo interfaceInfo = interfaceInfoService.getById(id);
        return ResultUtils.success(interfaceInfo);
    }

    /**
     * 获取列表（仅管理员可使用）
     *
     * @param queryRequest
     * @return
     */
    @AuthCheck(mustRole = "admin")
    @GetMapping("/list")
    @Operation(summary = "获取接口列表")
    public BaseResponse<List<InterfaceInfo>> listInterfaceInfo(InterfaceInfoQueryRequest queryRequest) {
        InterfaceInfo interfaceInfoQuery = new InterfaceInfo();
        if (queryRequest != null) {
            BeanUtils.copyProperties(queryRequest, interfaceInfoQuery);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>(interfaceInfoQuery);
        List<InterfaceInfo> interfaceInfoList = interfaceInfoService.list(queryWrapper);
        return ResultUtils.success(interfaceInfoList);
    }

    /**
     * 分页获取列表
     *
     * @param queryRequest
     * @param request
     * @return
     */
    @GetMapping("/list/page")
    @Operation(summary = "分页获取接口列表")
    public BaseResponse<Page<InterfaceInfo>> listInterfaceInfoByPage(InterfaceInfoQueryRequest queryRequest, HttpServletRequest request) {
        if (queryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        InterfaceInfo interfaceInfoQuery = new InterfaceInfo();
        BeanUtils.copyProperties(queryRequest, interfaceInfoQuery);
        long current = queryRequest.getCurrent();
        long size = queryRequest.getPageSize();
        String sortField = queryRequest.getSortField();
        String sortOrder = queryRequest.getSortOrder();
        String description = interfaceInfoQuery.getDescription();
        // description 需支持模糊搜索
        interfaceInfoQuery.setDescription(null);
        // 限制爬虫
        if (size > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>(interfaceInfoQuery);
        queryWrapper.like(StringUtils.isNotBlank(description), "description", description);
        queryWrapper.orderBy(StringUtils.isNotBlank(sortField),
                sortOrder.equals(CommonConstant.SORT_ORDER_ASC), sortField);
        Page<InterfaceInfo> interfaceInfoPage = interfaceInfoService.page(new Page<>(current, size), queryWrapper);
        return ResultUtils.success(interfaceInfoPage);
    }

    /**
     * 存在性验证、权限检查
     * @param id
     * @param request
     * @return InterfaceInfo
     */
    private InterfaceInfo validateAndAuthorize(long id, HttpServletRequest request) {
        User user = userService.getLoginUser(request);
        InterfaceInfo oldInterfaceInfo = interfaceInfoService.getById(id);
        if (oldInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        if (!oldInterfaceInfo.getUserId().equals(user.getId()) && !userService.isAdmin(request)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        return oldInterfaceInfo;
    }
}