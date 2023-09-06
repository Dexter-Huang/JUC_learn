package com.example.tikatest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.tikatest.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张峰
 * @since 2022-04-22
 */
public interface IUserService extends IService<User> {
    public int insertTest1(User user);
    public int insertTest2(User user);
    public int insertTest3(User user);

}
