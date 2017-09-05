package ds.MiscJava;

/**
 * Created by User on 22-08-2017.
 */
class Animal {}

class Cat extends Animal {}

class AnimalHouse {
    Animal getAnimal() {
        System.out.println("get Animal  from AnimalHouse.");
        return new Animal();
    }

    void putAnimal(Animal animal) {
        System.out.println("put Animal  in AnimalHouse.");
    }
}

class CatHouse extends AnimalHouse {
    Cat getAnimal() {
        System.out.println("get Cat  from CatHouse.");
        return new Cat();
    }

    void putAnimal(Animal animal) { System.out.println("put Cat  in CatHouse."); }
}


class Test1 {
    public static void main(String[] args){

        Animal aa = new Animal();
        Animal ac = new Cat();
        Cat cc = new Cat();

        AnimalHouse ah = new AnimalHouse();
        CatHouse ch = new CatHouse();

        System.out.println("Getting animals from houses");
        ah.getAnimal();
        ch.getAnimal();

        System.out.println("putting animals in animal house");
        ah.putAnimal(aa);
        ah.putAnimal(ac);
        ah.putAnimal(cc);
        //ah.putAnimal("hehe");

        System.out.println("putting animals in cat house");
        ch.putAnimal(aa); //runtime error
        ch.putAnimal(ac);
        ch.putAnimal(cc);
        //ch.putAnimal("hehe");

    }

}

