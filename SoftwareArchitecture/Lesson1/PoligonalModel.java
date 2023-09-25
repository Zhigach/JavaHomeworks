package SoftwareArchitecture.Lesson1;

import java.util.ArrayList;

public class PoligonalModel {
    ArrayList<Poligon> poligons;
    ArrayList<Texture> textures;

    public void addTexture(Texture texture) {
        this.textures.add(texture);
    }

    public PoligonalModel(ArrayList<Poligon> poligons) {
        this.poligons = poligons;
    }
}
