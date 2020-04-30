package com.imooc.controller;

import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("passport")
public class PassportController {

    private final UserService userService;

    public PassportController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("usernameExists")
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
}
