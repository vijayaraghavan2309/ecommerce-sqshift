# echo "Dropping existing databases.."
# dropdb -U postgres -h localhost --if-exists ecomdb
# echo "Creating base databases"
# createdb -U postgres -h localhost  ecomdb

./gradlew clean build

java -Dspring.config.location=src/main/resources/application.yml  -jar build/libs/ecommerce-0.0.1-SNAPSHOT.jar