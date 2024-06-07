package city.db

import io.micronaut.runtime.Micronaut.run
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info =
        Info(
            title = "Cities API",
            version = "1.0",
            description = "Search for cities",
        ),
)
object Application

fun main(args: Array<String>) {
    run(*args)
}
