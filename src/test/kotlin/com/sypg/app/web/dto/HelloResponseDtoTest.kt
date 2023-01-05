package com.sypg.app.web.dto



import org.junit.jupiter.api.Test

class HelloResponseDtoTest {
    @Test
    fun data_class_테스트() {
        // given
        val name = "test"
        val amount = 2000

        // when
        val dto = HelloResponseDto(name, amount)

        //then
        //prefer
        org.assertj.core.api.Assertions.assertThat(dto.name).isEqualTo(name)
        org.junit.jupiter.api.Assertions.assertEquals(dto.amount, amount)
    }
}