package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Control {
    private static final int RULET_START_INCLUSIVE = 0;
    private static final int RULET_END_INCLUSIVE = 9;
    private static final int RULET_ALLOW_MOVE_IF_GREATER_OR_EQUAL_THAN = 4;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    static void createCars() {
        View.printInputGuideForCarName();
        getUserInputForCarNames().forEach(Model::addCar);
    }

    static void setNumberOfTries() {
        View.printInputGuideForTries();
        Model.setNumberOfTries(getUserInputForTries());
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

    static List<String> getUserInputForCarNames() {
        while (true) {
            try {
                return Input.getWordsInLimitedSize(Text.WORD_SEPERATOR, CAR_NAME_MAX_LENGTH);
            } catch (IllegalArgumentException exception) {
                View.printError("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    static int getUserInputForTries() {
        while (true) {
            try {
                return Input.getInteger();
            } catch (IllegalArgumentException exception) {
                View.printError("잘못된 값을 입력하였습니다.");
            }
        }
    }
}
