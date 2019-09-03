使用Spring Boot 2.x版本后，官方直接提供了编译好的jar包来给我们使用，比如本范例使用的jar包是zipkin-server-2.9.4-exec.jar

        到 https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/ 下载相应的jar包。

        执行 java -jar zipkin-server-2.9.4-exec.jar 命令启动Zipkin Server，端口默认是9411