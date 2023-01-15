package com.sypg.app.web.dto

import com.sypg.app.domain.posts.Posts

data class PostsResponseDto(
    private var id: Long?,
    private var title: String,
    private var content: String,
    private var author: String?
) {
    constructor (entity: Posts)
            : this( id = entity.id,
                    title = entity.title,
                    content = entity.content,
                    author = entity.author )

}