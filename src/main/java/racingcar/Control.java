package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Control {
    private static final int RULET_START_INCLUSIVE = 0;
    private static final int RULET_END_INCLUSIVE = 9;
    private static final int RULET_ALLOW_MOVE_IF_GREATER_OR_EQUAL_THAN = 4;

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

    static void tryMoveOnceForEachCars() {
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
        int rulet = Randoms.pickNumberInRange(RULET_START_INCLUSIVE, RULET_END_INCLUSIVE);
        return rulet >= RULET_ALLOW_MOVE_IF_GREATER_OR_EQUAL_THAN;
    }
}
