package Day_3;

public class Car extends Vehicle {
    private int currentFuel;
    private int maxFuel;
    private String fuelType;

    public Car(){
        currentFuel = 0;
        maxFuel = 0;
        fuelType = "";
    }

    public Car(String manufacturer, long mileage, String currentGear, int currentSpeed, int maxSpeed, int currentFuel, int maxFuel, String fuelType){
        super(manufacturer, mileage, currentGear, currentSpeed, maxSpeed);
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
        this.fuelType = fuelType;
    }


    public int getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString(){
        return super.toString() + String.format("Current fuel: %o\nMax fuel: %o\nFuel type: %s\n", currentFuel, maxFuel, fuelType);
    }
}
