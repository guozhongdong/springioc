package com.gzd.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by gzd on 2017/7/6.
 * 接收消息方，消费者
 */
public class Customer {

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
        //消息接收方
        MessageConsumer consumer ;
        //实例化 连接工厂
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,"tcp://localhost:61616");

        try {
            //创建连接
            // 从工厂获取连接对象
            connection = connectionFactory.createConnection();
            // 启动
            connection.start();
            // 获取操作连接
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在ActiveMq的console配置
            // 获取消息目的地:队列
            destination = session.createQueue("FirstQueue");
            // 接收消息对象
            consumer = session.createConsumer(destination);
            while (true){
                TextMessage message = (TextMessage) consumer.receive(100000);
                System.out.println("message："+message);
                if(null != message){
                    System.out.println("接收到的消息==="+message.getText());
                }else{
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (null != connection){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
