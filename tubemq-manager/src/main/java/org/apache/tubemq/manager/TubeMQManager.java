package org.apache.tubemq.manager;

import org.apache.tubemq.manager.backend.AbstractDaemon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TubeMQManager extends AbstractDaemon {
    public static void main(String[] args) throws Exception {
        TubeMQManager manager = new TubeMQManager();
        manager.startThreads();
        SpringApplication.run(TubeMQManager.class);
        // web application stopped, then stop working threads.
        manager.stopThreads();
        manager.join();
    }

    @Override
    public void startThreads() throws Exception {

    }

    @Override
    public void stopThreads() throws Exception {

    }
}
