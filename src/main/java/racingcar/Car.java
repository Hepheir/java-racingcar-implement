package racingcar;

public class Car {
    private final String name;
    private int position = 0;

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
    }
}
