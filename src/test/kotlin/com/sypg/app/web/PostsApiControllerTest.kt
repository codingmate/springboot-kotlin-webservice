package com.sypg.app.web

import com.sypg.app.domain.posts.PostsRepository
import com.sypg.app.web.dto.PostsSaveRequestDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostsApiControllerTest (
    @LocalServerPort
    val port: Int
    , @Autowired
    val restTemplate: TestRestTemplate
    , @Autowired
    val postsRepository: PostsRepository
        ){

    @AfterEach // 하나 할 때마다
    //@AfterAll : 클래스 내 모든 테스트 끝나고 실행
    fun tearDown() {
        postsRepository.deleteAll()
    }

    @Test
    fun `Posts 등록된다`() {
        // given
        val title = "title"
        val content = "content"
        val requestDto = PostsSaveRequestDto( title = title
                                            , content = content )
        val url = "http://localhost:${port}/api/v1/posts"


        // when
        val responseEntity = restTemplate.postForEntity(url, requestDto
            //, Long.javaClass // <-- error!!
            , Long::class.java
        )

        // then
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.body).isGreaterThan(0L)

        val all = postsRepository.findAll()
        assertThat(all[0].title).isEqualTo(title)
        assertThat(all[0].content).isEqualTo(content)
    }



}