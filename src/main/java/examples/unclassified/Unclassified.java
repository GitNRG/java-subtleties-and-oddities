package examples.unclassified;

import helpers.Description;
import helpers.Difficulty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static helpers.Difficulty.EASY;
import static helpers.Difficulty.MEDIUM;
import static helpers.Topic.*;

public class Unclassified {

    /**
     * System.arraycopy can copy an array to itself without problems
     */
    @Description(topics = {BUILTINS}, difficulty = EASY)
    public static void copyToItself() {
        int arr[] = {1, 2, 3};
        System.arraycopy(arr, 0, arr, 0, arr.length);
    }

    /**
     * May seem first that we're assigning list to array, but in fact everything is fine
     */
    @Description(topics = {WEIRD_SYNTAX}, difficulty = EASY)
    public static void trickyOne(List... obj) {
        Object[] objectArray = obj;
    }

    /**
     * It's not possible to create package name that contains java keyword like 'static' or 'class'
     * Actually it possible, but it's not possible to add class in it. At least in IntelliJ IDEA
     */
    @Description(topics = {PACKAGES}, difficulty = MEDIUM)
    public static void stub(){}


    /**
     * Integer always have hashcode equal to it's value
     * Long - not always as hashcode is of type int
     */
    @Description(topics = {PRIMITIVE_WRAPPERS, EQUALS_AND_HASHCODE}, difficulty = EASY)
    public static void primitiveWrappersHashCodes() {
        Integer i = 12850302;
        System.out.println( i == i.hashCode()); // true

        Long l = 9837234L;
        System.out.println( l == l.hashCode()); // true
        l = 0xFFFF_FFFF_0000_0000L;
        System.out.println( l == l.hashCode()); // false
        System.out.println( -1 ==l.hashCode()); // true
    }


    /**
     * Arrays doesn't have overridden hashcode, so they should never be used as Map keys.
     */
    @Description(topics = {EQUALS_AND_HASHCODE, ARRAYS}, difficulty = MEDIUM)
    public static void incorrectHashcode() {
        Map<int[], String> map = new HashMap<>();
        int[] key = new int[]{1};
        map.put(key, "February");

        System.out.println(map.get(key));           // February
        System.out.println(map.get(new int[]{1}));  // null
    }

    public static void main(String... args) {
    }
}