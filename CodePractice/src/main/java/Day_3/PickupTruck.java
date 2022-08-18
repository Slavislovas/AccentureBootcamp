package Day_3;

public class PickupTruck extends Car {
    private double cargoSpaceInKg;

    public PickupTruck(){
     cargoSpaceInKg = 0;
    }

    public PickupTruck(String manufacturer, long mileage, String currentGear, int currentSpeed, int maxSpeed, int currentFuel, int maxFuel, String fuelType, double cargoSpaceInKg){
        super(manufacturer, mileage, currentGear, currentSpeed, maxSpeed, currentFuel, maxFuel, fuelType);
        this.cargoSpaceInKg = cargoSpaceInKg;
    }
    @Override
    public String toString(){
        return super.toString() + String.format("Cargo space in kg: %f\n", cargoSpaceInKg);
    }
}
