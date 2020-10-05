package com.devJin.FMF.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> { // extends JpaRepository<Entity클래스, Pk 타입>

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllByDesc();
    /*
    규모가 있는 프로젝트에서의 데이터 조회는 FK의 조인 , 복잡한 조건 등으로 인해 이런 Entity 클래스 만으로 처리하기 어려워
    조회용 프레임 워크를 추가로 사용합니다.
    대표적으로 querydsl,jooq,MyBatis 등이 있다. 많은 기업에서 querydsl 을 사용하고 있다.
    querydsl 의 장점
    1. 타입 안정성이 보장( 오타나 존재하지 안흔 컬럼명을 제시할 경우 IDE 에서 자동으로 검출)
    2. 국내 기업에서 많이 채용
    3. 레퍼런스가 많음.
    * */


}
