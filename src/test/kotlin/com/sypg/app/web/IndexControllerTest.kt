package com.sypg.app.web

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexControllerTest(
    @Autowired // 없으면 에러남
    val restTemplate: TestRestTemplate
) {
    @Test
    fun `loading main page`() {
        //when
        val body: String = this.restTemplate.getForObject("/", String::class.java)

        //then
        println(">>>>>>\n${body}")
        Assertions.assertThat(body).contains("Spring Boot Web Service")
    }
}