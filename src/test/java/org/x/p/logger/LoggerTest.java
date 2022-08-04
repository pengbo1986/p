/**
 * Copyright (C) 2022 WUHAN PB, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 *
 * @File name：org.x.p.logger.LoggerTest
 * @Create on：2022/8/3
 * @Author：pb
 */
package org.x.p.logger;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>ClassName：LoggerTest</p >
 * <p>Description：</p >
 * <p>Author：pb</p >
 * <p>Date：2022/8/3</p >
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {//获取日志记录器
    private static Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void contextLoads() {
        logger.trace("这是 trace 日志...");
        logger.debug("这是 debug 日志...");
        logger.info("这是 info 日志...");
        logger.warn("这是 warn 日志...");
        logger.error("这是 error 日志...");

        log.trace("这是 trace 日志...");
        log.debug("这是 debug 日志...");
        log.info("这是 info 日志...");
        log.warn("这是 warn 日志...");
        log.error("这是 error 日志...");

    }

}