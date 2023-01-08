package com.sypg.app.web

import com.sypg.app.web.dto.HelloResponseDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
//import java.util.Optional

@RestController
class HelloController {
    @GetMapping("/hello")
    fun hello(): String {
        return "hello"
    }
    @GetMapping("/hello/dto")
    fun helloDto( @RequestParam("name") name: String // RequestParam은 String으로 넘어온 parameter를 casting하여 대입?
                , @RequestParam("amount") amount: Int ): HelloResponseDto {

        return HelloResponseDto(name, amount)
    }
}