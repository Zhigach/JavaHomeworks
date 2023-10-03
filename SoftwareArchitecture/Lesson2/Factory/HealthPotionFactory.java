package SoftwareArchitecture.Lesson2.Factory;

public class HealthPotionFactory extends ItemFactory {
    @Override
    public StoreItem createItem() {
        return new HealthPotion();
    }
}
