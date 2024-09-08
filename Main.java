import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create appliance objects
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        // Create the appliance controller
        ApplianceController controller = new ApplianceController(Arrays.asList(light, fan, ac));

        // Turn on all appliances for testing
        controller.turnOnAll();

        // Start the scheduler for yearly updates
        YearlyUpdateScheduler scheduler = new YearlyUpdateScheduler(controller);
        scheduler.startScheduler();

        // Create the main window (JFrame)
        JFrame frame = new JFrame("Smart Home Appliance Control");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 2, 10, 10)); // 3 rows, 2 columns layout

        // Create buttons and labels for the Light
        JLabel lightLabel = new JLabel("Light:");
        JButton lightOnButton = new JButton("Turn On");
        JButton lightOffButton = new JButton("Turn Off");

        lightOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                light.turnOn();
            }
        });

        lightOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                light.turnOff();
            }
        });

        // Create buttons and labels for the Fan
        JLabel fanLabel = new JLabel("Fan:");
        JButton fanOnButton = new JButton("Turn On");
        JButton fanOffButton = new JButton("Turn Off");

        fanOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fan.turnOn();
            }
        });

        fanOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fan.turnOff();
            }
        });

        // Create buttons and labels for the Air Conditioner
        JLabel acLabel = new JLabel("Air Conditioner:");
        JButton acOnButton = new JButton("Turn On");
        JButton acOffButton = new JButton("Turn Off");

        acOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ac.turnOn();
            }
        });

        acOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ac.turnOff();
            }
        });

        // Add components to the frame
        frame.add(lightLabel);
        frame.add(new JPanel()); // Empty cell
        frame.add(lightOnButton);
        frame.add(lightOffButton);

        frame.add(fanLabel);
        frame.add(new JPanel()); // Empty cell
        frame.add(fanOnButton);
        frame.add(fanOffButton);

        frame.add(acLabel);
        frame.add(new JPanel()); // Empty cell
        frame.add(acOnButton);
        frame.add(acOffButton);

        // Set the frame visible
        frame.setVisible(true);
    }
}
