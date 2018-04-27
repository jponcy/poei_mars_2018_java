package com.tactfactory.poei.two_dog;

import java.time.LocalDate;

public class Dog {

    private String name;
    private LocalDate birthdate;
    private String breed;

    public Dog(String name, String breed) {
        this(name, breed, LocalDate.now());
    }

    public Dog(String name, String breed, LocalDate birthdate) {
        this.name = name;
        this.breed = breed;
        this.birthdate = birthdate;
    }

    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }
}
