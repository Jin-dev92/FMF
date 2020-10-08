package com.devJin.FMF.domain.member;

import com.devJin.FMF.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
//@Table(name = "MEMBER")
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  auto_increment
    private Long no;
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String password;

    @Builder
    public Member(String id,String password){
        this.id = id;
        this.password = password;
    }

}
