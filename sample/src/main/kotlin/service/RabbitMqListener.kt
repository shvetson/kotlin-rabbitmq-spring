package ru.shvets.rabbitmq.sample.service

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

    @RabbitListener(queues = ["\${rabbit.amqp.queue}"])
    fun processesMyQueue(message: String) {
        logger.info("Received from myQueue: {}", message)
    }
}