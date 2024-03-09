public class Dog extends Animal {
    private String barkSound;

    public Dog(int age, String name, String barkSound) {
        this.barkSound = barkSound;
        this.age = age;
        this.name = name;
    }

    void bark () {
        System.out.println(barkSound);
    }
}
