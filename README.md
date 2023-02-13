# Currency Converter

- Demo App for conversion currencies.

# Features

- Retrieving Exchange rates from external server
- Cashing
- Calculation
- Saving history of requests into h2 in-memory database
- Security configuration for CSRF, XSS and CSP
- Prometheus and Grafana monitoring system configuration
- Simple tests
- Errors handler
- Simple http page for demonstration results

# Stack

- java
- maven
- spring boot
- spring mvc
- spring security
- spring jpa
- spring test
- lombok
- thymeleaf
- tomcat
- h2-in-memory-db
- docker
- prometheus
- grafana

# How to run

- Run as a typical maven application. Can be imported into **Intellij Idea** and run there.
- Application starts in "**http://localhost:8080/**"
- On the main page select currencies for conversion, enter monetary value and press the submit-button: you will see
  formatted result of calculation, calculation time and table with the history of conversion requests

# Guide

## General App Settings

- Settings for cache, API, H2-db, Grafana, Prometheus, and some others are
  here: [application.yml](src/main/resources/application.yml)

## Controllers for requests

- Main requests controller
  here: [ConversionController.java](src/main/java/com/assignment/currency_converter/controller/ConversionController.java)
- All errors and exceptions will be handled
  by [AppErrorController](src/main/java/com/assignment/currency_converter/controller/AppErrorController.java) and the
  error page will be shown
- Rest Templates Config
  here: [RestTemplateConfig.java](src/main/java/com/assignment/currency_converter/config/RestTemplateConfig.java)

## Services

- All services are in this package: [service](src/main/java/com/assignment/currency_converter/service)

-
    - Retrieving exchange rates: [exchange.rate](src/main/java/com/assignment/currency_converter/service/exchange/rate)
-
    - Calculation: [calculation](src/main/java/com/assignment/currency_converter/service/calculation)
-
    - Storing and restoring data using a h2-in-memory
      database: [history](src/main/java/com/assignment/currency_converter/service/log/request/history)
-
    - Validation: [validation](src/main/java/com/assignment/currency_converter/service/validation)

## Security

- Supports CSRF, XSS and CSP security.
  Configurations: [SecurityConfiguration.java](src/main/java/com/assignment/currency_converter/config/SecurityConfiguration.java)

## Caching Exchange Rates

- Exchange rates will be retrieved from here: "**https://api.exchangerate.host**" (no subscription or registration
  needed)
- Rates will be retrieved only once and cached by this method: [ExchangeRateServiceImpl.getExchangeRates](
  src/main/java/com/assignment/currency_converter/service/exchange/rate/ExchangeRateServiceImpl.java)
- Caching Config here: [CachingConfig.java](src/main/java/com/assignment/currency_converter/config/CachingConfig.java)

## Grafana and Prometheus

- Prometheus config: [prometheus.yml](data/prometheus/config/prometheus.yml)
- To run Grafana and Prometheus run [docker-compose.yml](docker-compose.yml) in the root dir.
- Prometheus: "http://localhost:9090", Grafana: "http://localhost:3000" (admin | admin)
- To set up Grafana data source you must write "prometheus:9090" in URL to access the Internal Docker network
- For test Grafana and Prometheus type "logback_events_total" in search field

## Thymeleaf

- Frontend represents with thymeleaf by one template: [main.html](src/main/resources/templates/main.html) (simple html,
  no design, only for backend demo). There is a general error page as well.

## Tests

- There are some simple tests in the test
  package: [CurrencyConverterApplicationTests.java](src/test/java/com/assignment/currency_converter/CurrencyConverterApplicationTests.java)

## Others

- Server calculation time provided by "Spring StopWatch" (almost always close to 0 because of cashing)
- Result of conversion is formatted by the "Java Currency Formatter"
- Conversion requests history is saved in h2 in-memory database and will be shown on the main app page automatically
- JPA option "show-sql" is set to "true" only for debugging and testing convenience
- Default user is only for convenience as well. There is no login page needed in this case.
