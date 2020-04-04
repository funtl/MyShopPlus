package com.funtl.myshop.plus.cloud.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PackgeName: com.funtl.myshop.plus.cloud.producer
 * @ClassName: RabbitMqConfig
 * @Author: Administrator
 * Date: 2019/11/27 0027 22:04
 * project name: MyShopPlus
 * @Version:
 * @Description:
 */
@Configuration
public class RabbitMqConfig {
    // 队列名称
    @Value("${spring.rabbitmq.Q_NAME}")
    public String Q_NAME;
    // 交换机名称
    @Value("${spring.rabbitmq.EXCHANG_NAME}")
    public String EXCHANG_NAME;
    // 绑定的值
    @Value("${spring.rabbitmq.BIND_KEY}")
    public String BIND_KEY;

    // 定义队列,第二个参数是表示持久化
    @Bean
    Queue queue() {
        return new Queue(Q_NAME, true);
    }

    // 定义交换机,第二个参数是表示持久化，第三个参数表示当最后一个绑定被解绑的时候，不会自动删除该 exchange
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANG_NAME, true, false);
    }

    // 绑定队列和交换机，因为是 TopicExchange
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BIND_KEY);
    }
}
