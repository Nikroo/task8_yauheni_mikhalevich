package by.itacademy;

import by.itacademy.car.Car;
import by.itacademy.car.CarPowerComparator;
import by.itacademy.list.MyArrayList;
import by.itacademy.list.MyList;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        MyList<String> stringList = MyArrayList.of("Zero", "First", "Second", "Third");
        stringList.add("Fourth");
        stringList.add("Fifth");
        stringList.remove(5);

        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i)+" ");
        }
        System.out.println();

        MyList<Car> nativeCarList = new MyArrayList<>(17);

        for (int i = 0; i < 15; i++) {
            nativeCarList.add(new Car("VAZ-"+"210"+i, i*10));
        }

        List<Car> foreignCarList = new ArrayList<>();
        foreignCarList.add(0,new Car("Mercedes", 1000));
        foreignCarList.add(1,new Car("BMW", 700));

        nativeCarList.addAll(1, foreignCarList);
        nativeCarList.sort(new CarPowerComparator());

        int i=0;
        for (Car element: nativeCarList) {
            System.out.println(i+" "+element);
            i++;
        }

        System.out.print("\nMercedes indexOf:"+nativeCarList.indexOf(new Car("Mercedes", 1000)));
        System.out.print("\nMercedes lastIndexOf:"+nativeCarList.lastIndexOf(new Car("Mercedes", 1000)));
        System.out.print("\nElement: "+nativeCarList.remove(0)+" was remove.");
        System.out.print("\nElement: "+nativeCarList.set(11, new Car("UAZ", 500))+" was replaced.");
        nativeCarList.add(new Car("Mercedes", 1000));
    }
}
