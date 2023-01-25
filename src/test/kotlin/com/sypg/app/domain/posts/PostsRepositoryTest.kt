package com.sypg.app.domain.posts

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS) // test 클래스 당 하나의 인스턴스 <- BeforeAll, AfterAll 사용을 위함
//@TestInstance(Lifecycle.PER_METHOD) // test 메서드 당 하나의 인스턴스 생성

//@Transactional // Rollback을 위함. 테스트 데이터가 반복적으로 입력될 때 대비?
class PostsRepositoryTest ( @Autowired val postsRepository: PostsRepository) {

    @AfterAll // 메서드가 static이거나 @TestInstance(Lifecycle.PER_CLASS)를 명시해야한다.
              // 코틀린은 static method가 없다고 한다.
    fun cleanup() {
        postsRepository.deleteAll()
    }

    @Test
    fun `게시글저장 불러오기`() {
        // given
        val title = "test board"
        val content = "board content"
        // if existing pk -> update else insert
        postsRepository.save(Posts(title = title, content = content, author="Dream Comes True"))

        //when
        val postsList = postsRepository
                            .findAll() // full scan posts

        //then
        val posts = postsList[0]
        Assertions.assertThat(posts.title).isEqualTo(title)
        Assertions.assertThat(posts.content).isEqualTo(content)
        Assertions.assertThat(posts.author).isEqualTo("Dream Comes True")
        Assertions.assertThat(posts.author).isNotEqualTo("test?")

    }

    @Test
    fun  `BastTimeEntity 등록`() {
        //given
        val now = LocalDateTime.of(2019,6,4,0,0,0)
        postsRepository.save(
            Posts( title = "title",
                   content = "content",
                   author = "author"
        ))
        //when
        val postsList = postsRepository.findAll()

        //then
        val posts = postsList.get(0)

        println(posts)

        Assertions.assertThat(posts.createdDate).isAfter(now)
        Assertions.assertThat(posts.lastModifiedDate).isAfter(now)
    }

}