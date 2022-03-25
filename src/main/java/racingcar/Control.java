package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Control {
    static void createCars() {
        View.printInputGuideForCarName();
        View.getUserInputForCarNames().forEach((name) -> Model.addCar(name));
    };

    static void setNumberOfTries() {
        View.printInputGuideForTries();
        Model.setNumberOfTries(View.getUserInputForTries());
    }

    static void showWinners() {
        View.printWinners();
    }

    static void tryOnce() {
        Model.getCars().forEach(car -> {
            tryMoveForward(car);
            View.printCar(car);
        });
        View.printLineBreak();
    }

    private static void tryMoveForward(Car car) {
        if (shouldMoveForward()) {
            car.moveForward();
        }
    }

    private static boolean shouldMoveForward() {
        int rulet = Randoms.pickNumberInRange(0, 9);
        return rulet >= 4;
    }
}
