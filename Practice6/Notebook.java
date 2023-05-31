public class Notebook {
    int ram;
    int disk_space;
    String os;
    String color;
    Notebook (int ram, int disk_space, String os, String color) {
        this.ram = ram; this.disk_space = disk_space;
        this.os = os; this.color = color;
    }

    public int getDisk_space() {        return disk_space;    }
    public int getRam() {        return ram;    }
    public String getColor() {        return color;    }
    public String getOs() {
        return os;
    }
    public int getValue (int key) {
        return switch (key) {
            case 1 -> getRam();
            case 2 -> getDisk_space();
            default -> -1;
        };
    }
    public String getStringParam (int key) {
        return switch (key) {
            case 3 -> getOs();
            case 4 -> getColor();
            default -> null;
        };
    }
}
