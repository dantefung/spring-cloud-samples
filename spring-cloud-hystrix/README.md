# ���ʹ�ñ�ʾ������?
## ����
  ��ʵ�ʵ�ҵ�񳡾��У�����֮��ĵ����Ǵ��۸��ӵģ��໥��������������Ĺ��ϻ������������ϣ��γ�ѩ��ЧӦ���������ȫϵͳ̱����

  ����ѩ��ЧӦ��һ���򡰷����ṩ�ߡ��Ĳ����õ��¡����������ߡ��Ĳ�����,�����������𽥷Ŵ�Ĺ��̡�
  
> ժ�ԡ���ν�׳��ĺ�˷���
> �������������ҵ���ô�죿���ǵ�ҵ��Ҳ���Źҵ�����Ȼ��������ϣ�������Ľ����������ƶ��ý����������ǽ�������
>
>  ����Ŀɿ��ԡ�
>
>  �������������Ի��Ƽ�����ʱ����Ҫ���û����Ļ�ȡ�û��ĸ��Ի����ݣ��Ա���뵽ģ������д�����򣬵�����û����ķ���ҵ������ǻ�ȡ���������ˣ���ô�Ͳ��Ƽ�����
>  
>  ��Ȼ���У����ǿ�����cache�����һ��������Ʒ�Ա㶵�ס�
>
>  ��Netflix ��Hystrix�۶������Ǳ�������߿��õ����һ�����ߡ�

> ժ��Spring Cloud�����ĵ�: [circuit_breaker_hystrix_clients](https://cloud.spring.io/spring-cloud-static/Greenwich.SR2/single/spring-cloud.html#_circuit_breaker_hystrix_clients)
> A service failure in the lower level of services can cause cascading failure all the way up to the user. 
> When calls to a particular service exceed circuitBreaker.requestVolumeThreshold (default: 20 requests) 
> and the failure percentage is greater than circuitBreaker.errorThresholdPercentage (default: >50%) 
> in a rolling window defined by metrics.rollingStats.timeInMilliseconds (default: 10 seconds), 
> the circuit opens and the call is not made. In cases of error and an open circuit, 
> a fallback can be provided by the developer.
![HystrixFallback](./doc/img/HystrixFallback.png)

> Having an open circuit stops cascading failures and allows overwhelmed or failing services time to recover. 
> The fallback can be another `Hystrix protected call`,`static data`, or `a sensible empty value`. 
> Fallbacks may be chained so that the first fallback makes some other business call, which in turn falls back to static data.


## ���̼��
- spring-cloud-consumer: ���������߹��̣�������Hystrix���ܡ�
- spring-cloud-eureka:  ע������
- spring-cloud-provider: �����ṩ�߹���

### �ص��ļ�
- application.yml �����˿���Hystrix����չ�Ķ��ɷ��ʱ�ע�Ĳο�����
- HelloClient.java  �ӿڣ�ʹ������ʽFeign����Ҫ���ʵķ���ӿ�
- HelloClientFallback.java  HelloClient��ʵ���ּ࣬���ṩ���񽵼��Ķ��׷����������Զ����Ĭ��ֵ��

## ��������
1.��������spring-cloud-eureka
2.����spring-cloud-consumer��spring-cloud-provider

>Note:Ĭ�Ϲ���ʦ������Spring Boot���̵�������ʽ��IDEA������������������������������⡣

## ����
### ��������
Step 1:  
http://localhost:8002/

�������ʾ��Ԥ�ڽ��: ����:Say hi~~

### ���ϲ���
Step 1: �ر�spring-cloud-provider����

Step 2: ���� http://localhost:8002 

�������ʾ��Ԥ�ڽ��: ����:Hystrix alert: Sorry, your request was rejected!

˵���۶����Ѿ�������ִ���˷��񽵼����ԡ�