### Továbbfejlesztési lehetőségek

1. Biztonság: HTTPS implementáció, felhasználó autentikáció, jelszó titkosítás, API kulcs titkosítás kivitelezése.
2. Adatbázis: a jelenlegi in-memory adatbázis perzisztens adatbázisra cserélése. Ezzel együtt az id kiosztást is érdemes komolyabb, automatikus kiosztásra átállítani (pl @GeneratedValue(strategy = GenerationType.IDENTITY) annotációval), a jelenlegi saját metódus csak az adatbázisba feltöltendő kezdeti értékek miatt van így.
3. Loggolás: részletes logok készítése a könnyebb hibakeresés érdekében.
4. A jelenlegi hibakezelés bővítése, több lehetséges esetre való felkészítése.
5. Tesztek: end-to-end, integrációs, unit tesztek implementálása. 

