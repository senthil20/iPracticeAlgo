package ds.MiscJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.age == p2.age) {
            return p1.name.compareTo(p2.name);
        }
        return p2.age - p1.age;
    }

    public static void main(String a[]) {
        List<Person> pList = new ArrayList<>();
        pList.add(new Person("Ram", 30));
        pList.add(new Person("Kumar", 30));
        pList.add(new Person("Raj", 40));
        pList.add(new Person("Victor", 20));
        pList.add(new Person("Prabhu", 20));
        pList.add(new Person("John", 50));
        Collections.sort(pList, new PersonComparator());
        System.out.println(pList);
    }


}
