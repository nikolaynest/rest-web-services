### Spring initializer: https://start.spring.io/

### Tool for api calls: Chrome extension: 'Talend Api Tester'

### Integrated with springdoc-openapi, which is using openapi-3.0.1
Swagger UI can be found by the following URL:
http://localhost:8080/swagger-ui/index.html

Official documentation: https://springdoc.org/

### CONTENT NEGOTIATION - Different ContentType: Json, Xml or Different language representations
Accept header: application/json, application/xml
Accept-Language header: en, nl, fr,..
### Internationalization, I18n, Typically HTTP Request Header: Accept-Language is used

### Spring Actuator - allows to monitor the application with production-ready features:
http://localhost:8080/actuator
management.endpoints.web.exposure.include=*

### HAL Explorer - allows to see API with links in HAL format:
http://localhost:8080/explorer/index.html#
http://localhost:8080/explorer/index.html#uri=/actuator

