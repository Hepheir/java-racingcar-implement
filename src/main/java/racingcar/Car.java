package racingcar;

public class Car {
    private final String name;
    private int position = 0;
    static private int furthestPosition = 0;

    Car(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    };

    int getPosition() {
        return this.position;
    }

    void moveForward() {
        this.position++;
        this.updateFurthestPosition();
    }

    private void updateFurthestPosition() {
        if (this.position > Car.furthestPosition) {
            Car.furthestPosition = this.position;
        }
    }

    boolean isFurthestCar() {
        return this.position == Car.furthestPosition;
    }
}
