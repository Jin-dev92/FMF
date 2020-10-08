package com.devJin.FMF.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
//    private final MemberService memberService;
//
//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }
//
//    @PostMapping("/login")
//    public String login(Long id, String password, HttpSession httpSession) {
////        MemberResponseDto memberResponseDto = memberService.findByid(id);
////        if (memberResponseDto == null){
////            System.out.println("login Fail");
////            return "index";
////        }
////        boolean flag = memberService.matchPassword(password); // 로그인 프로세스 후 return bool값
////        if (!flag){
////            System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
////            return "index";
////        }
////        System.out.println("login Success!");
//        return "index";
//    }
}
