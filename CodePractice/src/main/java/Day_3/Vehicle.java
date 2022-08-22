package Day_3;

public class Vehicle {
    private String manufacturer;
    private long mileage;
    private String currentGear;
    private int currentSpeed;
    private int maxSpeed;

    public Vehicle(){
        manufacturer = "";
        mileage = 0;
        currentGear = "";
        currentSpeed = 0;
        maxSpeed = 0;
    }

    public Vehicle(String manufacturer, long mileage, String currentGear, int currentSpeed, int maxSpeed){
        this.manufacturer = manufacturer;
        this.mileage = mileage;
        this.currentGear = currentGear;
        this.currentSpeed = currentSpeed;
        this.maxSpeed = maxSpeed;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public String getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(String currentGear) {
        this.currentGear = currentGear;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int accelerate(int speed){
        if(currentSpeed + speed > maxSpeed){
            System.out.println("Your current speed is " + currentSpeed + " you cannot accelerate " + speed + " as you will go over the max speed");
            return -1;
        }
        currentSpeed += speed;
        return currentSpeed;
    }

    public int decelerate(int speed){
        if(currentSpeed - speed < 0){
            System.out.println("Your current speed is " + currentSpeed + ", you cannot decelerate " + speed);
            return -1;
        }
        currentSpeed -= speed;
        return currentSpeed;
    }

    public String changeGears(String gear){
        currentGear = gear;
        return currentGear;
    }

    public String toString(){
        return String.format("Manufacturer: %s\nMileage: %o\nCurrent gear: %s\nCurrent speed: %o\nMax speed: %o\n", manufacturer, mileage, currentGear, currentSpeed, maxSpeed);
    }
}
