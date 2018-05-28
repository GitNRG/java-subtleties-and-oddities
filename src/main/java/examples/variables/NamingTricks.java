package examples.variables;

import helpers.Description;

import static helpers.Difficulty.EASY;
import static helpers.Topic.*;

public class NamingTricks {

    /**
     * Defining such variable is legal although it may be unsupported in java9+
     */
    @Description(topics = {PRIMITIVES, WEIRD_SYNTAX}, difficulty = EASY)
    public static void underscodeAsVariableName() {
        char _ = 0xFFFF;
    }

    /**
     * Yes, it's possible to use build-in classes names as variable names. But please don't.
     */
    @Description(topics = {PRIMITIVES, WEIRD_SYNTAX}, difficulty = EASY)
    public static void badNaming() {
        long Float = 1;
        int String = 1;
        char Class = 'x';
        float Object = 3.5f;
        String Character = "";
    }

    public static void main(String... args) {
    }
}
