package com.sypg.app.domain.posts

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
//@Transactional // Rollback을 위함. 테스트 데이터가 반복적으로 입력될 때 대비?
class PostsRepositoryTest ( @Autowired val postsRepository: PostsRepository) {

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

}