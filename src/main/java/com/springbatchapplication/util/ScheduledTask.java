package com.springbatchapplication.util;

import com.springbatchapplication.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduledTask {

    private final RefundService refundService;

    @Scheduled(cron = "0 49 23 * * ?")
    public void performScheduledRefunds() throws Exception {
        refundService.performRefunds();
    }
}




