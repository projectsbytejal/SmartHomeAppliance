public class Fan implements Appliance {
    private int speed; // 0 = off, 1 = low, 2 = high

    @Override
    public void turnOn() {
        speed = 1;
        System.out.println("Fan is turned on at speed 1.");
    }

    @Override
    public void turnOff() {
        speed = 0;
        System.out.println("Fan is turned off.");
    }

    @Override
    public boolean isOn() {
        return speed > 0;
    }

    public void setSpeed(int speed) {
        if (speed >= 0 && speed <= 2) {
            this.speed = speed;
            System.out.println("Fan speed set to " + speed);
        } else {
            System.out.println("Invalid speed.");
        }
    }
}