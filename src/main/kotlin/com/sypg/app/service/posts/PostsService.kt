package com.sypg.app.service.posts

import com.sypg.app.domain.posts.PostsRepository
import com.sypg.app.web.dto.PostsSaveRequestDto
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
}