# ideal-umbrella

## modules
- maven-archetype-springboot
- ideal-eureka



## 记录

- Eureka Client Dependency 不支持 Spring Webflux 

Spring Webflux including spring-cloud-starter-eureka breaks endpoints

Time when I run my application With Eureka Client Dependency.
 Only Annotation based rest calls are working fine and Functional based calls returning 404..