package nl.novi;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.toLowerCase;

public class Person {
    private String name;
    private String middleName;
    private String lastName;
    private char sex;
    private int age;
    private Person partner;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<>();
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();

    public Person(String name, String lastName, char sex, int age) {
        this.name = name.toLowerCase();
        this.lastName = lastName.toLowerCase();
        this.sex = toLowerCase(sex);
        this.age = age;
    }

    public Person(String name, String middleName, String lastName, char sex, int age) {
        this.name = name.toLowerCase();
        this.middleName = middleName.toLowerCase();
        this.lastName = lastName.toLowerCase();
        this.sex = toLowerCase(sex);
        this.age = age;
    }

    //////////////////// GETTERS & SETTERS ////////////////////
    // Names //
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName.toLowerCase();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.toLowerCase();
    }

    // Other characteristics //
    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = toLowerCase(sex);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Relationships //

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        List<Person> sharedChildren = new ArrayList<>(children);
        if (partner != null) {
            sharedChildren.addAll(partner.children);
        }
        return sharedChildren;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() {
        List<Pet> sharedPets = new ArrayList<>(pets);
        if (partner != null) {
        sharedPets.addAll(partner.pets);
        }
        return sharedPets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    //////////////////// OTHER METHODS ////////////////////

    public void addParents(Person mother, Person father) {
        this.mother = mother;
        this.father = father;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public void addSibling(Person sibling) {
        this.siblings.add(sibling);
    }

    public List<Person> getGrandChildren() {
        List<Person> grandChildren = new ArrayList<>();
        // Add own grandchildren
        for (Person child : children) {
            grandChildren.addAll(child.children);
        }
        // Add grandchildren through partner
        for (Person child : partner.children) {
            grandChildren.addAll(child.children);
        }
        return grandChildren;
    }

    //////////////////// BONUS METHODS ////////////////////

    public List<Pet> getGrandPets() {
        List<Pet> sharedGrandPets = new ArrayList<>();
        for (Person child : children) {
            for (Person grandChild : child.children) {
                sharedGrandPets.addAll(grandChild.pets);
            }
        }
        for (Person child : partner.children) {
            for (Person grandChild : child.children) {
                sharedGrandPets.addAll(grandChild.pets);
            }
        }
        return sharedGrandPets;
    }

    public List<Person> getNieces() {
        List<Person> nieces = new ArrayList<>();
        for (Person sibling : siblings) {
            for (Person nibling : sibling.children) {
                if (nibling.sex == 'f') {
                    nieces.add(nibling);
                }
            }
        }
        for (Person sibling : partner.siblings) {
            for (Person nibling : sibling.children) {
                if (nibling.sex == 'f') {
                    nieces.add(nibling);
                }
            }
        }
        return nieces;
    }
}