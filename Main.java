import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Create appliance objects
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        // Create the appliance controller
        ApplianceController controller = new ApplianceController(Arrays.asList(light, fan, ac));

        // Create the main window (JFrame)
        JFrame frame = new JFrame("Tejal's Smart Home Appliance Control");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns layout

        // LIGHT CONTROL
        JLabel lightLabel = new JLabel("Light:");
        JButton lightOnButton = new JButton("Turn On");
        JButton lightOffButton = new JButton("Turn Off");

        lightOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                light.turnOn();
                JOptionPane.showMessageDialog(frame, "Light is turned on.");
            }
        });

        lightOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                light.turnOff();
                JOptionPane.showMessageDialog(frame, "Light is turned off.");
            }
        });

        // FAN CONTROL
        JLabel fanLabel = new JLabel("Fan (Speed 0-2):");
        JButton fanOnButton = new JButton("Turn On");
        JButton fanOffButton = new JButton("Turn Off");
        
        JComboBox<Integer> fanSpeedComboBox = new JComboBox<>(new Integer[]{0, 1, 2});

        fanOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fan.turnOn();
                JOptionPane.showMessageDialog(frame, "Fan is turned on at speed 1.");
            }
        });

        fanOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fan.turnOff();
                JOptionPane.showMessageDialog(frame, "Fan is turned off.");
            }
        });

        fanSpeedComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int speed = (int) fanSpeedComboBox.getSelectedItem();
                if(speed==0){
                    JOptionPane.showMessageDialog(frame, "Fan is turned OFF");
                }else{
                    JOptionPane.showMessageDialog(frame, "Fan speed set to " + speed);
                }
                fan.setSpeed(speed);
              
            }
        });

        // AIR CONDITIONER CONTROL
        JLabel acLabel = new JLabel("Air Conditioner Thermostat:");
        JButton acOnButton = new JButton("Turn On");
        JButton acOffButton = new JButton("Turn Off");

        acOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ac.turnOn();
                JOptionPane.showMessageDialog(frame, "Air Conditioner is set to cooling mode.");
            }
        });

        acOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ac.turnOff();
                JOptionPane.showMessageDialog(frame, "Air Conditioner is turned off.");
            }
        });

        // RESET BUTTON
        JButton resetButton = new JButton("Reset All");
        resetButton.setBackground(Color.RED);
        resetButton.setSize(5, 2);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.turnOffAll();
                fanSpeedComboBox.setSelectedItem(0);
                JOptionPane.showMessageDialog(frame, "All appliances have been reset to off.");
            }
        });

        // Add components to the frame
        frame.add(lightLabel);
        frame.add(new JPanel()); // Empty cell
        frame.add(lightOnButton);
        frame.add(lightOffButton);

        frame.add(fanLabel);
        frame.add(fanOnButton);
        frame.add(fanSpeedComboBox); // Fan speed control // Empty cell
        frame.add(fanOffButton);        
        

        frame.add(acLabel);
        frame.add(new JPanel()); // Empty cell
        frame.add(acOnButton);
        frame.add(acOffButton);

        frame.add(new JPanel()); // Empty cell
        frame.add(resetButton); // Reset button

        // SCHEDULER (Yearly Update Simulation)
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            controller.turnOffAll();
            JOptionPane.showMessageDialog(frame, "Yearly update completed: All appliances turned off for maintenance.");
        }, 5, 10, TimeUnit.MINUTES); // Adjust to simulate the yearly update (set to every 10 seconds for testing)

        // Set the frame visible
        frame.setVisible(true);
    }
}
