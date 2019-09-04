# 如何使用本demo？

# 启动项目
1.启动spring-cloud-eureka项目

2.启动spring-cloud-zuul项目

3.启动spring-cloud-provider项目

4.启动zipkin server


命令行终端进入spring-cloud-sleuth-with-zipkin/doc/,执行如下命令:
```
  java -jar zipkin-server-2.9.4-exec.jar
```

# 测试
1.访问http://localhost:8888/provider/hello

2.浏览器打开:http://localhost:9411/  可以查看到调用链路信息.
