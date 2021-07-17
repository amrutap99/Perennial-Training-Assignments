package edu.ritindia.CovidSystem.scheduler;

import edu.ritindia.CovidSystem.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 *This is Scheduler Class
 */
@EnableScheduling
@Component
public class Scheduler {

    @Autowired
    private CovidDataService coronaService;

    /**
     * @throws IOException
     * @throws InterruptedException
     * @author Amruta Patil
     * Description :This method is used for Scheduling execution of task
     */
    @Scheduled(cron = "1 * * * * *")
    public void invokeScheduler() throws IOException, InterruptedException {
        coronaService.getData();

    }

}
