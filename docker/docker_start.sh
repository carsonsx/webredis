docker run --name webredis --net mynet --restart=always -v "$PWD":/usr/src/webredis -w /usr/src/webredis -d -p8080:8080 java java -jar webredis.jar --spring.profiles.active=prod
