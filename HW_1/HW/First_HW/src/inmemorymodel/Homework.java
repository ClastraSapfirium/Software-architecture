package inmemorymodel;

public class Homework {

    public static void main(String[] args) {
        MyModelObserver1 MyModelObserver1 = new MyModelObserver1();
        MyModelObserver2 MyModelObserver2 = new MyModelObserver2();
        ModelStore ModelStore = new ModelStore();
        ModelStore.registerModelChanger(MyModelObserver1);
        ModelStore.registerModelChanger(MyModelObserver2);

        ModelStore.writeString("Hello HW");
        ModelStore.removeModelChanger(MyModelObserver1);
        ModelStore.writeString("Hello HW!!!");

        //TODO: ...
        //TODO: Спроектировать класс-наблюдатель ( на базе интерфейса ModelChangedObserver)

    }
}

class MyModelObserver1 implements ModelChangedObserver{
    public void applyUpdateModel() { System.out.println("MyModelObserver1 -> File will changed ..."); }
}

class MyModelObserver2 implements ModelChangedObserver{
    public void applyUpdateModel() { System.out.println("MyModelObserver2 -> File will changed ..."); }  
}
