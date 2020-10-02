package com.devJin.FMF.web;


import com.devJin.FMF.service.posts.PostsService;
import com.devJin.FMF.web.dto.PostsResponseDto;
import com.devJin.FMF.web.dto.PostsSaveRequestDto;
import com.devJin.FMF.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping
    public Long save(@RequestBody PostsSaveRequestDto requestDto){  // 등록 api
        return postsService.save(requestDto);
    }

    @PutMapping("api/v1/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }


    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
//    public
}
