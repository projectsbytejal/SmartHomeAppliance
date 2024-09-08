import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ApplianceController {
    private List<Appliance> appliances;

    public ApplianceController(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    public void turnOffAll() {
        System.out.println("Turning off all appliances...");
        for (Appliance appliance : appliances) {
            appliance.turnOff();
        }
    }

    public void turnOnAll() {
        System.out.println("Turning on all appliances...");
        for (Appliance appliance : appliances) {
            appliance.turnOn();
        }
    }

    // Schedule system update on January 1st at 1:00 AM
    public void scheduleYearlyUpdate() {
        LocalDateTime now = LocalDateTime.now();
        String currentTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        if (currentTime.equals("2024-01-01 01:00")) {
            System.out.println("Yearly update in progress...");
            turnOffAll();
            System.out.println("System updated. Appliances are now turned off.");
        }
    }
}
