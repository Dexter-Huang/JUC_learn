package com.example.tikatest.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tikatest.entity.User;
import com.example.tikatest.service.IUserService;
import com.example.tikatest.utils.ApiResponse;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 张峰
 * @since 2022-04-22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 查询所有接口
     * @return
     */
    @GetMapping
    public ApiResponse findAll() {
        return ApiResponse.success(userService.list());
    }
    /**
     * 根据id查询数据接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ApiResponse findOne(@PathVariable Integer id) {
        return ApiResponse.success(userService.getById(id));
    }
    /**
     * 分页查询接口
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public ApiResponse findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return ApiResponse.success(userService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }
    /**
     * 新增和更新接口
     * @param user
     * @return
     */
    @PostMapping
    public ApiResponse save(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return ApiResponse.success();
    }
    /**
     * 删除接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id) {
        userService.removeById(id);
        return ApiResponse.success();
    }
    /**
     * 批量删除接口
     * @param ids
     * @return
     */
    @PostMapping("/del/batch")
    public ApiResponse deleteBatch(@RequestBody List<Integer> ids) {
        userService.removeByIds(ids);
        return ApiResponse.success();
    }

}
