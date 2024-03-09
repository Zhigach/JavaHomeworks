public class Cat extends Animal {
    private String meowSound;

    public Cat(int age, String name, String barkSound) {
        this.meowSound = barkSound;
        this.age = age;
        this.name = name;
    }

    void meow () {
        System.out.println(meowSound);
    }

    void makeSound() {
        System.out.println("*Catzilla roars!*");
    }

}
