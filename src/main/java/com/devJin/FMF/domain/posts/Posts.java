package com.devJin.FMF.domain.posts;

import com.devJin.FMF.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 롬복 어노테이션 모든 필드의 getter 생성
@NoArgsConstructor // 롬복 어노테이션, 기본 생성자 자동 추가 
@Entity // JPA 어노테이션 , 테이블과 링크될 클래스임을 나타냄, 기본값으로 클래스의 카멜케이스 이름을 언더 스코어 네이밍으로 테이블 이름을 매칭함
// Entity 클래스에서는 setter 메소드를 만들지 않는다, 목적과 의도가 명확하지 않기 때문이다. 무분별하게 사용하다보면 헬 될수있음.
//ex) SalesManager.java -> sales_manage table
// 중요한 어노테이션일 수록 클래스에 붙혀서 쓴다.
 

public class Posts extends BaseTimeEntity {
    @Id // 테이블의 primary key 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk의 생성 규칙, GenerationType.IDENTITY 를 선언해야 auto_increment가 됩니다.
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용합니다.
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    // new Examper(b,a) 를 선언하는거 대신 사용, 빌더를 사용하면 어느 필드에 어느 값이 들어갔는지 명확하게 알 수 있음.
    public Posts(String title, String content, String author){
        this.title = title;
        this.content =  content;
        this.author = author;
    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
