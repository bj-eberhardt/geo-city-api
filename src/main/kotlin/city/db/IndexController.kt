package city.db

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.swagger.v3.oas.annotations.Hidden
import java.net.URI

@Controller
@Hidden
class IndexController {
    @Get
    fun redirectIndex(): HttpResponse<Any> = HttpResponse.redirect(URI.create("/swagger-ui"))
}
