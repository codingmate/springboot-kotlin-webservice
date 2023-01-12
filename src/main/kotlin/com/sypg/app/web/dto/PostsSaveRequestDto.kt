package com.sypg.app.web.dto

import com.sypg.app.domain.posts.Posts

data class PostsSaveRequestDto (
    val title: String
  , val content: String
  , val author: String? = null
  ) {

    fun toEntity(): Posts {
        return Posts(
              title = title
            , content = content
            , author = author
        )
    }
}