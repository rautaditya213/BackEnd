package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

    @Bean(initMethod = "init", destroyMethod = "cleanup")
    public LifeCycleBean LifeCycleBean(@Qualifier("email") NotificationService notificationService) {
        return new LifeCycleBean(notificationService);
    }
}
