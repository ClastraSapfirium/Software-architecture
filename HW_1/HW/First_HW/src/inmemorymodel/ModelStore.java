package inmemorymodel;

import java.util.ArrayList;
import java.util.Collection;

import modelelements.Camera;
import modelelements.Flash;
import modelelements.PoligonalModel;
import modelelements.Scene;

public class ModelStore implements ModelChanger {

    // Протянуть оставшиеся поля
    Camera camera = new Camera();
    Flash flash = new Flash();
    Scene scene = new Scene();
    PoligonalModel poligonalModel = new PoligonalModel();

    private Collection<ModelChangedObserver> _observers = new ArrayList<>();

    @Override
    public void registerModelChanger(ModelChangedObserver o) {
        _observers.add(o);
    }

    @Override
    public void removeModelChanger(ModelChangedObserver o) {
        _observers.remove(o);
    }

    public void writeString(String str){
        notifyChange();
    }

    @Override
    public void notifyChange() {
        for (ModelChangedObserver o : _observers){
            o.applyUpdateModel();
        }
    }
}
