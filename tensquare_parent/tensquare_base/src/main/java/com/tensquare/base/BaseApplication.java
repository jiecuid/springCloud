package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * Created by CuiJie on 2018/12/2.
 * 声明该类是SpringBoot的引导类,此类就是springboot项目的入口
 */
@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        //run方法表示运行springBoot的引导类，run方法的参数就是SpringBoot引导类的字节码对象
        SpringApplication.run(BaseApplication.class, args);
    }

    /**
     * 该Bean用于自动生成分布式id
     */
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }

}
