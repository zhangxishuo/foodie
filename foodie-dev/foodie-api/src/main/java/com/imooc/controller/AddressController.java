package com.imooc.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "地址相关", tags = {"地址相关的api接口"})
@RequestMapping("address")
@RestController
public class AddressController {
}
