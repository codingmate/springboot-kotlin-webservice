package com.sypg.app.web

import com.sypg.app.service.posts.PostsService
import com.sypg.app.web.dto.PostsSaveRequestDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class PostsApiController (
    @Autowired val postsService: PostsService
        ) {

    @PostMapping("/api/v1/posts")
    fun save(@RequestBody requestDto: PostsSaveRequestDto): Long? {
        return postsService.save(requestDto)
    }


}