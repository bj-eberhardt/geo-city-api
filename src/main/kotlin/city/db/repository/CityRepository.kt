package city.db.repository

import city.db.entity.City
import city.db.entity.CityDistanceDto
import io.micronaut.data.annotation.Query
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.MYSQL)
interface CityRepository : CrudRepository<City, Long> {
    @Query(
        "SELECT " +
            "c.name, c.latitude, c.longitude, c.state_code, " +
            "(6371 * acos(cos(radians(:latitude)) * cos(radians(c.latitude)) * " +
            "cos(radians(c.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(c.latitude)))) AS distance " +
            "FROM cities c " +
            "ORDER BY distance ASC " +
            "LIMIT :limit",
    )
    fun findNearestCities(
        latitude: Double,
        longitude: Double,
        limit: Int,
    ): List<CityDistanceDto>
}
