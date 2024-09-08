public class Light implements Appliance {
    private boolean isOn;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Light is turned on.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Light is turned off.");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}
