package by.itacademy.car;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private String model;
    private int power;

    public Car(String model) {
        this.model = model;
    }

    public Car(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    /*Если используем implements comparable то переопределяем этот метод но так мы можем
    сравнивать объекты только по одному полю Integer. Если нам нужно сравнивать по объектам или по нескольким полям
    мы исплоьзуем Comparator*/
    @Override
    public int compareTo(Car o) {
        if(power > o.power){
            return  1;
        }
        if(power <o.power){
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return power == car.power &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, power);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", power=" + power +
                '}';
    }

}
