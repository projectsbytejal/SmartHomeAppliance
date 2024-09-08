import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class YearlyUpdateScheduler {
    private ApplianceController controller;

    public YearlyUpdateScheduler(ApplianceController controller) {
        this.controller = controller;
    }

    public void startScheduler() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        // Schedule for once a year (simulating every minute for demo purposes)
        scheduler.scheduleAtFixedRate(() -> {
            controller.scheduleYearlyUpdate();
        }, 0, 1, TimeUnit.MINUTES); // Replace with appropriate year interval in production
    }
}
