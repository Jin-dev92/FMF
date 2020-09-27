package com.devJin.FMF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FmfApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmfApplication.class, args); // 내장 WAS , 이러면 톰캣을 설치할 필요 없이, 스프링 부트로 만들어진 JAR로 실행하면됨
    }

}
