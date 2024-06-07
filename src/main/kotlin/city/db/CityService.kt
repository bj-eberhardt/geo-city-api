package city.db

import city.db.entity.CityDistanceDto
import city.db.repository.CityRepository
import io.micronaut.context.annotation.Context

@Context
class CityService(
    private val cityRepository: CityRepository,
) {
    fun getNearestCities(
        latitude: Double,
        longitude: Double,
        limit: Int,
    ): List<CityDistanceDto> = cityRepository.findNearestCities(latitude, longitude, limit)
}
