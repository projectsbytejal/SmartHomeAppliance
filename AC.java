public class AC implements Appliance {
    private String mode; // Can be "cooling", "heating", or "off"

    @Override
    public void turnOn() {
        mode = "cooling";
        System.out.println("Air Conditioner is set to cooling mode.");
    }

    @Override
    public void turnOff() {
        mode = "off";
        System.out.println("Air Conditioner is turned off.");
    }

    @Override
    public boolean isOn() {
        return !"off".equalsIgnoreCase(mode);
    }
    
    public void setMode(String mode) {
        if (mode.equalsIgnoreCase("cooling") || mode.equalsIgnoreCase("heating") || mode.equalsIgnoreCase("off")) {
            this.mode = mode;
            System.out.println("Air Conditioner is set to " + mode + " mode.");
        } else {
            System.out.println("Invalid mode.");
        }
    }
}

