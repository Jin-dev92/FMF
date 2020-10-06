package com.devJin.FMF.web;

import com.devJin.FMF.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@RequiredArgsConstructor
@Controller
public class PortfolioController {
    private final PostsService postsService;
    // 로그인 세션이 있으면
    public String portfolio(Model model) { // Model 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음.
        model.addAttribute("posts", postsService.findAllDesc());
        return "portfolio";
    }

}
