package com.sypg.app.web

// import org.junit.jupiter.api.extension.ExtendWith

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

// @ExtendWith() // Junit4.@RunWith?을 Junit5에서 이렇게 사용한다 함. 아래의 @WebMvcTest가 있다면 안 써도 된다,
@WebMvcTest // 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션. @service, @Repository 사용 불가
//@AutoConfigureMockMvc // Service, Repository도 memory(spring container?)에 올린다고 함. bean을 가져올 수 있게 된다.
class HelloControllerTest @Autowired /* 스프링이 관리하는 빈(Bean)을 주입 받습니다. */
                            constructor (
                                val mvc: MockMvc // 웹 API 테스트 시 사용, 스프링 MVC 테스트의 시작점, 이 클래스로 HTTP GET/POST 테스트 가능
                            ) {
    @Test
    fun hello가_리턴된다() {
        val str = "hello"
        // https://docs.spring.io/spring-framework/docs/6.0.3/reference/html/testing.html#spring-mvc-test-framework
        mvc.perform(MockMvcRequestBuilders.get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청
            .andExpect(MockMvcResultMatchers.status().isOk) // mvc.perform의 결과 검증 / 200, 404, 500 상태 검증 / 여기선 200(OK) 인지 검증
            .andExpect(MockMvcResultMatchers.content().string(str)) // 응답 본문의 내용 "hello" 검증
            //.andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun helloDto가_리턴된다() {
        val name = "hello"
        val amount = 1500

        mvc.perform( MockMvcRequestBuilders.get("/hello/dto")
            .param("name", name)
            .param("amount", amount.toString()) ) // Int -> String
            .andExpect( MockMvcResultMatchers.status().isOk )
            .andExpect( MockMvcResultMatchers.jsonPath("$.name").value(name) )
            .andExpect( MockMvcResultMatchers.jsonPath("$.amount").value(amount) )
    }
}