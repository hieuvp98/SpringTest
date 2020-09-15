package com.itstudent.example.di;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@Component
public class Bikini implements Outfit, InitializingBean, DisposableBean {

    @PostConstruct
    public void init(){
        System.out.println("Bikini được tạo");
    }

    public Bikini() {
        System.out.println("Bikini init ");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Bikini bị huỷ");
    }

    @Override
    public void wear() {
        System.out.println("Đã mặc bikini");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void destroy() throws Exception {

    }
}
