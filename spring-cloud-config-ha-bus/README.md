# 如何使用本工程?

## 背景
>"以前，我们把软件配置写在一个配置文件中，就像 Windows 下的 ini 文件，或是 Linux 下的 conf 文件。然而，在分布式系统下，这样的方式就变得非常不好管理，并容易出错。于是，为了便于管理，我们引入了一个集中式的配置管理系统，这就是配置中心的由来。" -- -- 陈皓

有了配置中心，我们在实际的业务场景中，配置内容是会有频繁更新的操作，对于client端的服务需要感知到这些变化，并且同步更新这些配置。client端要达到此目的，无外乎就两种操作，主动拉取(Client端主动去配置中心拉取)和被动接收(配置中心Server推送给Client端)。

**那么如何选择呢？**

考虑到分布式的架构中，微服务的机器太多，让配置中心推送给每个Client显然不太现实。所以，采用较为经济的方案就显得尤为重要，client端主动去拉取就很符合这种愿景。

**client主动拉取的时机？**

选择了Client端主动拉取的方案后，一个新的问题横隔在我们面前：到底什么时候去拉取？
问题的答案显而易见：当配置文件内容发生变更的时候。

**Spring Cloud Bus应运而生**

这种场景想必大家很熟悉，它其实是一种观察者模型，也是发布订阅模式的底层思想。它是解决这类问题模型的常用手段。
讨论到此，秉承"君子善假于物也"的优良传统思想，借以外力，诠释"他山之玉，可以攻石"奥义。
Spring Cloud Bus 将分布式的节点用轻量的消息代理连接起来。它可以实现通知微服务架构的配置文件的更改等操作，也可用于监控等。
Spring bus的一个核心思想是通过分布式的启动器对spring boot应用进行扩展，也可以用来建立一个多个应用之间的通信频道。
目前唯一实现的方式是用AMQP消息代理作为通道，同样特性的设置（有些取决于通道的设置）在更多通道的文档中。

## 架构设计
![](./doc/img/configbus2.jpg)

## 工程简介
- spring-cloud-eureka   注册中心工程
- spring-cloud-config-server  配置中心服务端工程
- spring-cloud-config-client  拉取配置中心配置的客户端工程

## 环境要求
- jdk:1.8
- rabbitmq
- spring boot:2.1.7
- spring cloud:Greenwich.SR2

>Note:建议使用docker环境安装rabbitmq，便于测试.
> 参见：https://hub.docker.com/_/rabbitmq
> **拉取镜像:**
> ```
>  docker pull rabbitmq:3-management
> ```
> **启动容器**
>```
docker run -d --hostname my-rabbit --name rabbitmq -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=123456 -p 5672:5672 -p 15672:15672  rabbitmq:3-management
```

## 运行方式
### 命令行模式
> Note:
>   启动多实例的方法 
>   java -jar spring-cloud-config-client-0.0.1-SNAPSHOT.jar --server.port=8002 --spring.application.name=spring-cloud-config-client
>   java -jar spring-cloud-config-client-0.0.1-SNAPSHOT.jar -- server.port=8003 --spring.application.name=spring-cloud-config-client-2
>   java -jar spring-cloud-config-client-0.0.1-SNAPSHOT.jar -- server.port=8004 --spring.application.name=spring-cloud-config-client-3

### IDEA下启动



## 参考
- [springcloud(九)：配置中心和消息总线（配置中心终结版）](http://www.ityouknow.com/springcloud/2017/05/26/springcloud-config-eureka-bus.html)
- [Spring cloud之/bus/refresh接口无用](https://www.cnblogs.com/lzj123/p/9724499.html)


