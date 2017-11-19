package com.polymorphism;

/**
 * Created by yanfeng-mac on 2017/10/31.
 */
public class Father {
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "father: " + this.getName();
    }

    private static class Son extends Father {
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return "child-" + this.name;
        }

        public String toString() {
            return "Son: " + this.getName() + " age: " + this.getAge();
        }
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.setAge(19);
        son.setName("Tom");
        Father father = son;
        father.name = "Jack";
        System.out.println(father.name);
        System.out.println(father.getName());
    }
}
