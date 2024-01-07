package com.springbatchapplication.config;


import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {
    private static final Logger log =
           LoggerFactory.getLogger(JobCompletionNotificationListener.class);
    @Override
    public void afterJob(JobExecution jobExecution) {

        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");
        }else {
            log.info("!!! JOB ERRORRR! ");
        }

    }


}