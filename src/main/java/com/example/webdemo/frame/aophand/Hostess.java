package com.example.webdemo.frame.aophand;

public class Hostess implements Master {

    private Dog dog;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void walkDog() {
        dog.bark();
    }

    @Override
    public void shopping() {
        System.out.println("Hostess shopping ...");
    }
}
