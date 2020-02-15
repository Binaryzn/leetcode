package thread;

import java.util.*;

/**
 * @Classname Person
 * @Description TODO
 * @Date 2020/2/12 19:23
 * @Created by zheng.nie
 */
public class Person {

    private int age;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
  /*      Person p1 = new Person(1,"ss");
        Person p2 = new Person(1,"ss");
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        Set<Person> s = new HashSet<>();
        s.add(p1);
        s.add(p2);
        System.out.println(s)*/;
        ArrayList arrayList = new ArrayList(3);
        arrayList.set(1,1);
    }

}
