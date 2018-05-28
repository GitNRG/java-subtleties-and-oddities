package examples.generics;

import helpers.Description;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static helpers.Difficulty.*;
import static helpers.Topic.*;

public class Generics {

    /**
     * This is generic class
     */
    @Description(topics = {GENERICS}, difficulty = EASY)
    class Name<E> {
        public E getE() {
            return null;
        }
    }

    /**
     * This is generic method
     */
    @Description(topics = {GENERICS}, difficulty = EASY)
    public static <T> T returnArg(T arg) {
        return arg;
    }
    public static void aFewSimpleExamples() {
        // this is how generic method is parametrized
        String str1 = Generics.<String>returnArg("back and forth");
        // this is also ok. no warning as argument type was automatically inferred at compile time
        String str2 = Generics.returnArg("back and forth");
        // type is not required for object
        Object obj = "sample";
        Object obj1 = Generics.returnArg(obj);
        // or if parameter was casted to some other type (like String)
        String obj2 = Generics.returnArg((String) obj);
    }


    /**
     * This class can be parametrized with everything that extends/implements Number,
     * like Integer or Double
     */
    @Description(topics = {GENERICS}, difficulty = EASY)
    static class Extender<E extends Number> {
        public E doNothing() {
            return null;
        }
    }
    public static void usingExtendsWithGenerics() {
        // ok
        Integer i1 = new Extender<Integer>().doNothing();
        Number n1 = new Extender().doNothing();
        // useless, but still ok
        Number n2 = new Extender<Number>().doNothing();
        // compile time error
        // new Extender<String>().doNothing();
    }


    /**
     * In case of multiple bounds
     * 1) Specified type E should be subtype of all listed types
     * 2) Join subtypes with &. With & NOT comma or something else
     * 3) Classes should go ahead of interfaces
     */
    @Description(topics = {GENERICS}, difficulty = EASY)
    static class MultiExtender<E extends Number & Serializable> {
    }
    MultiExtender<Long> o1 = new MultiExtender<>(); // ok because Long is Number and Serializable
    // not ok because String is NOT a Number, just Serializable
    // MultiExtender<String> o2 = new MultiExtender<>();

    /**
     *  Compile time error as interface is ahead of the class
     */
    @Description(topics = {GENERICS}, difficulty = EASY)
    public void thisWontCompile() {
        // class ErrorMultiExtender<E extends Closeable & HashMap>  {}
    }

    /**
     * Upper bounded wildcard. In this case we don't need to specify any generic type.
     * It's totally fine just to limit argument type and that's all;
     * Upper bounded wildcard means that method will accept specified type and any subtype of it.
     */
    @Description(topics = {GENERICS}, difficulty = EASY)
    static double sum(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }
    public void genericMethodExamples() {
        double res1 = sum(Arrays.asList(1, 2, 3));
        double res2 = sum(Arrays.asList(1.123, 4.567, 8.901));
    }


    /**
     * Lower bounded wildcard. Accept specified type of anything that it implements/extends
     */
    @Description(topics = {GENERICS}, difficulty = EASY)
    static Object getFirst(List<? super Integer> list) {
        // these lines won't compile as list may be of type Object
        // Integer n = list.get(0);
        // Number n = list.get(0);

        // this is ok, as there is nothing 'higher' than Object
        Object n = list.get(0);
        return n;
    }
    public void usingSuperWithGenerics() {
        Object res1 = getFirst(Arrays.asList(77, 99)); // Integer
        Object res2 = getFirst(Arrays.asList(1.123, 4.567, 8.901)); // Number
        Object res3 = getFirst(Arrays.asList(new Object())); // Object
    }

    /**
     * Wildcard error
     * The compiler is not able to confirm the type of object that is being inserted into the list,
     * and an error is produced.
     */
    @Description(topics = {GENERICS}, difficulty = EASY)
    class GenericParams {
        // error
        // void error(List<?> i) {
        //    i.set(0, i.get(0));
        // }

        // no error
        <T> void noError(List<T> i) {
            i.set(0, i.get(0));
        }
    }

    /**
     * Can't init array with generics
     */
    @Description(topics = {GENERICS}, difficulty = EASY)
    static class Generic<T extends Number> {
        // compilation error
        // private T arr[] = {1, 2, 3, 4, 5};
        // private T arr[] = new T[3];
    }

    public static void main(String... args) {
    }
}