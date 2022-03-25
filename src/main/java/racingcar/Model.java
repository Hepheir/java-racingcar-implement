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

    private static void addCar(Car car) {
        cars.add(car);
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static int getNumberOfTries() {
        return tries;
    }

    public static void setNumberOfTries(int times) {
        tries = times;
    }

    private static void updateFurthestPosition() {
        cars.forEach(car -> {
            if (car.getPosition() > furthestPosition) {
                furthestPosition = car.getPosition();
            }
        });
    }

    private static List<Car> getFurthestCars() {
        List<Car> furthestCars = new ArrayList<>();
        updateFurthestPosition();
        cars.forEach(car -> {
            if (car.getPosition() == furthestPosition) {
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
