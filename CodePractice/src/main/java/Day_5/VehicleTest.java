package Day_5;

import Day_3.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void accelerate() {
        Vehicle vehicle = new Vehicle("Mercedes-benz", 100000, "N", 0, 220);
        assertAll( () -> assertEquals(10, vehicle.accelerate(10)),
                () -> assertEquals(50, vehicle.accelerate(40)),
                () -> assertEquals(-1, vehicle.accelerate(1000)));
    }

    @Test
    void decelerate() {
        Vehicle vehicle = new Vehicle("Mercedes-benz", 100000, "N", 200, 220);
        assertAll( () -> assertEquals(100, vehicle.decelerate(100)),
                () -> assertEquals(50, vehicle.decelerate(50)),
                () -> assertEquals(-1, vehicle.decelerate(51)));
    }

    @Test
    void changeGears() {
        Vehicle vehicle = new Vehicle("Mercedes-benz", 100000, "N", 200, 220);
        assertAll( () -> assertEquals("1", vehicle.changeGears("1")),
                () -> assertEquals("5", vehicle.changeGears("5")),
                () -> assertEquals("R", vehicle.changeGears("R")));
    }
}