package examples.enums;

import helpers.Description;

import static helpers.Difficulty.*;
import static helpers.Topic.*;

public class Enums {

    /**
     * That's how you can add enum methods and override per-constant basis
     */
    @Description(topics = {ENUMS, POLYMORPHISM, ACCESS_MODIFIERS}, difficulty = MEDIUM)
    enum Colors {
        RED {
            //empty constant-specific body is ok
        },
        BLUE,
        GREEN {
            @Override
            public String getDesc() {
                return "I override base method";
            }

            public String itsATrap() {
                return "You'll never access me!!!";
            }
        };

        public String getDesc() {
            return "Common desc";
        }
    }
    void methodA() {
        System.out.println(Colors.BLUE.getDesc());  // "Common desc"
        System.out.println(Colors.GREEN.getDesc()); // "I override base method"
    }


    /**
     * Enums with constructors and usage example
     */
    @Description(topics = {ENUMS}, difficulty = EASY)
    enum Guns {
        RIFLE(0),
        SHOTGUN(1),
        REVOLVER(2);

        private int index;

        Guns(int index) {
            this.index = index;
        }

        public static Guns getByCode(int code) {
            // note that we can't call 'new Guns(code)'
            // because enum can't be instantiated
            switch (code){
                case 0:
                    return RIFLE;
                case 1:
                    return SHOTGUN;
                case 2:
                    return REVOLVER;
                default:
                    throw new IllegalArgumentException("Invalid gun code");
            }
        }
    }
    static void methodB() {
        System.out.println(Guns.REVOLVER.index); // 2
        System.out.println(Guns.getByCode(0));   // RIFLE
        System.out.println(Guns.getByCode(1));   // SHOTGUN
        System.out.println(Guns.getByCode(2));   // REVOLVER
    }

    public static void main(String... args) {
    }
}
