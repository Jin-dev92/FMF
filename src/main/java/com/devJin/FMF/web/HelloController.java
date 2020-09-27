package com.devJin.FMF.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
public class HelloController {
    @GetMapping("/hello") // http method인 get요청을 받을 수 있는 api를 만들어줌
    public String hello() {
        return "hello";
    }
}
