package com.sypg.app.web.dto

import com.sypg.app.domain.posts.Posts

data class PostsResponseDto(
    val id: Long?,
    val title: String,
    val content: String,
    val author: String?
) {
    constructor (entity: Posts)
            : this( id = entity.id,
                    title = entity.title,
                    content = entity.content,
                    author = entity.author )

}