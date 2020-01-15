package list;

public class Person2 extends Person {

    private static Integer i = 3;

    public Person2() {

        System.out.println("person 2");
    }


    static {
        System.out.println("person2 static --"+i);
    }


}
