# 如何使用本示例工程?

## 工程简介
- spring-cloud-consumer: 服务消费者工程 
- spring-cloud-eureka:  注册中心
- spring-cloud-provider: 服务提供者工程

## 启动工程
1.优先启动spring-cloud-eureka
2.启动spring-cloud-consumer、spring-cloud-provider

>Note:默认工程师掌握了Spring Boot工程的启动方式。IDEA环境启动或命令行启动，诸君请随意。

## 测试
1. 测试@Autowired方式注入Feign
http://localhost:8002/

2.测试通过Feign Build API手动构建Feign
http://localhost:8002/myfoo
