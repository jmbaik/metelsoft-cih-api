# 운영에서 설치
```agsl
java -Dspring.profiles.active=prod -jar springprj-0.0.1.jar
```
## 애플리케이션 프러퍼티 파일을 프로파일별로 만든다.
- appliation.properties application-dev.properties application-prod.properties
---

## 애플리케이션 프로파일에서 프로파일을 활성화 시킨다
application.properties 
```agsl
srping.profiles.active=dev
```
--- 
