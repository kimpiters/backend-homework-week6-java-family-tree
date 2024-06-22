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
        Person partner = new Person("Jane", "Doe", 'F', 30);
        Person mother = new Person("Jane", "Doe", 'F', 30);
        Person father = new Person("John", "Doe", 'M', 30);
        //act
        person.setName("John");
        person.setMiddleName("Jane");
        person.setLastName("Doe");
        person.setSex('M');
        person.setAge(30);
        person.setPartner(partner);
        person.setMother(mother);
        person.setFather(father);
        //assert
        assertEquals("john", person.getName());
        assertEquals("jane", person.getMiddleName());
        assertEquals("doe", person.getLastName());
        assertEquals('m', person.getSex());
        assertEquals(30, person.getAge());
        assertEquals(partner, person.getPartner());
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
        Person partner = new Person("Jane","Doe", 'F', 30);
        person.setPartner(partner);

        Person child1 = new Person("Jane", "Doe", 'F', 30);
        Person child2 = new Person("Jane", "Doe", 'F', 30);
        Person childOfPartner = new Person("Jane", "Doe", 'F', 30);
        partner.addChild(childOfPartner);

        List<Person> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);

        List<Person> sharedChildren = new ArrayList<>();
        sharedChildren.add(child1);
        sharedChildren.add(child2);
        sharedChildren.add(childOfPartner);
        //act
        person.setChildren(children);
        //assert
        assertEquals(sharedChildren, person.getChildren());
    }

    @Test
    public void canGetAndSetPets() {
        //arrange
        Person partner = new Person("Jane", "Doe", 'F', 30);
        person.setPartner(partner);

        Pet pet1 = new Pet("Izar", 6, "Alaskan Husky");
        Pet pet2 = new Pet("Maya", 3, "Siberian Husky");
        Pet petOfPartner = new Pet("Leia", 1, "Siberian Husky");
        partner.addPet(petOfPartner);

        List<Pet> pets = new ArrayList<>();
        pets.add(pet1);
        pets.add(pet2);

        List<Pet> sharedPets = new ArrayList<>();
        sharedPets.add(pet1);
        sharedPets.add(pet2);
        sharedPets.add(petOfPartner);

        //act
        person.setPets(pets);
        //assert
        assertEquals(sharedPets, person.getPets());
    }

    //////////////////// OTHER METHODS ////////////////////

    @Test
    public void canAddParents() {
        //arrange
        Person mother = new Person("Jane", "Doe", 'F', 30);
        Person father = new Person("John", "Doe", 'M', 30);
        //act
        person.addParents(mother, father);
        //assert
        assertEquals(mother, person.getMother());
        assertEquals(father, person.getFather());
    }

    @Test
    public void canAddChild() {
        //arrange
        Person child = new Person("Jane", "Doe", 'F', 30);
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
        //    Create and add children
        Person child1 = new Person("Jane", "Doe", 'F', 30);
        person.addChild(child1);
        Person child2 = new Person("Jane", "Doe", 'F', 30);
        person.addChild(child2);
        //    Create and add grandchildren
        Person grandChild1 = new Person("Jane", "Doe", 'F', 30);
        Person grandChild2 = new Person("Jane", "Doe", 'F', 30);
        child1.addChild(grandChild1);
        child1.addChild(grandChild2);
        Person grandChild3 = new Person("Jane", "Doe", 'F', 30);
        child2.addChild(grandChild3);

        //    Create and add partner
        Person partner = new Person("Jane", "Doe", 'F', 30);
        person.setPartner(partner);
        //    Create and add child
        Person childOfPartner = new Person("Jane", "Doe", 'F', 30);
        partner.addChild(childOfPartner);
        //    Create and add grandchild
        Person grandChildOfPartner = new Person("Jane", "Doe", 'F', 30);
        childOfPartner.addChild(grandChildOfPartner);

        //    Make list of shared grandchildren
        List<Person> sharedGrandChildren = new ArrayList<>();
        sharedGrandChildren.add(grandChild1);
        sharedGrandChildren.add(grandChild2);
        sharedGrandChildren.add(grandChild3);
        sharedGrandChildren.add(grandChildOfPartner);

        //act
        //assert
        assertEquals(sharedGrandChildren, person.getGrandChildren());
        assertEquals(4, person.getGrandChildren().size());
    }

    //////////////////// BONUS METHODS ////////////////////

    @Test
    public void canGetGrandPets() {
        //arrange

        //    Create and add children
        Person child1 = new Person("Jane", "Doe", 'F', 30);
        person.addChild(child1);
        Person child2 = new Person("John", "Doe", 'M', 28);
        person.addChild(child2);
        //    Create and add grandchildren
        Person grandChild1 = new Person("Jane", "Doe", 'F', 4);
        child1.addChild(grandChild1);
        Person grandChild2 = new Person("John", "Doe", 'M', 1);
        child2.addChild(grandChild2);
        //    Create and add pets of grandchildren
        Pet pet1 = new Pet("Izar", 6, "Alaskan Huksy");
        grandChild1.addPet(pet1);
        Pet pet2 = new Pet("Maya", 3, "Siberian Husky");
        grandChild2.addPet(pet2);

        //    Create and add partner
        Person partner = new Person("Jane", "Doe", 'F', 30);
        person.setPartner(partner);
        //    Create and add child
        Person childOfPartner = new Person("Jane", "Doe", 'F', 30);
        partner.addChild(childOfPartner);
        //    Create and add grandchild
        Person grandChildOfPartner = new Person("Jane", "Doe", 'F', 30);
        childOfPartner.addChild(grandChildOfPartner);
        //    Create and add pet of grandchild
        Pet pet3 = new Pet("Izar", 6, "Alaskan Huksy");
        grandChildOfPartner.addPet(pet3);

        //    Make list of shared grandpets
        List<Pet> sharedGrandPets = new ArrayList<>();
        sharedGrandPets.add(pet1);
        sharedGrandPets.add(pet2);
        sharedGrandPets.add(pet3);

        //act
        //assert
        assertEquals(sharedGrandPets, person.getGrandPets());
        assertEquals(3, person.getGrandPets().size());
    }

    @Test
    public void canGetNieces() {
        //arrange

        //    Create and add siblings
        Person sibling1 = new Person("Jane", "Doe", 'F', 30);
        person.addSibling(sibling1);
        Person sibling2 = new Person("jane", "Doe", 'F', 30);
        person.addSibling(sibling2);
        //    Create and add niblings
        Person nibling1 = new Person("Jane", "Doe", 'F', 30);
        Person nibling2 = new Person("John", "Doe", 'M', 30);
        sibling1.addChild(nibling1);
        sibling1.addChild(nibling2);
        Person nibling3 = new Person("Jane", "Doe", 'F', 1);
        sibling2.addChild(nibling3);

        //    Create and add partner
        Person partner = new Person("Jane", "Doe", 'F', 30);
        person.setPartner(partner);
        //    Create and add sibling
        Person siblingOfPartner = new Person("Jane", "Doe", 'F', 30);
        partner.addSibling(siblingOfPartner);
        //    Create and add nibling
        Person niblingOfPartner = new Person("Jane", "Doe", 'F', 30);
        siblingOfPartner.addChild(niblingOfPartner);

        //    Make list of shared nieces
        List<Person> sharedNieces = new ArrayList<>();
        sharedNieces.add(nibling1);
        sharedNieces.add(nibling3);
        sharedNieces.add(niblingOfPartner);

        //act
        //assert
        assertEquals(sharedNieces, person.getNieces());
        assertEquals(3, person.getNieces().size());
    }
}