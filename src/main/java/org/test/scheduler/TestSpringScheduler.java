package org.test.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
public class TestSpringScheduler {

    @Scheduled(cron = "#{@propsLoader.getCron}")
    public void scheduler() {
        String s = ThreadContext.get("logformat");
        log.info(s+ " Inside the scheduler ....." + this.getClass().getName());
    }
}
