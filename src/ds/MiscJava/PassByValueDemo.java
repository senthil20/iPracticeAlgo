package ds.MiscJava;

import java.util.ArrayList;
import java.util.List;

//Java pass by value
class Test {

    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 1. Changing primitives by passing to other methods no impact
 2. Assigning the reference to different object and changing the references attributes will reflect in both the references
    Eg: Test A = new Test();
        Test B = A;
        B.setX(); will impact A.getX();
 3. But if you set A == null; B still has the latest updated values and it won't be null. Only reference of A points to(marked as) null &
    B will still point to the Test object available in heap.

**/
public class PassByValueDemo {

    int i; // class level doesn't need to be initialized. It's set with default value

    public static void main(String a[]) {
        /*int i;
        i++;*/ // throws compilation issue since it's not initialized locally

        Test A = new Test();
        A.setName("GeeksforGeeks");
        A.setId(123);

        new PassByValueDemo().changeVal(A);

        System.out.println(A);

        Test B = A;
        B.setName("Changing name from B");
        B.setId(-1);

        System.out.println(A);

        //I'm reverting the name to what i set
        A.setName("Leetcode");
        A.setId(321);

        System.out.println(B);

        //Discarding A by pointing null. This doesnt affect reference 'B'
        //B still holds the latest changes made to object Test in heap.
        //Test Obj remains as such in heap memory with as much changes done by different references

        A = null;
        System.out.println(B); //setting A to null doesn't affect B
        System.out.println(A);

        //another different example
        A = new Test(); //resetting A to new Test() as it's pointing to null above
        A.setId(999);
        A.setName("GeeksForGeeks");

        List<Test> list = new ArrayList<>();
        list.add(A);

        A.setId(1000);
        A.setName("InterviewBit");

        System.out.println(list);
        System.out.println(A);

        //set A to null.what happens? will list becomes null/empty :-) Nope 'A' job is done and it finds it's way.
        //It can't do anything with the list. But if you do A.setX("") it will reflect over list.
        A = null;
        System.out.println(list);

        //see this example too
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = list1;

        list1.add("IB");
        list1.add("LC");
        list2.add("GFG");

        System.out.println(list1);
        System.out.println(list2);
    }

    public void changeVal(Test A1) {
        System.out.println(i);
        A1.setName("Leetcode");
        A1.setId(321);
    }
}
