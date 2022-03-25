package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static List<Car> cars = new ArrayList<>();
    private static int tries = 0;
    private static int furthestPosition = 0;

    public static Car addCar(String name) {
        Car car = new Car(name);
        addCar(car);
        return car;
    }

    public static void addCar(Car car) {
        cars.add(car);
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static List<String> getNamesOfCars() {
        List<String> names = new ArrayList<>();
        cars.forEach(car -> names.add(car.getName()));
        return names;
    }

    public static int getNumberOfTries() {
        return tries;
    }

    public static void setNumberOfTries(int times) {
        tries = times;
    }

    public static int getFurthestPosition() {
        return furthestPosition;
    }

    private static void setFurthestPosition(int position) {
        furthestPosition = position;
    }

    private static void updateFurthestPosition() {
        cars.forEach(car -> {
            if (car.getPosition() > getFurthestPosition()) {
                setFurthestPosition(car.getPosition());
            }
        });
    }

    public static List<Car> getFurthestCars() {
        List<Car> furthestCars = new ArrayList<>();
        updateFurthestPosition();
        cars.forEach(car -> {
            if (car.getPosition() == getFurthestPosition()) {
                furthestCars.add(car);
            }
        });
        return furthestCars;
    }

    public static List<String> getFurthestCarNames() {
        List<String> names = new ArrayList<>();
        getFurthestCars().forEach(car -> names.add(car.getName()));
        return names;
    }
}
