package com.sypg.app.domain.posts

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "post")
@Entity
data class Posts ( // must have no arg contructor
    @Id
    @GeneratedValue( // PK 생성 규칙
        strategy = GenerationType.IDENTITY) // auto_increment
    @Column( name = "id")
    val id: Long? = null // -> bigint in MySQL
    , @Column ( // Optional
        length = 500 // (default) VARCHAR(255) -> VARCHAR(500)
        , nullable = false )
    val title: String
    , @Column(columnDefinition = "TEXT" // VARCHAR -> TEXT
        , nullable = false)
    val content: String

    , val author: String? = null
)