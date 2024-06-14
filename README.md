# Cities API

Offers an API to get from a known location (geo: lat, lng) the nearest cities without
need of any remote webservice or internet connection.

It's using the cities database from: https://github.com/dr5hn/countries-states-cities-database/
If you need a more precise database, checkout [geonames-api](https://github.com/bj-eberhardt/geonames-api)


## Development

Deploy a local mysql database, for example via docker: 
`docker run --env=MYSQL_DATABASE=cities --env=MYSQL_USER=cities --env=MYSQL_PASSWORD=password --env=MYSQL_ROOT_PASSWORD=password  --volume=/var/lib/mysql -p 33060:3306 --restart=no -d mysql:8.0`
that exposes the port 33060 on localhost, otherwise modify the file _"[application.properties](src/main/resources/application.properties)"_.

Start using ```./gradle run```. The server is available at http://127.0.0.1.8080/


### Update city list

Fetch the newest list from
https://github.com/dr5hn/countries-states-cities-database/blob/master/sql/cities.sql
and place the file into the folder "resources/db/migration". Name it "V{X}__cities.sql",
where X is to be increased by 1 and represents the version.

On next startup, the database will be migrated and updated automatically.


## Building

Build using ```./gradle dockerBuild``` or as native image ```./gradle dockerBuildNative```.

It's creating a docker image named: _geo-city-api:latest_ 

## Deploying

Use the docker compose file in  [city-api-stack](city-api-stack/docker-compose.yml).
It creates a new stack exposing the api on http://127.0.0.1.15000/ and also starts a mysql database.




## License

Open Data Commons Open Database License v1.0
