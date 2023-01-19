package com.sypg.app.web

import com.sypg.app.web.dto.HelloResponseDto
import org.springframework.web.bind.annotation.*


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
    
    @GetMapping("/json")
    @ResponseBody
    fun json(  @RequestParam("a") a: String
             , @RequestParam("b") b: String ): Any { // return Type Any 사용 가능
        data class res(val a: String, val b: String)
        return res(a, b)
    }
    
}