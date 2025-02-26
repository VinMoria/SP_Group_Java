借由此项目学习Java框架，计划包括
1. Spring ✔
2. SpringBoot ✔
3. Spring Cloud
4. MyBatis ✔
5. Hibernate
6. K8s
7. Redis ✔
8. SQL优化
9. Hadoop
10. Spark

## 备忘录：
数据库的用户名与密码可以配置系统的环境变量（需要在application.yml中指定）:

DB_USERNAME

DB_PASSWORD

环境变量优先级：Spring Boot 会按照以下顺序查找配置：
1. 系统环境变量
2. application.yml 或 application.properties 中的配置
3. 命令行参数（如 --DB_USERNAME=root）