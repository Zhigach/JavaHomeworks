package seminars.second.hw;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car testCar;
    Motorcycle testMotorcycle;

    @BeforeEach
    public void setupNewVehicles () {
        testCar = new Car("Test LTD", "Java", 2023);
        testMotorcycle = new Motorcycle("Java Ltd", "SE", 2022);
    }

    @AfterEach
    public void utilizeVehicles () {
        testCar = null;
    }

    @Test
    public void carIsVehicle() {
        assertTrue(testCar instanceof Vehicle);
    }

    @Test
    public void countCarWheels () {
        assertEquals(4, testCar.getNumWheels());
    }

    @Test
    public void countMotorcycleWheels () {
        assertEquals(2, testMotorcycle.getNumWheels());
    }

    @Test
    public void testCarSpeed() {
        testCar.testDrive();
        assertEquals(60, testCar.getSpeed());
    }

    @Test
    public void testMotorcycleSpeed() {
        testMotorcycle.testDrive();
        assertEquals(75, testMotorcycle.getSpeed());
    }

    @Test
    public void testCarParking() {
        testCar.testDrive();
        testCar.park();
        assertEquals(0, testCar.getSpeed());
    }

    @Test
    public void testMotorcycleParking() {
        testMotorcycle.testDrive();
        testMotorcycle.park();
        assertEquals(0, testMotorcycle.getSpeed());
    }


}