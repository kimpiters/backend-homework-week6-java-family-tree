package nl.novi;

public class Pet {
    private String name;
    private int age;
    private String breed;
    private Person owner;

    public Pet(String name, int age, String breed) {
        this.name = name.toLowerCase();
        this.age = age;
        this.breed = breed.toLowerCase();
    }

    //////////////////// GETTERS & SETTERS ////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed.toLowerCase();
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}