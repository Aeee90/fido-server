package aeee.api.rp.config

import com.webauthn4j.converter.util.JsonConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WebAuthConfig {

    @Bean
    fun jsonConverter() = JsonConverter()
}