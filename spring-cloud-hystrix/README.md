# 如何使用本示例工程?
## 背景
  在实际的业务场景中，服务之间的调用是错综复杂的，相互依赖，基础服务的故障会引发级联故障，形成雪崩效应，最终造成全系统瘫痪。

  服务雪崩效应是一种因“服务提供者”的不可用导致“服务消费者”的不可用,并将不可用逐渐放大的过程。
  

> 如果第三方服务挂掉怎么办？我们的业务也跟着挂掉？显然不是我们希望看到的结果，如果能制定好降级方案，那将大大提高

  服务的可靠性。

  比如我们做个性化推荐服务时，需要从用户中心获取用户的个性化数据，以便代入到模型里进行打分排序，但如果用户中心服务挂掉，我们获取不到数据了，那么就

  不推荐了吗？显然不行，我们可以在cache里放置一份热门商品以便兜底。

  而Netflix 的Hystrix熔断器就是保护服务高可用的最后一道防线。

## 工程简介
- spring-cloud-consumer: 服务消费者工程，开启了Hystrix功能。
- spring-cloud-eureka:  注册中心
- spring-cloud-provider: 服务提供者工程

### 重点文件
- application.yml 配置了开启Hystrix，扩展阅读可访问备注的参考链接
- HelloClient.java  接口，使用声明式Feign定义要访问的服务接口
- HelloClientFallback.java  HelloClient的实现类，旨在提供服务降级的兜底方案，返回自定义的默认值。

## 启动工程
1.优先启动spring-cloud-eureka
2.启动spring-cloud-consumer、spring-cloud-provider

>Note:默认工程师掌握了Spring Boot工程的启动方式。IDEA环境启动或命令行启动，诸君请随意。

## 测试
### 正常测试
Step 1:  
http://localhost:8002/

浏览器显示的预期结果: 返回:Say hi~~

### 故障测试
Step 1: 关闭spring-cloud-provider服务

Step 2: 访问 http://localhost:8002 

浏览器显示的预期结果: 返回:Hystrix alert: Sorry, your request was rejected!

说明熔断器已经开启并执行了服务降级策略。