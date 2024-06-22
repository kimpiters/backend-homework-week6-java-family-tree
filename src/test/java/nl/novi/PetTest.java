package nl.novi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    Pet pet;

    @BeforeEach
    void setUp() {
        pet = new Pet("Izar", 6, "Alaskan Husky");
    }

    //////////////////// GETTERS AND SETTERS ////////////////////

    @Test
    public void canGetName() {
        //arrange
        String name = "izar";
        //act
        //assert
        assertEquals(name, pet.getName());
    }

    @Test
    public void canSetName() {
        //arrange
        String name = "maya";
        //act
        pet.setName(name);
        //assert
        assertEquals(name, pet.getName());
    }

    @Test
    public void canGetAge() {
        //arrange
        int age = 6;
        //act
        //assert
        assertEquals(age, pet.getAge());
    }

    @Test
    public void canSetAge() {
        //arrange
        int age = 3;
        //act
        pet.setAge(age);
        //assert
        assertEquals(age, pet.getAge());
    }

    @Test
    public void canGetBreed() {
        //arrange
        String breed = "alaskan husky";
        //act
        //assert
        assertEquals(breed, pet.getBreed());
    }

    @Test
    public void canSetBreed() {
        //arrange
        String breed = "siberian husky";
        //act
        pet.setBreed(breed);
        //assert
        assertEquals(breed, pet.getBreed());
    }

    @Test
    public void canSetAndGetOwner() {
        //arrange
        Person owner = new Person("Kim", "Piters", 'F', 32);
        //act
        pet.setOwner(owner);
        //assert
        assertEquals(owner, pet.getOwner());
    }
}