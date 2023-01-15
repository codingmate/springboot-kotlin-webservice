package com.sypg.app.service.posts

import com.sypg.app.domain.posts.PostsRepository
import com.sypg.app.web.dto.PostsSaveRequestDto
import com.sypg.app.web.dto.PostsUpdateRequestDto
import com.sypg.app.web.dto.PostsResponseDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PostsService (
    @Autowired val postsRepository: PostsRepository
        ){
    @Transactional
    fun save(requestDto: PostsSaveRequestDto): Long? {
        return postsRepository.save(requestDto.toEntity()).id
    }

    @Transactional
    fun update(id: Long, requestDto: PostsUpdateRequestDto): Long {
        val posts = postsRepository.findById(id)
            .orElseThrow{ IllegalArgumentException("해당 게시글이 없습니다. id = $id") }

            posts.update(requestDto.title, requestDto.content)
        return id
    }

    fun findById(id: Long): PostsResponseDto {
        val entity = postsRepository.findById(id)
            .orElseThrow{ IllegalArgumentException("해당 게시글이 없습니다. id = $id") }

        return PostsResponseDto(entity)
    }
}