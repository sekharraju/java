package com.dev.jk.design.patterns.prototype;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeFactoryImplTest {

    private PrototypeFactory prototypeFactory;

    @Before
    public void setUp() {
        prototypeFactory = new PrototypeFactoryImpl();
    }

    @Test
    public void testCarPrototype() throws CloneNotSupportedException {
        Car car1 = prototypeFactory.createPrototype(Car.class);
        Car car2 = prototypeFactory.createPrototype(Car.class);
        assertThat(car1).isNotNull();
        assertThat(car2).isNotNull();
        assertThat(car1).isNotEqualTo(car2);
        assertThat(car1.getManufacturer()).isNotNull();
        assertThat(car1.getManufacturer()).isEqualTo(car2.getManufacturer());
    }

    @Test
    public void testBikePrototype() throws CloneNotSupportedException {
        Bike bike1 = prototypeFactory.createPrototype(Bike.class);
        Bike bike2 = prototypeFactory.createPrototype(Bike.class);
        assertThat(bike1).isNotNull();
        assertThat(bike2).isNotNull();
        assertThat(bike1).isNotEqualTo(bike2);
        assertThat(bike1.getManufacturer()).isNotNull();
        assertThat(bike1.getManufacturer()).isEqualTo(bike2.getManufacturer());
    }
}
