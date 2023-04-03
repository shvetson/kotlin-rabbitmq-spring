package ru.shvets.rabbitmq.model

import java.io.Serializable
import kotlinx.datetime.*

/**
 * @author  Oleg Shvets
 * @version 1.0
 * @date  01.04.2023 21:01
 */

data class ToDo(
    var id: Long? = null,
    var description: String? = null,
    var completed: Boolean? = false,
): Serializable