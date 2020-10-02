package com.devJin.FMF.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {
    @Test
    public void 롬복_테스트_기능(){
        //given
        String name = "test";
        int amount = 1000;
        // wheen
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        assertThat(dto.getName()).isEqualTo(name); // 테스트 검증 라이브러리의 검증 메소드, 검증하고 싶은 대상을 메소드 인자로 받습니다.
        assertThat(dto.getAmount()).isEqualTo(name); // asserttj의 동등 비교 메소드 , 둘을 비교해서 같은 경우에만 성공
    }
}
