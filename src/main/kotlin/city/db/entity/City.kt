package city.db.entity

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal

@MappedEntity("cities")
@Serdeable
data class City(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var name: String,
    var stateId: Int,
    var stateCode: String,
    var countryId: Int,
    var countryCode: String,
    var latitude: BigDecimal,
    var longitude: BigDecimal,
)

@Serdeable
data class CityDistanceDto(
    @field:Schema(description = "Cityname / City district name")
    var name: String,
    var latitude: BigDecimal,
    var longitude: BigDecimal,
    @field:Schema(description = "Code of the state in capital characters")
    var stateCode: String,
    @field:Schema(description = "Distance in km")
    var distance: Double,
)
