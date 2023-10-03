package SoftwareArchitecture.Lesson2.Factory;

public class WeaponFactory extends ItemFactory{

    @Override
    public StoreItem createItem() {
        return new Weapon();
    }
}
