package nl.novi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person;

    @BeforeEach
    void setUp() {
        person = new Person("Kim", "Johanna", "Piters", 'F', 32);
    }

    //////////////////// GETTERS AND SETTERS ////////////////////
    @Test
    public void canGetAndSetCharacteristics() {
        //arrange
        Person mother = new Person("Jane", "Doe", 'F', 63);
        Person father = new Person("John", "Doe", 'M', 66);
        //act
        person.setName("John");
        person.setMiddleName("Jane");
        person.setLastName("Doe");
        person.setSex('M');
        person.setAge(30);
        person.setMother(mother);
        person.setFather(father);
        //assert
        assertEquals("john", person.getName());
        assertEquals("jane", person.getMiddleName());
        assertEquals("doe", person.getLastName());
        assertEquals('m', person.getSex());
        assertEquals(30, person.getAge());
        assertEquals(mother, person.getMother());
        assertEquals(father, person.getFather());
    }

    @Test
    public void canGetAndSetSiblings() {
        //arrange
        List<Person> siblings = new ArrayList<>();
        Person sister = new Person("Jane", "Doe", 'F', 30);
        Person brother = new Person("John", "Doe", 'M', 30);
        siblings.add(sister);
        siblings.add(brother);
        //act
        person.setSiblings(siblings);
        //assert
        assertEquals(siblings, person.getSiblings());
    }

    @Test
    public void canGetAndSetChildren() {
        //arrange
        List<Person> children = new ArrayList<>();
        Person child1 = new Person("Jane", "Doe", 'F', 30);
        Person child2 = new Person("John", "Doe", 'M', 30);
        children.add(child1);
        children.add(child2);
        //act
        person.setChildren(children);
        //assert
        assertEquals(children, person.getChildren());
    }

    @Test
    public void canGetAndSetPets() {
        //arrange
        List<Pet> pets = new ArrayList<>();
        Pet pet1 = new Pet("Izar", 6, "Alaskan Husky");
        Pet pet2 = new Pet("Maya", 3, "Siberian Husky");
        pets.add(pet1);
        pets.add(pet2);
        //act
        person.setPets(pets);
        //assert
        assertEquals(pets, person.getPets());
    }

    //////////////////// OTHER METHODS ////////////////////

    @Test
    public void canAddParents() {
        //arrange
        Person mother = new Person("Jane", "Doe", 'F', 63);
        Person father = new Person("John", "Doe", 'M', 66);
        //act
        person.addParents(mother, father);
        //assert
        assertEquals(mother, person.getMother());
        assertEquals(father, person.getFather());
    }

    @Test
    public void canAddChild() {
        //arrange
        Person child = new Person("Jane", "Doe", 'F', 2);
        //act
        person.addChild(child);
        //assert
        assertEquals(child, person.getChildren().getFirst());
    }

    @Test
    public void canAddPet() {
        //arrange
        Pet pet = new Pet("Izar", 6, "Alaskan Huksy");
        //act
        person.addPet(pet);
        //assert
        assertEquals(pet, person.getPets().getFirst());
    }

    @Test
    public void canAddSibling() {
        //arrange
        Person brother = new Person("John", "Doe", 'M', 30);
        //act
        person.addSibling(brother);
        //assert
        assertEquals(brother, person.getSiblings().getFirst());
    }

    @Test
    public void canGetGrandChildren() {
        //arrange
        // Create and add children
        Person child1 = new Person("Jane", "Doe", 'F', 30);
        person.addChild(child1);
        Person child2 = new Person("John", "Doe", 'M', 28);
        person.addChild(child2);
        // Create and add children of children
        Person grandChild1 = new Person("Jane", "Doe", 'F', 4);
        Person grandChild2 = new Person("John", "Doe", 'M', 2);
        child1.addChild(grandChild1);
        child1.addChild(grandChild2);
        Person grandChild3 = new Person("John", "Doe", 'F', 1);
        child2.addChild(grandChild3);
        // Make list of grandchildren
        List<Person> grandChildren = new ArrayList<>();
        grandChildren.add(grandChild1);
        grandChildren.add(grandChild2);
        grandChildren.add(grandChild3);

        //act
        //assert
        assertEquals(grandChildren, person.getGrandChildren());
        assertEquals(3, person.getGrandChildren().size());
    }
}