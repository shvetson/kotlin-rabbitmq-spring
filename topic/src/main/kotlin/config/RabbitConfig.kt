package ru.shvets.rabbitmq.topic.config

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

    @Bean // создаем соединение
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

    @Bean // определение очереди 1
    fun myQueue1(): Queue {
        return Queue("myQueue1")
    }

    @Bean // определение очереди 2
    fun myQueue2(): Queue {
        return Queue("myQueue2")
    }

    @Bean
    fun topicExchange(): TopicExchange {
        return TopicExchange("topic-exchange")
    }

    @Bean
    fun binding1(): Binding {
        return BindingBuilder
            .bind(myQueue1())
            .to(topicExchange())
            .with("one.*")
    }

    @Bean
    fun binding2(): Binding {
        return BindingBuilder
            .bind(myQueue2())
            .to(topicExchange())
            .with("*.second")
    }

//    @Bean
//    fun binding3(): Binding {
//        return BindingBuilder
//            .bind(myQueue2())
//            .to(directExchange())
//            .with("info")
//    }
}