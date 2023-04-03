package ru.shvets.rabbitmq.sample.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.shvets.rabbitmq.sample.config.RabbitConfig

/**
 * @author  Oleg Shvets
 * @version 1.0
 * @date  02.04.2023 22:04
 */

@RestController
class DefaultController(
    private val template: AmqpTemplate,
) {
    val logger: Logger = LoggerFactory.getLogger(DefaultController::class.java)

    @Value("\${rabbit.amqp.queue}")
    val queue: String = ""

    @PostMapping("/emit")
    fun emit(@RequestBody message: String): ResponseEntity<String> {
        logger.info("Emit to myQueue")
        template.convertAndSend(queue, message)
        return ResponseEntity.ok("Success emit to queue")
    }
}