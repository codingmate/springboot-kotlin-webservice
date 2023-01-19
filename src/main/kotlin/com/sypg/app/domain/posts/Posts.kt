package com.sypg.app.domain.posts

import com.sypg.app.domain.BaseTimeEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "posts")
@Entity
class Posts(
    title: String,
    content: String,
    author: String?
) : BaseTimeEntity() {
    @Id
    @GeneratedValue( // PK 생성 규칙
        strategy = GenerationType.IDENTITY) // auto_increment
    @Column( name = "id")
    val id: Long? = null // -> bigint in MySQL

    @Column ( // Optional
        length = 500 // (default) VARCHAR(255) -> VARCHAR(500)
        , nullable = false )
    var title: String = title

    @Column(columnDefinition = "TEXT" // VARCHAR -> TEXT
        , nullable = false)
    var content: String = content

    var author: String? = author
    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }
}