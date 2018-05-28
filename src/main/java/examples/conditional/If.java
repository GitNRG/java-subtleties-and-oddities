package examples.conditional;


import helpers.Description;

import static helpers.Difficulty.*;
import static helpers.Topic.*;

public class If {

    /**
     * Assignment is forbidden in "if" statement.
     * Except for booleans, as assignment returns value and boolean result fits "if"
     */
    @Description(topics = {IF, WEIRD_SYNTAX}, difficulty = MEDIUM)
    public static void sneakyIf() {
        Boolean b1 = new Boolean("false");
        if (b1 = true) {
            System.out.println("This will be printed");
        }
        b1 = null;
        if (b1 = true) {
            System.out.println("This will be printed");
        }
        boolean b2 = false;
        if (b2 = true) {
            System.out.println("This will be printed");
        }

        if (b2) {
            System.out.println("This will be printed");
        }

        // but code below won't compile
        // int i1 = 0;
        // if (i1 = 1) {
        //     System.out.println("1");
        // }

        // you can bypass it with
        int i2 = 0;
        if ((i2 = 1) == 1) {
            System.out.println("This will be printed");
        }

        // this will compile, but will cause NPE
        // Boolean npe = false;
        // if (npe = null) {
        //     System.out.println("Not reachable due to NPE");
        // }
    }

    public static void main(String... args) {
    }
}
