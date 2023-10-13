package factory_design_pattern;

// Абстрактный класс, представляющий транспортное средство
abstract class Vehicle {
    public abstract int getNumberOfWheels();

    @Override
    public String toString() {
        return "Number of Wheels: " + this.getNumberOfWheels();
    }
}

// Класс, представляющий автомобиль
class Car extends Vehicle {
    private int numberOfWheels;

    Car(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public int getNumberOfWheels() {
        return this.numberOfWheels;
    }
}

// Класс, представляющий велосипед
class Bike extends Vehicle {
    private int numberOfWheels;

    Bike(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public int getNumberOfWheels() {
        return this.numberOfWheels;
    }
}

// Фабричный класс для создания экземпляров транспортных средств
class VehicleFactory {
    public static Vehicle createVehicle(String type, int numberOfWheels) {
        if ("car".equals(type)) {
            return new Car(numberOfWheels);
        } else if ("bike".equals(type)) {
            return new Bike(numberOfWheels);
        }
        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        // Создание автомобиля с 4 колесами с использованием фабрики
        Vehicle car = VehicleFactory.createVehicle("car", 4);
        System.out.println(car);

        // Создание велосипеда с 2 колесами с использованием фабрики
        Vehicle bike = VehicleFactory.createVehicle("bike", 2);
        System.out.println(bike);
    }
}
