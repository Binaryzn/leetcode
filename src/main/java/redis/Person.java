package redis;

/**
 * @Classname Person
 * @Description TODO
 * @Date 2020/2/15 19:00
 * @Created by zheng.nie
 */
public class Person {

    private static volatile Person person;

    private Person(){}

    public static Person getInstance(){
        if(person == null){
            synchronized (Person.class){
                if(person == null){
                    person = new Person();
                }
            }
        }
        return person;
    }

}
