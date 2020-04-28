package com.imooc.service;

import com.imooc.pojo.Stu;

public interface StuService {

    Stu findById(Integer id);

    void save();

    void update(Integer id);

    void deleteById(Integer id);
}
