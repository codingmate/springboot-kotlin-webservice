package com.sypg.app.domain.posts

import org.springframework.data.jpa.repository.JpaRepository

// Posts와 함께 위치할 것
// Entity 클래스와 Repository 같은 패키지 위치 => 프로젝트 규모가 커져 도메인별로 프로젝트를 분리해야 할 때를 대비
interface PostsRepository: JpaRepository<Posts, Long>{

}