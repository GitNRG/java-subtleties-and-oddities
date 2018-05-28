package examples.conditional;

import helpers.Description;

import static helpers.Difficulty.*;
import static helpers.Topic.*;

public class Switch {

    /**
     * Just a few examples of valid (and not) syntax
     */
    @Description(topics = {SWITCH, WEIRD_SYNTAX}, difficulty = EASY)
    static class UsingSwitch {
        static void example(int i) {
            switch (i) {
                case 100:
                    break;
                // int a = 0; // compilation error. unreachable statement
                default:
                    break;
                // int b = 0; // compilation error. unreachable statement
            }

            // it's ok
            switch (i) {
                default:
            }
            switch (i) {
                case 1:
            }

            // if i == 2 - will print 'case 2'
            switch (i) {
                case 1:
                    System.out.println("case 1");
                    break;
                default:
                    System.out.println("default");
                    break;
                case 2:
                    System.out.println("case 2");
                    break;
            }
        }
    }

    public static void main(String... args) {
    }
}
