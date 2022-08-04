package org.x.p.mysql.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController//相当于@controller+@responsebody合起来，如果需要返回的是视图对象，则只需要@controller注解即可
@RequestMapping("/hello")//拦截路径，比如说在本地启动服务则在浏览器中输入的url是：localhost:8080/mm/hi
public class HelloWorldController {

    @RequestMapping (value = "/world", method = RequestMethod.GET)
    public String hello() {

        return "hello world!";
    }


}
