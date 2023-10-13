package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Интерфейс Subject определяет методы для регистрации, отмены регистрации и уведомления наблюдателей.
interface Subject {
    void register(Observer obj);

    void unregister(Observer obj);

    void notifyObservers();
}

// Конкретный класс DeliveryData реализует интерфейс Subject.
class DeliveryData implements Subject {
    private List<Observer> observers;
    private String location;

    public DeliveryData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update(location);
        }
    }

    public void locationChanged() {
        this.location = getLocation();
        notifyObservers();
    }

    public String getLocation() {
        return "YPlace";
    }
}

// Интерфейс Observer определяет метод обновления, который реализуют конкретные наблюдатели.
interface Observer {
    void update(String location);
}

// Конкретные классы наблюдателей: Seller, User и DeliveryWarehouseCenter.
class Seller implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation("Seller");
    }

    public void showLocation(String role) {
        System.out.println("Notification at " + role + " - Current Location: " + location);
    }
}

class User implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation("User");
    }

    public void showLocation(String role) {
        System.out.println("Notification at " + role + " - Current Location: " + location);
    }
}

class DeliveryWarehouseCenter implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation("Warehouse");
    }

    public void showLocation(String role) {
        System.out.println("Notification at " + role + " - Current Location: " + location);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        DeliveryData topic = new DeliveryData();

        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        // Регистрация наблюдателей в предмете наблюдения.
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        // Изменение местоположения и уведомление наблюдателей.
        topic.locationChanged();

        // Отмена регистрации одного из наблюдателей (obj3).
        topic.unregister(obj3);

        System.out.println();

        // Изменение местоположения и уведомление оставшихся наблюдателей.
        topic.locationChanged();
    }
}
