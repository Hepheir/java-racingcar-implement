package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Control {
    private static final int RULET_START_INCLUSIVE = 0;
    private static final int RULET_END_INCLUSIVE = 9;
    private static final int RULET_ALLOW_MOVE_IF_GREATER_OR_EQUAL_THAN = 4;

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
                return getStrictUserInputForCarNames();
            } catch (IllegalArgumentException exception) {
                View.printError("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static List<String> getStrictUserInputForCarNames() throws IllegalArgumentException {
        String rawUserInput = Console.readLine();
        String[] rawNames = rawUserInput.split(Text.WORD_SEPERATOR);
        List<String> names = new ArrayList<>(Arrays.asList(rawNames));
        names.forEach(name -> checkLengthOfCarName(name));
        return names;
    }

    private static void checkLengthOfCarName(String name) throws IllegalArgumentException {
        if (name.length() <= 5) {
            return;
        }
        throw new IllegalArgumentException("");
    }

    static int getUserInputForTries() {
        while (true) {
            try {
                return getStrictUserInputForTries();
            } catch (IllegalArgumentException exception) {
                View.printError("잘못된 값을 입력하였습니다.");
            }
        }
    }

    private static int getStrictUserInputForTries() throws IllegalArgumentException {
        String rawUserInput = Console.readLine();
        int userInput;
        try {
            userInput = Integer.parseInt(rawUserInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("");
        }
        return userInput;
    }
}
