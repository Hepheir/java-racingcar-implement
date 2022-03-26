package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static List<Car> cars = new ArrayList<>();
    private static int tries = 0;

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

    private static List<Car> getFurthestCars() {
        return cars.stream().filter(Car::isFurthestCar).collect(Collectors.toList());
    }

    public static List<String> getFurthestCarNames() {
        return getFurthestCars().stream().map(Car::getName).collect(Collectors.toList());
    }
}
