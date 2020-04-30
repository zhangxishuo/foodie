package com.imooc.controller;

import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("stu")
public class StuFooController {

    private final StuService stuService;

    public StuFooController(StuService stuService) {
        this.stuService = stuService;
    }

    @GetMapping("{id}")
    public Stu findById(@PathVariable Integer id) {
        return stuService.findById(id);
    }

    @PostMapping
    public void save() {
        stuService.save();
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id) {
        stuService.update(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        stuService.deleteById(id);
    }
}
