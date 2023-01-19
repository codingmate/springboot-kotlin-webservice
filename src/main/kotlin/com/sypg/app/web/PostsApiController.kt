package com.sypg.app.web

import com.sypg.app.service.posts.PostsService
import com.sypg.app.web.dto.PostsResponseDto
import com.sypg.app.web.dto.PostsSaveRequestDto
import com.sypg.app.web.dto.PostsUpdateRequestDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
class PostsApiController (
    @Autowired val postsService: PostsService
        ) {

    @PostMapping("/api/v1/posts")
    fun save(@RequestBody requestDto: PostsSaveRequestDto): Long? {
        return postsService.save(requestDto)
    }


    @PutMapping("/api/v1/posts/{id}")
    fun update( @PathVariable id: Long
              , @RequestBody requestDto: PostsUpdateRequestDto  ): Long {
        return postsService.update(id, requestDto)
    }

    @GetMapping("/api/v1/posts/{id}")
    fun findById(@PathVariable id: Long): PostsResponseDto{
        return postsService.findById(id)
    }
}
