# ���ʹ�ñ�����?

## ����
>"��ǰ�����ǰ��������д��һ�������ļ��У����� Windows �µ� ini �ļ������� Linux �µ� conf �ļ���Ȼ�����ڷֲ�ʽϵͳ�£������ķ�ʽ�ͱ�÷ǳ����ù��������׳������ǣ�Ϊ�˱��ڹ�������������һ������ʽ�����ù���ϵͳ��������������ĵ�������" -- -- ���

�����������ģ�������ʵ�ʵ�ҵ�񳡾��У����������ǻ���Ƶ�����µĲ���������client�˵ķ�����Ҫ��֪����Щ�仯������ͬ��������Щ���á�client��Ҫ�ﵽ��Ŀ�ģ�����������ֲ�����������ȡ(Client������ȥ����������ȡ)�ͱ�������(��������Server���͸�Client��)��

**��ô���ѡ���أ�**

���ǵ��ֲ�ʽ�ļܹ��У�΢����Ļ���̫�࣬�������������͸�ÿ��Client��Ȼ��̫��ʵ�����ԣ����ý�Ϊ���õķ������Ե���Ϊ��Ҫ��client������ȥ��ȡ�ͺܷ�������Ը����

**client������ȡ��ʱ����**

ѡ����Client��������ȡ�ķ�����һ���µ���������������ǰ������ʲôʱ��ȥ��ȡ��
����Ĵ��Զ��׼����������ļ����ݷ��������ʱ��

**Spring Cloud BusӦ�˶���**

���ֳ�����ش�Һ���Ϥ������ʵ��һ�ֹ۲���ģ�ͣ�Ҳ�Ƿ�������ģʽ�ĵײ�˼�롣���ǽ����������ģ�͵ĳ����ֶΡ�
���۵��ˣ�����"�����Ƽ�����Ҳ"��������ͳ˼�룬����������ڹ��"��ɽ֮�񣬿��Թ�ʯ"���塣
Spring Cloud Bus ���ֲ�ʽ�Ľڵ�����������Ϣ��������������������ʵ��֪ͨ΢����ܹ��������ļ��ĸ��ĵȲ�����Ҳ�����ڼ�صȡ�
Spring bus��һ������˼����ͨ���ֲ�ʽ����������spring bootӦ�ý�����չ��Ҳ������������һ�����Ӧ��֮���ͨ��Ƶ����
ĿǰΨһʵ�ֵķ�ʽ����AMQP��Ϣ������Ϊͨ����ͬ�����Ե����ã���Щȡ����ͨ�������ã��ڸ���ͨ�����ĵ��С�

## �ܹ����
![](./doc/img/configbus2.jpg)

## ���̼��
- spring-cloud-eureka   ע�����Ĺ���
- spring-cloud-config-server  �������ķ���˹���
- spring-cloud-config-client  ��ȡ�����������õĿͻ��˹���

## ����Ҫ��
- jdk:1.8
- rabbitmq
- spring boot:2.1.7
- spring cloud:Greenwich.SR2

>Note:����ʹ��docker������װrabbitmq�����ڲ���.
> �μ���https://hub.docker.com/_/rabbitmq
> **��ȡ����:**
> ```
>  docker pull rabbitmq:3-management
> ```
> **��������**
>```
docker run -d --hostname my-rabbit --name rabbitmq -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=123456 -p 5672:5672 -p 15672:15672  rabbitmq:3-management
```

## ���з�ʽ
### ������ģʽ
> Note:
>   ������ʵ���ķ��� 
>   java -jar spring-cloud-config-client-0.0.1-SNAPSHOT.jar --server.port=8002 --spring.application.name=spring-cloud-config-client
>   java -jar spring-cloud-config-client-0.0.1-SNAPSHOT.jar -- server.port=8003 --spring.application.name=spring-cloud-config-client-2
>   java -jar spring-cloud-config-client-0.0.1-SNAPSHOT.jar -- server.port=8004 --spring.application.name=spring-cloud-config-client-3

### IDEA������



## �ο�
- [springcloud(��)���������ĺ���Ϣ���ߣ����������ս�棩](http://www.ityouknow.com/springcloud/2017/05/26/springcloud-config-eureka-bus.html)
- [Spring cloud֮/bus/refresh�ӿ�����](https://www.cnblogs.com/lzj123/p/9724499.html)


