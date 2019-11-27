package com.funtl.myshop.plus.message.consumer;

import com.funtl.myshop.plus.cloud.dto.UmsAdminLoginLogDTO;
import com.funtl.myshop.plus.provider.api.UmsAdminLoginLogService;
import com.funtl.myshop.plus.provider.domain.UmsAdminLoginLog;
import com.rabbitmq.client.Channel;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AdminLoginLogReceive {

    @Reference(version = "1.0.0")
    private UmsAdminLoginLogService umsAdminLoginLogService;

    //    @StreamListener("admin-login-log-topic")
//    @RabbitListener(queues = "atguigu.news")
//    public void receiveAdminLoginLog(String message) throws Exception {
////        UmsAdminLoginLog umsAdminLoginLog = MapperUtils.json2pojo(umsAdminLoginLogJson, UmsAdminLoginLog.class);
////        umsAdminLoginLogService.insert(umsAdminLoginLog);
//        UmsAdminLoginLog umsAdminLoginLog = new UmsAdminLoginLog();
//        BeanUtils.copyProperties(message, umsAdminLoginLog);
//        umsAdminLoginLogService.insert(umsAdminLoginLog);
//    }

    /**
     * 这是消费者监听消息的方法
     *
     * @param dto
     * @param channel
     * @throws Exception
     * @RabbitListener 是监听哪一个队列
     */
    @RabbitListener(queues = "atguigu.news")
    @RabbitHandler
    public void onMessage(@Payload UmsAdminLoginLogDTO dto, Channel channel, @Headers Map<String, Object> headers) throws Exception {
        System.err.println("--------------------------------------");
        //手工ACK，这一步尤为重要，因为在配置文件中配置了手动 ACK，所有需要有 ACK 的动作。
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
        UmsAdminLoginLog umsAdminLoginLog = new UmsAdminLoginLog();
        BeanUtils.copyProperties(dto, umsAdminLoginLog);
        umsAdminLoginLogService.insert(umsAdminLoginLog);
    }
}
