package builder_design_pattern;

// Define the Vehicle class that you want to build
class Vehicle {
    private String engine;
    private int wheel;
    private int airbags;

    public String getEngine() {
        return this.engine;
    }

    public int getWheel() {
        return this.wheel;
    }

    public int getAirbags() {
        return this.airbags;
    }

    // Private constructor to create a Vehicle using the builder
    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    // Create a static inner class for building Vehicle objects
    public static class VehicleBuilder {
        private String engine;
        private int wheel;
        private int airbags;

        // Constructor with mandatory parameters
        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        // Optional method to set airbags
        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        // Build the Vehicle object using the provided parameters
        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        // Create a car with an engine of "1500cc", 4 wheels, and 4 airbags
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();

        // Create a bike with an engine of "250cc", 2 wheels, and no specified airbags
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

        // Print the details of the car and bike
        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());

        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags());
    }
}
