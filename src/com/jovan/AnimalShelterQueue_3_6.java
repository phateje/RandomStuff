package com.jovan;

import java.util.LinkedList;

public class AnimalShelterQueue_3_6 {

    public static void main(String[] args) {
        AnimalShelterQueue_3_6 x = new AnimalShelterQueue_3_6();
        Shelter s = x.new Shelter();

        s.enqueue(x.new Animal(1, Type.DOG));
        s.enqueue(x.new Animal(2, Type.CAT));
        s.enqueue(x.new Animal(3, Type.DOG));
        s.enqueue(x.new Animal(4, Type.CAT));
        s.enqueue(x.new Animal(5, Type.CAT));

        System.out.println(s.dequeueCat());
        s.printAnimals();

        System.out.println(s.dequeueAny());
        s.printAnimals();

        System.out.println(s.dequeueAny());
        s.printAnimals();

        System.out.println(s.dequeueDog());
        s.printAnimals();

    }


    public class Animal {
        Type type;
        long Id;

        public Animal(long Id, Type type) {
            this.Id = Id;
            this.type = type;
        }

        public String toString() {
            return "(" + Id + ", " + type+")";
        }
    }

    public static enum Type { DOG, CAT }

    public class Shelter {
        private LinkedList<Animal> animals = new LinkedList<>();

        public void enqueue(Animal a) {
            animals.add(a);
        }

        public Animal dequeueAny() {
            return animals.removeFirst();
        }

        public Animal dequeueDog() {
            return dequeueSpecific(Type.DOG);
        }

        public Animal dequeueCat() {
            return dequeueSpecific(Type.CAT);
        }

        private Animal dequeueSpecific(Type type) {
            for (Animal a : animals) {
                if (a.type == type) {
                    animals.remove(a);
                    return a;
                }
            }
            return null;
        }

        public void printAnimals() {
            System.out.println(animals);
        }
    }
}
