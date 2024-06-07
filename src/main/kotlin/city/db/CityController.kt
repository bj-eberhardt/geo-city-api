package city.db

import city.db.entity.CityDistanceDto
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

@Controller("/cities")
open class CityController(
    private val cityService: CityService,
) {
    @Operation(
        summary = "Returns the cities around a position",
        description =
            "Returns the cities in the distance of the given position." +
                " The result list is already ordered by distance ascending",
    )
    @Get
    open fun getNearest(
        @Parameter(description = "Latitude", example = "53.55")
        @QueryValue latitude: Double,
        @Parameter(description = "Longitude", example = "10.00")
        @QueryValue longitude: Double,
        @Parameter(description = "Limits the results.")
        @Min(0)
        @Max(100)
        @QueryValue(defaultValue = "10") limit: Int,
    ): NearestCitiesResponse = NearestCitiesResponse(cityService.getNearestCities(latitude, longitude, limit))

    @Serdeable
    data class NearestCitiesResponse(
        @field:Schema(description = "Resulting items, sorted by distance ascending")
        val list: List<CityDistanceDto>,
        @field:Schema(description = "Number of fetched items")
        val size: Int,
    ) {
        constructor(items: List<CityDistanceDto>) : this(items, items.size)
    }
}
