package SoftwareArchitecture.Lesson1;

import java.util.ArrayList;

public class ModelStore implements IModelChanger {
    ArrayList<PoligonalModel> models;
    ArrayList<Scene> scenes;
    ArrayList<Flash> flashes;
    ArrayList<Camera> cameras;

    private ArrayList<IModelChangeObserver> changeObservers;

    Scene GetScene(int id) {
        return new Scene();
    }
    public void NotifyChange(IModelChanger iModelChanger) {
        changeObservers.get(0).ApplyModelUpdate();
    }

}
