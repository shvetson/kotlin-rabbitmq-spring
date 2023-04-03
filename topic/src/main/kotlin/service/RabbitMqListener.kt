package ru.shvets.rabbitmq.topic.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

/**
 * @author  Oleg Shvets
 * @version 1.0
 * @date  03.04.2023 14:56
 */

@EnableRabbit
@Component
class RabbitMqListener {
    private val logger: Logger = LoggerFactory.getLogger(RabbitMqListener::class.java)

    @RabbitListener(queues = ["myQueue1"])
    fun processesMyQueue1(message: String) {
        logger.info("Received first from myQueue: {}", message)
    }

    @RabbitListener(queues = ["myQueue2"])
    fun processesMyQueue2(message: String) {
        logger.info("Received second from myQueue: {}", message)
    }
}