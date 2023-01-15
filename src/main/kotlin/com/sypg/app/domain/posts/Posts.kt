package com.sypg.app.domain.posts

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "posts")
@Entity
data class Posts ( // must have no arg contructor
    @Id
    @GeneratedValue( // PK 생성 규칙
        strategy = GenerationType.IDENTITY) // auto_increment
    @Column( name = "id")
    val id: Long? = null, // -> bigint in MySQL
    @Column ( // Optional
        length = 500 // (default) VARCHAR(255) -> VARCHAR(500)
        , nullable = false )
    var title: String,
    @Column(columnDefinition = "TEXT" // VARCHAR -> TEXT
        , nullable = false)
    var content: String,
    var author: String? = null
) {
    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }
}