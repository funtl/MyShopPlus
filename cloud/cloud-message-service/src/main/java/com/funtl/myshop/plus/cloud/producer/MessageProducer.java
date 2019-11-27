package com.funtl.myshop.plus.cloud.producer;

import com.funtl.myshop.plus.cloud.api.MessageService;
import com.funtl.myshop.plus.cloud.dto.UmsAdminLoginLogDTO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * 消息生产者
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-10-20 17:33:21
 * @see com.funtl.myshop.plus.cloud.producer
 */
@Component
@Service(version = "1.0.0")
public class MessageProducer implements MessageService, RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitMqConfig rabbitMqConfig;
    //    @Resource
//    private MessageSource source;
    @Autowired
    RabbitTemplate rabbitTemplate;

    // 标注了@PostConstruct注释的方法将在类实例化之后调用
    // 标注了@PreDestroy注释的方法将在类销毁之前调用
    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }
    // ack 为 true 表示正常，false 表示异常
//    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
//        @Override
//        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//            System.err.println("correlationData: " + correlationData);
//            System.err.println("ack: " + ack);
//            if (!ack) {
//                System.err.println("异常处理....");
//            }
//        }
//    };

    // 消息没有正确送到 Q 里，需要做额外的处理，这里的实现只是打印。
//    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
//        @Override
//        public void returnedMessage(org.springframework.amqp.core.Message message, int replyCode, String replyText,
//                                    String exchange, String routingKey) {
//            System.err.println("return exchange: " + exchange + ", routingKey: "
//                    + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
//        }
//    };

    //发送消息方法调用: 构建Message消息
    public void send(Object message, Map<String, Object> properties) throws Exception {
//        MessageHeaders mhs = new MessageHeaders(properties);
//        Message msg = MessageBuilder.createMessage(message, mhs);
        //id + 时间戳 全局唯一。 没有投递成功的时候可以通过这个值判断是哪个消息。
        CorrelationData correlationData = new CorrelationData("1234567890");

        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", message, correlationData);
    }

    // 发送消息
    public void send_1(String msgContent) {
        rabbitTemplate.convertAndSend(rabbitMqConfig.EXCHANG_NAME, rabbitMqConfig.BIND_KEY, msgContent);
    }

    /**
     * 管理登录日志
     *
     * @param dto {@link UmsAdminLoginLogDTO}
     * @return {@code boolean}
     */
//    @Override
//    public boolean sendAdminLoginLog(UmsAdminLoginLogDTO dto) {
//        return source.adminLoginLog().send(MessageBuilder.withPayload(dto).build());
//    }
    @Override
    public void sendAdminLoginLog(UmsAdminLoginLogDTO dto) {
        //对象被默认序列化以后发送出去
        //id + 时间戳 全局唯一。 没有投递成功的时候可以通过这个值判断是哪个消息。
        CorrelationData correlationData = new CorrelationData("1234567890");

        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", dto, correlationData);

//        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news",MessageBuilder.withPayload(dto).build());
    }

    // ack 为 true 表示正常，false 表示异常
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String s) {
        System.err.println("correlationData: " + correlationData);
        System.err.println("ack: " + ack);
        if (!ack) {
            System.err.println("异常处理....");
        }
    }

    // 消息没有正确送到 Q 里，需要做额外的处理，这里的实现只是打印。
    @Override
    public void returnedMessage(org.springframework.amqp.core.Message message, int replyCode, String replyText,
                                String exchange, String routingKey) {
        System.err.println("return exchange: " + exchange + ", routingKey: "
                + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
    }
}
