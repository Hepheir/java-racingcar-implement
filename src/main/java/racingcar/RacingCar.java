package racingcar;

public class RacingCar {
    private static int tries = 0;

    static void run() {
        onStart();
        while (isIngame()) {
            onTurn();
        }
        onEnd();
    }

    static void onStart() {
        Control.createCars();
        Control.setNumberOfTries();

        View.printLineBreak();
        View.printResultHeader();
    }

    static void onTurn() {
        Control.tryOnce();
        tries++;
    }

    static void onEnd() {
        View.printWinners();
    }

    static boolean isIngame() {
        return tries < Model.getNumberOfTries();
    }
}
