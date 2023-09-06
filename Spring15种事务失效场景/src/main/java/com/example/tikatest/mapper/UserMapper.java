package com.example.tikatest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tikatest.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张峰
 * @since 2022-04-22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
