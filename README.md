## Lab 1

Wrapper:

```
mvn -N io.takari:maven:wrapper 
```

Következő parancs végrehajtása:

```
cd C:\
mkdir training
cd training
git clone https://github.com/Training360/java-ci-2021-12-07
cd java-ci-2021-12-07\hello-world
set JAVA_HOME=C:\Program Files\Java\jdk-17.0.1
mvnw package
```

## Lab 2

```
git pull
cd C:\training\java-ci-2021-12-07
mvnw package
mvnw spring-boot:run
```

Elérhető a `http://localhost:8080/swagger-ui.html` 

```
mvnw versions:display-dependency-updates
mvnw dependency:tree
```

## Lab 3

* Tesztlefedettség

```
git pull
mvnw package
```

## Lab 4

* Integrációs tesztekről, H2 embedded db-vel

```
git pull
mvnw package
mvnw verify
```

## Lab 5

Adminisztrátorként indított parancssorban:

```
net localgroup docker-users %USERDOMAIN%\%USERNAME% /add
```

Tesztelni:

```
docker run hello-world
```

Adatbázis:

```
docker run -d -e MYSQL_DATABASE=employees  -e MYSQL_USER=employees -e MYSQL_PASSWORD=employees -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -p 3306:3306 --name employees-mariadb  mariadb
```

Átírni az `application.properties` fájlt.

## Lab 6

Integrációs teszt futtatása parancssori konfigurációval:

```
mvnw -Dspring.datasource.url=jdbc:mariadb://localhost/employees -Dspring.datasource.username=employees -Dspring.datasource.password=employees verify

mvnw -Dspring.datasource.url=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1 -Dspring.datasource.username=sa -Dspring.datasource.password=sa verify
```

## Lab 7 - Docker

NGINX indítása volume-mal:

```
docker run -d -p8080:80 -v %CD%\nginx-share:/usr/share/nginx/html --name my-nginx nginx
```

## Lab 8 - Saját Docker image

```
cd hello-world
docker build -t hello-world-java .
docker run hello-world-java
```

## Lab 9 - Saját employees Docker image

```
git pull
mvnw package
docker build -t employees .
docker run -d -p8080:8080 --name my-employees employees
```