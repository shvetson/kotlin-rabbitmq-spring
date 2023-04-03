package ru.shvets.rabbitmq.sample.config

import org.springframework.amqp.core.*
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitAdmin
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

/**
 * @author  Oleg Shvets
 * @version 1.0
 * @date  02.04.2023 09:47
 */

@Configuration
class RabbitConfig {

    @Value("\${rabbit.amqp.hostname}")
    val hostname: String = ""

    @Value("\${rabbit.amqp.queue}")
    val queue: String = ""

    @Bean
    fun connectionFactory(): ConnectionFactory {
        return CachingConnectionFactory(hostname)
    }

    @Bean
    fun amqpAdmin(): AmqpAdmin {
        return RabbitAdmin(connectionFactory())
    }

    @Bean
    fun rabbitTemplate(): RabbitTemplate {
        return RabbitTemplate(connectionFactory())
    }

    @Bean
    fun myQueue(): Queue {
        return Queue(queue)
    }
}