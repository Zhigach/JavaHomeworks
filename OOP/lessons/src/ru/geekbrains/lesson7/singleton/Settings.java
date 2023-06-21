package ru.geekbrains.lesson7.singleton;

public class Settings {

    private static Settings instance;

    private String param1;
    private int param2;

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }

    private Settings(){

    }

    public static  Settings getInstance(){
        if (instance != null)
            instance = new Settings();
        return instance;
    }


}
