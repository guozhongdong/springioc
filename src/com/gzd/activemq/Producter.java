package com.gzd.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by gzd on 2017/7/6.
 * 发送方
 */
public class Producter {

   public static void main(String[] args){

        //创建工厂连接:jms用它创建连接
       ConnectionFactory connectionFactory ;
       // 客户端 到 jms 的连接
       //Provider 的连接
       Connection connection = null;
       // 一个的发送或者接收消息的线程
       Session session ;
       //消息目的地 消息发送给谁
       Destination destination;
       // 消息生产者
       MessageProducer messageProducer;
       //实例化连接工厂 通过activemq的jar实现
       connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
               ActiveMQConnection.DEFAULT_PASSWORD,"tcp://localhost:61616");

       try {
           //从工厂创建获取连接对象
           connection = connectionFactory.createConnection();
           // 启动
           connection.start();
           // 获取操作连接
           session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
           //获取消息目的地
           destination = session.createQueue("FirstQueue");
           //获取发送者
           messageProducer = session.createProducer(destination);
           // 设置持久化
           messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

           sendMessage(messageProducer,session);
           session.commit();
       } catch (JMSException e) {
           e.printStackTrace();
       }finally {
           if (null != connection){
               try {
                   connection.close();
               } catch (JMSException e) {
                   e.printStackTrace();
               }
           }
       }
   }


   public static void sendMessage(MessageProducer messageProducer,Session session) throws JMSException {

       for (int i = 1; i <= 5; i++) {
           TextMessage message = session.createTextMessage("ActiveMq 发送消息" + i);
           // 发送消息到目的地方
           System.out.println("发送消息:" + "ActiveMq 发送消息" + i);
           messageProducer.send(message);
       }

   }
}
