package com.dev.jk.design.patterns.prototype;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    private Manufacturer manufacturer;

    @Before
    public void setUp() {
        car = new Car();
        car.setModel("X5");
        manufacturer = new Manufacturer();
        manufacturer.setName("BMW");
        car.setManufacturer(manufacturer);
    }

    @Test
    public void cloneCar() throws CloneNotSupportedException {
        Car clonedCar = (Car) car.clone();
        assertThat(clonedCar).isNotNull();
        assertThat(clonedCar.getManufacturer()).isEqualTo(manufacturer);
        assertThat(clonedCar.getModel()).isEqualTo(car.getModel());
    }
}
