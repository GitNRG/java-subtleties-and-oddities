package examples.exceptions;

import helpers.Description;

import static helpers.Difficulty.*;
import static helpers.Topic.*;

public class TryCatchFinally {

    /**
     * Return in finally block takes precedence over return in try block
     */
    @Description(topics = {EXCEPTION_HANDLING}, difficulty = EASY)
    private static String name() {
        try {
            return "this will be ignored";
        } finally {
            return "this will be returned";
        }
    }

    public static void main(String... args) {
    }
}
