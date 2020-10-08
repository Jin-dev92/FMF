package com.devJin.FMF.web;

import com.devJin.FMF.service.posts.PostsService;
import com.devJin.FMF.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("login")
    public String login(){
        boolean flag = true; // 로그인 프로세스 후 return bool값
        String direction = "";
        if (flag) { // 로그인이 됬다면
            direction = "portfolio";
        }else{
            direction = "index"; // 실패 프로세스
        }
        return direction;
    }
//    @GetMapping("/")
//    public String index(Model model){ // Model 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음.
//        model.addAttribute("posts",postsService.findAllDesc());
//     return "index";
//    }
//    @GetMapping("/posts/save")
//    public String postsSave(){
//        return "posts-save"; // posts-save.mustache 호출
//    }
//
//    @GetMapping("/posts/update/{id}")
//    public String postsUpdate(@PathVariable Long id , Model model){
//        PostsResponseDto dto = postsService.findById(id);
//        model.addAttribute("post",dto);
//        return "posts-update";
//    }
}
