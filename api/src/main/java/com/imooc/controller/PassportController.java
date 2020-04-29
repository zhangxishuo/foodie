package com.imooc.controller;

import com.imooc.service.UserService;
import com.imooc.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
