package com.sypg.app.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass // JPA Entity Class가 BastTimeEntity를 상속할 경우 필드들 모두 칼럼으로 인식
@EntityListeners(AuditingEntityListener::class)// BaseTitmeEntity class에 Auditing 기능 포함

abstract class BaseTimeEntity {
    @CreatedDate // Entity가 생성되어 저장될 때의 시간 자동 저장
    @Column(nullable = false, updatable = false)
    var createdDate: LocalDateTime = LocalDateTime.now() // val 생성의 경우 에러 발생 가능성 있음
        protected set // 변경방지?

    @LastModifiedDate // 조회한 Entity 값 변경 시 시간 자동 저장
    @Column(nullable = false)
    var lastModifiedDate: LocalDateTime = LocalDateTime.now()
        protected set
}