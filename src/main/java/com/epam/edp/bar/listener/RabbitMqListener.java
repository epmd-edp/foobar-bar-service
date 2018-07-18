package com.epam.edp.bar.listener;

import com.epam.edp.bar.config.RabbitMqConfig;
import com.epam.edp.bar.service.BarService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Pavlo_Yemelianov
 */
@Component
public class RabbitMqListener {

    @Autowired
    private BarService barService;

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void listenBroker(String message) {
        barService.updateFooConfig(message);
    }

}
