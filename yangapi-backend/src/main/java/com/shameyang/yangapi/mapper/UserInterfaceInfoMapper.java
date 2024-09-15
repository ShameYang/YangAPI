package com.shameyang.yangapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shameyang.yangapicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author shameyang
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Mapper
* @createDate 2024-09-03 21:25:58
* @Entity com.shameyang.yangapi.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    // select interface_info_id, sum(total_num) as total_num
    // from user_interface_info
    // group by interface_info_id order by total_num desc limit 3;
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}