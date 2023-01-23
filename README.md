# Currency Converter

# Stack
- java
- maven
- spring boot
- spring mvc
- spring security
- spring test
- lombok
- thymeleaf
- tomcat
- docker
- prometheus
- grafana

# Guide
- Run as a typical maven application. Can be imported into intellij idea and run there.
- Application starts in "http://localhost:8080/"
- Exchange rates will be retrieved from here: "https://api.exchangerate.host" (no subscription or registration needed)
- Rates will be retrieved only once and cached by this method: "com.assignment.currency_converter.service.ExchangeRateServiceImpl.getRates"
- Server calculation time provided by "Spring StopWatch" (almost always close to 0 because of cashing)
- Result formats by the "Java Currency Formatter"
- Supports CSRF, XSS and CSP security. Configurations: "com.assignment.currency_converter.config.SecurityConfiguration"
- Prometheus config: "data/config/prometheus.yaml"
- To run Grafana and Prometheus run "docker-compose.yml" in the root dir.
- Prometheus: "http://localhost:9090", Grafana: "http://localhost:3000" (admin|admin)
- To set up Grafana data source you must write "prometheus:9090" in URL to access the Internal Docker network
- For test Grafana and Prometheus type "logback_events_total" in search field
- Settings for cache, rates API, Grafana and Prometheus here: "src/main/resources/application.yml"
- Frontend represents with thymeleaf by one template: "src/main/resources/templates/main.html" (simple html, no design, only for backend demo)
- All errors and exceptions will be handled by "AppErrorController" and the error page will be shown
- There are some simple tests in the test package: "CurrencyConverterApplicationTests.java"