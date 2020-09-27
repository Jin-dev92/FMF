package com.devJin.FMF.web;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@RunWith(SpringRunner.class) // 스프링 부트 테스트와 Junit 사이에 연결자 역할을 함
@WebMvcTest(controllers = HelloController.class) // 여러 스프링 테스트 어노테이션중 web에 집중 할 수 있는 어노테이션
public class HelloControllerTest {
    @Autowired // 스프링이 관리하는 빈을 주입받습니다.
    private MockMvc mvc; // 웹 api를 테스트할 때 사용합니다. mvc 테스트의 시작점임 , HTTP GET POST 등에 대한 API 테스트를 할 수 있습니다

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")) // MockMVC를 통해 /hello 주소로 HTTP GET 요청을 함 , 체이닝이 지원되어 아래와 같이 연속적으로 선언 가능함.
                .andExpect(status().isOk()) // HTTP header 의 status를 검증, 200,404,500  여기서는 200인지 확인
                .andExpect(content().string(hello)); // mvc.perform의 결과를 검증

    }
    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto"))
//                .param("name",name) api 테스트할 때 사용될 요청 파라미터를 설정 , String 값만 허용
//                .param("amount",String.valueOf(amount))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) // JSON 응답값을 필드별로 검증할 수 있는 메소드 , $ 기준으로 필드명을 명시
                .andExpect(jsonPath("$.amount",is(amount)));

    }


}
