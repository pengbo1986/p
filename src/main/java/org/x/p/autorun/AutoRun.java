package org.x.p.autorun;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.x.p.mysql.jdbc.DeptRepository;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class AutoRun implements ApplicationRunner, CommandLineRunner, ApplicationContextAware, BeanNameAware {
    //获取日志记录器
    private static Logger logger = LoggerFactory.getLogger(AutoRun.class);

    @Autowired
    private DeptRepository deptRepository;

    @PostConstruct
    public void run() {
        System.err.println("pppppppp PostConstruct pppppppp");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.err.println("pppppppp ApplicationRunner pppppppp" + args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.err.println("pppppppp CommandLineRunner pppppppp" + args);
        System.out.println(deptRepository.findALL());

        log.info("pppppppp slf4j test pppppppp");


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.err.println("pppppppp ApplicationContextAware pppppppp" + applicationContext);
    }

    @Override
    public void setBeanName(String s) {
        System.err.println("pppppppp BeanNameAware pppppppp" + s);
    }

    static {
        System.out.println("pppppppp static pppppppp");
    }
}
