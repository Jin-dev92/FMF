//package com.devJin.FMF.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@RequiredArgsConstructor
//@EnableWebSecurity // Spring Security를 활성화 한다는 의미
//@Configuration // webSecurityConfigurerAdapter를 상속받으면 오버라이드 할 수 있음, static 폴더는 항상 접근 가능해야함.
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
////    private final UserService userService; // 3
//
//    @Bean
//    public PasswordEncoder passwordEncoder() { // 비밀번호를 암호화할 때 사용할 인코더를 미리 빈으로 등록해놓는 과정입니다.
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(WebSecurity webSecurity) { // 5
//        webSecurity.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception { // 6
//        /*
//        * - `WebSecurityConfigurerAdapter`를 상속받으면 오버라이드할 수 있습니다.
//          - http 관련 인증 설정이 가능합니다.
//        * */
//        http
//                .authorizeRequests()
//                /*
//                - 접근에 대한 인증 설정이 가능합니다.
//                - `anyMatchers`를 통해 경로 설정과 권한 설정이 가능합니다.
//                - `permitAll()` : 누구나 접근이 가능
//                - `hasRole()` : 특정 권한이 있는 사람만 접근 가능
//                - `authenticated()` : 권한이 있으면 무조건 접근 가능
//                - `anyRequest`는 `anyMatchers`에서 설정하지 않은 나머지 경로를 의미합니다.
//                */
//                .antMatchers("/login", "/signup", "/user").permitAll() // 누구나 접근 허용
//                .antMatchers("/").hasRole("USER") // USER, ADMIN만 접근 가능
//                .antMatchers("/admin").hasRole("ADMIN") // ADMIN만 접근 가능
//                .anyRequest().authenticated() // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근 가능
//                .and()
//                .formLogin()
//                /*
//                    로그인에 관한 설정을 의미합니다.
//                    - `loginPage()` : 로그인 페이지 링크 설정
//                    - `defaultSuccessUrl()` : 로그인 성공 후 리다이렉트할 주소
//                * */
//                .loginPage("/login") // 로그인 페이지 링크
//                .defaultSuccessUrl("/") // 로그인 성공 후 리다이렉트 주소
//                .and()
//                .logout()
//                /* 로그아웃에 관한 설정
//                *  - `logoutSccessUrl()` : 로그아웃 성공 후 리다이렉트할 주소
//                   - `invalidateHttpSession()` : 로그아웃 이후 세션 전체 삭제 여부
//                * */
//                .logoutSuccessUrl("/login") // 로그아웃 성공시 리다이렉트 주소
//                .invalidateHttpSession(true) // 세션 날리기
//        ;
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        /*- 로그인할 때 필요한 정보를 가져오는 곳입니다.
//        - 유저 정보를 가져오는 서비스를 `userService` (아직 만들어지지 않음)으로 지정합니다.
//        - 패스워드 인코더는 아까 빈으로 등록해놓은 `passwordEncoder()`를 사용합니다. (BCrypt)
//        *
//        * */
////        auth.userDetailsService(userService).passwordEncoder(passwordEncoder()); // 해당 서비스(userService)에서는 UserDetailsService를 implements해서 loadUserByUsername() 구현해야함 (서비스 참고)
//    }
//}
