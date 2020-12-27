package by.itacademy.car;

import java.util.Objects;

public class MyObject implements Comparable<MyObject> {
    public String name;
    public int id;

    public MyObject(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return id == myObject.id &&
                Objects.equals(name, myObject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public int compareTo(MyObject o) {
        if(id > o.id){
            return  1;
        }
        if(id <o.id){
            return -1;
        }
        return 0;
    }
}
