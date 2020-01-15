package list;

public class Person {

    private static Integer i = 1;

    static {
        System.out.println("Person ---init"+i);
    }

    public Person() {
        System.out.println("init");
    }
}
