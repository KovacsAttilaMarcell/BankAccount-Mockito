# BankAccount – Mockito

## A projekt bemutatása

A projekt célja a korábban elkészített `BankAccount` osztály kibővítése egy értesítési szolgáltatással, valamint a külső függőségek tesztelése JUnit 5 és Mockito használatával.

A feladat során a Mockito segítségével ellenőrizhető, hogy a sikeres befizetéseket értesítés követi-e, illetve hogy sikertelen befizetés esetén nem történik értesítésküldés.

## Alkalmazott technológiák

- Java 27
- Maven
- JUnit 5.11.4
- Mockito 5.18.0
- IntelliJ IDEA
- Git és GitHub

## Megvalósított funkciók

### BankAccount

A `BankAccount` osztály a bankszámla kezelését valósítja meg:

- `deposit(double amount)` – befizetés.
- `withdraw(double amount)` – pénzfelvétel.
- `getBalance()` – aktuális egyenleg lekérdezése.

A hibás műveletek `IllegalArgumentException` kivételt eredményeznek, és nem változtatják meg a számla egyenlegét.

### NotificationService

A `NotificationService` interfész egy `send(String message)` metódust definiál, amely az értesítések küldésére szolgál.

A tesztekben valódi értesítési szolgáltatás helyett Mockito mock objektumot használunk.

### BankService

A `BankService` a bankszámlát és az értesítési szolgáltatást konstruktoron keresztül kapja meg (Dependency Injection).

Sikeres befizetés után meghívja a `NotificationService.send()` metódust.

Sikertelen befizetés esetén a művelet kivétellel megszakad, így nem történik értesítésküldés.

### ExchangeRateService

Az `ExchangeRateService` interfész a `getExchangeRate(String fromCurrency, String toCurrency)` metódust definiálja.

A tesztben a Mockito `when().thenReturn()` segítségével előre meghatározott, 400.0 értékű EUR/HUF árfolyamot állítunk be. Ez kizárólag tesztadat, nem aktuális piaci árfolyam.

## A projekt felépítése

```text
BankAccount-Mockito/
├── src/
│   ├── main/java/
│   │   ├── BankAccount.java
│   │   ├── BankService.java
│   │   ├── NotificationService.java
│   │   └── ExchangeRateService.java
│   └── test/java/
│       ├── BankAccountTest.java
│       ├── BankServiceTest.java
│       └── ExchangeRateServiceTest.java
├── pom.xml
├── .gitignore
└── README.md
```

## A projekt futtatása és tesztelése

A projekt futtatásához Java 27 JDK és Maven szükséges.

1. Klónozd vagy töltsd le a GitHub-repositoryt.
2. Nyisd meg IntelliJ IDEA-ban.
3. Várd meg a Maven-függőségek betöltését.
4. Nyisd meg a projekt terminálját.
5. Futtasd a következő parancsot:

```bash
mvn clean test
```

A tesztek IntelliJ IDEA-ban közvetlenül a tesztosztályokból is futtathatók.

## Egységtesztek

A projekt összesen **16 JUnit 5 tesztet** tartalmaz.

| Tesztosztály | Tesztek száma | Ellenőrzött működés |
|---|---:|---|
| `BankAccountTest` | 10 | Bankszámlaműveletek és hibakezelés |
| `BankServiceTest` | 5 | Befizetés és értesítésküldés |
| `ExchangeRateServiceTest` | 1 | Mockolt árfolyamérték |

## Alkalmazott Mockito-metódusok

- **`mock()`** – külső függőségek helyettesítése mock objektumokkal.
- **`verify()`** – metódushívások és paraméterek ellenőrzése.
- **`when().thenReturn()`** – előre meghatározott válaszérték beállítása.

A tesztek nem használnak valódi külső értesítési vagy árfolyamlekérdező szolgáltatást.

## Tesztelési eredmény

A `mvn clean test` parancs végrehajtásakor mind a 16 teszt sikeresen lefutott, hiba nélkül.