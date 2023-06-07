package ru.geekbrains.lesson2;

public class Cat {
    private String name;
    private int appetite;
    private int saturationLevel;
    private int currentSaturation;
    private boolean hungry;
    public Cat(String name, int appetite, int saturationLevel) {
        this.name = name;
        this.appetite = appetite;
        this.saturationLevel = saturationLevel;
        this.currentSaturation = 0;
        this.hungry = true;
    }

    /*public int getAppetite() {
        return this.appetite;
    }*/

    public void info() {
        if (this.hungry) {
            System.out.printf("Cat %s is still hungry saturation is %d of %d (%3.2f %%)\n",
                    this.name,
                    this.currentSaturation,
                    this.saturationLevel,
                    (double)this.currentSaturation/this.saturationLevel*100);
        } else {
            System.out.printf("%s is not hungry\n", this.name);
        }
    }

    public void eat(Plate targerPlate) {
        if (this.hungry) {
            int currentAppetite = Math.min(saturationLevel - currentSaturation, appetite);
            if (targerPlate.giveFood(currentAppetite)) {
                currentSaturation += currentAppetite;
                if (currentAppetite == saturationLevel) {
                    hungry = false;
                }
            }
        } else {
            System.out.printf("Cat %s is not hungry.\n", this.name);
        }
    }
}