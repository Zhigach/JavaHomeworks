package SoftwareArchitecture.Lesson2.Factory;

public class Test {
    public static void main(String[] args) {
        Store store = new Store(10);
        store.addFactory(new WeaponFactory());
        store.addFactory(new HealthPotionFactory());

        store.restoreRandom();
        store.showStorage();
    }
}
