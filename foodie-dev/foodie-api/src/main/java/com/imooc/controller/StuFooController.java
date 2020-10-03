package com.imooc.controller;

import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuFooController {

    @Autowired
    private StuService stuService;

    @GetMapping("getStu")
    public Stu getStu(int id) {
        return stuService.getStu(id);
    }

    @PostMapping("saveStu")
    public String saveStu() {
        stuService.saveStu();
        return "OK";
    }

    @PostMapping("updateStu")
    public String updateStu(int id) {
        stuService.updateStu(id);
        return "OK";
    }

    @PostMapping("deleteStu")
    public String deleteStu(int id) {
        stuService.deleteStu(id);
        return "OK";
    }
}
