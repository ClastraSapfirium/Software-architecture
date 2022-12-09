package inmemorymodel;

public interface ModelChanger {
    void registerModelChanger(ModelChangedObserver o);
    void removeModelChanger(ModelChangedObserver o);

    void notifyChange();
}