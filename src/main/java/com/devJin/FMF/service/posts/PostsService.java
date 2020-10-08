package com.devJin.FMF.service.posts;


import com.devJin.FMF.domain.posts.Posts;
import com.devJin.FMF.domain.posts.PostsRepository;
import com.devJin.FMF.web.dto.PostsListsResponseDto;
import com.devJin.FMF.web.dto.PostsResponseDto;
import com.devJin.FMF.web.dto.PostsSaveRequestDto;
import com.devJin.FMF.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional // 수정 api
    public Long update(Long id , PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다 id = "+id));
        return new PostsResponseDto(entity);
    }
    @Transactional(readOnly = true) // 트랙잭션 어노테이션에 readOnly 옵션을 주면 트랜잭션 범위는 유지하되, 조회기능만 남겨두어 조회 속도가 개션됨 -> 등록 수정 삭제 기능이 없는 서비스 메소드에서 사용 추천
    public List<PostsListsResponseDto> findAllDesc(){
       return postsRepository.findAllByDesc().stream().map(PostsListsResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다. id = "+id));
        postsRepository.delete(posts);
//        postsRepository.deleteById(id);
        //JPA에서 이미 deletebyId라는 메소드를 제공하고 있다. 이를 사용하자.
    }

}
