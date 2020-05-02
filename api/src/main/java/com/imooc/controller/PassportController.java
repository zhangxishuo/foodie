package com.imooc.controller;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("passport")
public class PassportController {

    private final UserService userService;

    public PassportController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在")
    @GetMapping("usernameIsExist")
    public JsonResult usernameExists(@RequestParam String username) {
        if (StringUtils.isBlank(username)) {
            return JsonResult.error("用户名不能为空");
        }
        boolean exist = userService.usernameExists(username);
        if (exist) {
            return JsonResult.error("用户名已经存在");
        }
        return JsonResult.ok();
    }


    @ApiOperation(value = "用户注册", notes = "用户注册")
    @PostMapping("register")
    public JsonResult register(@RequestBody UserBO userBO) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPwd)) {
            return JsonResult.error("用户名密码不能为空");
        }

        boolean exist = userService.usernameExists(username);
        if (exist) {
            return JsonResult.error("用户名已经存在");
        }

        if (password.length() < 6) {
            return JsonResult.error("密码长度不能小于6位");
        }

        if (!password.equals(confirmPwd)) {
            return JsonResult.error("两次密码输入不一致");
        }

        userService.createUser(userBO);

        return JsonResult.ok();
    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("login")
    public JsonResult login(@RequestBody UserBO userBO) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();

        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password)) {
            return JsonResult.error("用户名密码不能为空");
        }

        Users user = userService.queryUserForLogin(username, password);

        if (user == null) {
            return JsonResult.error("用户名密码不正确");
        }

        return JsonResult.ok();
    }
}
