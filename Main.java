import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();
        AC ac = new AC();

        ApplianceController controller = new ApplianceController(Arrays.asList(light, fan, ac));

        // Turn on all appliances for testing
        controller.turnOnAll();

        // Start the scheduler for yearly updates
        YearlyUpdateScheduler scheduler = new YearlyUpdateScheduler(controller);
        scheduler.startScheduler();
    }
}
