# Currency Converter

- Demo App for conversion currencies.

# Features

- Retrieving Exchange rates from external server
- Cashing
- Calculation
- Saving to h2 in-memory database history of requests
- Security configuration for CSRF, XSS and CSP
- Prometheus and Grafana monitoring system configuration
- Simple tests
- Exception handler
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

# Guide

- Run as a typical maven application. Can be imported into Intellij Idea and run there.
- Application starts in "http://localhost:8080/"
- Exchange rates will be retrieved from here: "https://api.exchangerate.host" (no subscription or registration needed)
- Rates will be retrieved only once and cached by this method: [ExchangeRateServiceImpl.getExchangeRates](
  src/main/java/com/assignment/currency_converter/service/exchange/rate/ExchangeRateServiceImpl.java)
- Caching Config here: [CachingConfig.java](src/main/java/com/assignment/currency_converter/config/CachingConfig.java)
- Main requests controller here: [ConversionController.java](src/main/java/com/assignment/currency_converter/controller/ConversionController.java)
- All errors and exceptions will be handled by [AppErrorController](src/main/java/com/assignment/currency_converter/controller/AppErrorController.java) and the error page will be shown
- There are some simple tests in the test package: [CurrencyConverterApplicationTests.java](src/test/java/com/assignment/currency_converter/CurrencyConverterApplicationTests.java)
- Supports CSRF, XSS and CSP security. Configurations: [SecurityConfiguration.java](src/main/java/com/assignment/currency_converter/config/SecurityConfiguration.java)
- Server calculation time provided by "Spring StopWatch" (almost always close to 0 because of cashing)
- Result of conversion formats by the "Java Currency Formatter"
- Conversion requests history is saved in h2 in-memory database
- Settings for cache, rates API, H2-db, Grafana and Prometheus here: [application.yml](src/main/resources/application.yml)
- Prometheus config: [prometheus.yml](data/prometheus/config/prometheus.yml)
- To run Grafana and Prometheus run [docker-compose.yml](docker-compose.yml) in the root dir.
- Prometheus: "http://localhost:9090", Grafana: "http://localhost:3000" (admin|admin)
- To set up Grafana data source you must write "prometheus:9090" in URL to access the Internal Docker network
- For test Grafana and Prometheus type "logback_events_total" in search field
- Frontend represents with thymeleaf by one template: [main.html](src/main/resources/templates/main.html) (simple html, no design,
  only for backend demo)
