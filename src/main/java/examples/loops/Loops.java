package examples.loops;

import helpers.Description;

import static helpers.Difficulty.*;
import static helpers.Topic.*;

public class Loops {

    /**
     * These 2 loops are basically the same. First one is just written in a very bad way
     * Do not uncomment loops as IDE auto-format will most likely erase the 'trick'
     */
    @Description(topics = {LOOPS, WEIRD_SYNTAX}, difficulty = MEDIUM)
    public static void weirdLoopSyntax() {
        int i = 0;
        do while (i < 10) do do while (i < 10) i++; while (i < 10); while (i < 10); while (i == 0);

        // 1.
        // do while (i < 10) do do while (i < 10) i++; while (i < 10); while (i < 10); while (i == 0);

        // 2.
        // do {
        //     while (i < 10) {
        //         do {
        //             do {
        //                 while (i < 10) {
        //                     i++;
        //                 }
        //             } while (i < 10);
        //         } while (i < 10);
        //     }
        // } while (i == 0);
    }

    /**
     * If you really want to emulate goto behaviour it's possible to write something like this,
     * but get ready to be slapped in the face
     */
    @Description(topics = {LOOPS, WEIRD_SYNTAX}, difficulty = EASY)
    public static void mockingGoTo() {
        // first example
        // this will print '1' and '2'
        do {
            // operation1
            System.out.println("1");
            if(false) break;
            // operation2
            System.out.println("2");
            if(true) break;
            // operation3
            System.out.println("3");
            if(false) break;
        } while (false);

        // second example
        // this will print 'a' and 'b'
        label1:
        do {
            System.out.println("a");
            if (false) break label1;
            label2:
            do {
                System.out.println("b");
                if (true) break label2;
                System.out.println("c");
            } while (false);
            if (true) break label1;
            System.out.println("d");
        } while (false);
    }

    public static void main(String... args) {
    }
}
