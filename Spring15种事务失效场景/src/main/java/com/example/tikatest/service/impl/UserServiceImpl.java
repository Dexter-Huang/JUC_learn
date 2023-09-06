package com.example.tikatest.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tikatest.entity.User;
import com.example.tikatest.mapper.UserMapper;
import com.example.tikatest.service.IUserService;
import com.example.tikatest.utils.TransactionalUtil;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张峰
 * @since 2022-04-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private TransactionalUtil transactionalUtil;



    @Override
    @Transactional(timeout = 1)
    public int insertTest1(User user) {
        if ("111".equals(user.getName())){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int i = userMapper.insert(user);

        return i;
    }

    @Override
    public int insertTest2(User user) {
        //return this.insertTest1(user);
        // 通过AopContext.currentProxy()获取代理对象，调用代理对象的方法，才能触发事务
        return ((IUserService)AopContext.currentProxy()).insertTest1(user);
    }

    @Override
    public int insertTest3(User user) {

        return this.transactionalUtil.executeInTransaction(() -> {
            int i = userMapper.insert(user);
            if("111".equals(user.getName())){
                throw new RuntimeException("111");
            }
            return i;
        });
    }


}
