package org.x.p.mysql.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {


    //	数据访问的几种方案
//  1.mybatis-mapper
//	2.JPA-repository
//	3.JDBC Template
//	4.JDBC
    @Autowired
    DeptRepository deptRepository;

    @GetMapping("/home")
    public List<Dept> findAll() {

        return deptRepository.findALL();
    }


    @GetMapping("/{loc}")
    public List<Dept> find(@PathVariable String loc) {

        return deptRepository.findByLoc(loc);
    }
}
