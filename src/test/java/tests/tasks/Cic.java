package tests.tasks;

public class Cic {
    static class GenericEngine {
        public String endType = "AB - 001";
    }

    static class CombustionEngine extends GenericEngine {
        public String endType = "CE - 002";
    }

    static class JetEngine extends CombustionEngine {
        public String endType = "JE - 003";
    }

    public static class Car {
        public void setEngine(Object o) {
            System.out.println("I have no engine.");
        }

        public void setEngine(GenericEngine ge) {
            System.out.printf("I have generic engine: %s", ge.endType);
        }

        public void setEngine(CombustionEngine ce) {
            System.out.printf("I have combustion engine: %s", ce.endType);
        }
    }

//    public static void main(String[] args) {
//        JetEngine e = new JetEngine();
//        new Car().setEngine(e);
//    }

    public static class WeirdLoop {
        private static final int i = 99;

        public static void main(String[] args) {
            for (int i = 0; i<100; i++) {
                System.out.println(i);
                i++;
                break;
            }
            System.out.println(i);
        }
    }
}
