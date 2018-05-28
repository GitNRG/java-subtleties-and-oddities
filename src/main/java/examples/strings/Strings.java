package examples.strings;

import helpers.Description;
import helpers.Difficulty;

import static helpers.Difficulty.*;
import static helpers.Topic.*;

public class Strings {

    /**
     * String pool values are equal, but even after hardcoded modification - not anymore
     */
    @Description(topics = {STRINGS}, difficulty = Difficulty.EASY)
    public void stringLiterals() {
        String s1 = "fluffy";
        String s2 = "fluffy";
        boolean itsTrue = s1 == s2;
        s1 += "and cute";
        s2 += "and cute";
        boolean itsFalse = s1 == s2;
    }

    /**
     * String.intern() method adds value to the string pool. Values in the pool could be compared with ==
     */
    @Description(topics = {STRINGS}, difficulty = MEDIUM)
    public static void addingStringToThePool() {
        String literal1 = "hitchhiker's guide to the galaxy";
        String literal2 = new String("hitchhiker's guide to the galaxy");
        System.out.println(literal1 == literal2);           // will print false
        System.out.println(literal1 == literal2.intern());  // will print true

    }

    public static void main(String... args) {
    }
}
