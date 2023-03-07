# Job search app – álláskereső alkalmazás

## Az alkalmazás elindítása

Az alkalmazás legegyszerűbben mavennel futtatható:

```mvn spring-boot:run```

Készítettem hozzá json fileokat, hogy egyből ki lehessen próbálni az alkalmazást. POST és GET requesteket az alábbi curl parancsokkal lehet küldeni:

* POST: kliens létrehozása

```curl -X POST -H "Content-Type: application/json" -d "@src/main/resources/sample-requests/create-client.json" http://localhost:8080/api/job-search-app/client```

* POST: pozíció létrehozása

```curl -X POST -H "Content-Type: application/json" -d "@src/main/resources/sample-requests/create-position.json" http://localhost:8080/api/job-search-app/position```

* GET: állások keresése
  
```curl -X GET -H "x-api-key: 43f24650-941b-4a8a-b3b6-899735c6ec6e" "http://localhost:8080/api/job-search-app/position/search?keyword=developer&location=budapest"```

* GET: adott állás megtekintése

```curl -X GET http://localhost:8080/api/job-search-app/position/7```

In-memory H2 adatbázist használtam, a kezdeti adatfeltöltést flyway segítségével oldottam meg. Az egyszerűség kedvéért a fenti requestekben használt API kulcsot beleírtam a migrációs sql fileba, az összes többi UUID random generálódik.

A fentieken kívül swagger-ui is rendelkezésre áll requestek küldéséhez és alapvető dokumentáció gyanánt.
