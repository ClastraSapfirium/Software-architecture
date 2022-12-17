package ThirdHW;

import java.awt.*;

public class Main {


    //TODO: ДОМАШНЯЯ РАБОТА
    // Составить UML  диаграмму классов всех сущностей данного файла.

    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     * быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     * топлива, тип коробки передач, объём двигателя; методы:
     * движение, обслуживание, переключение передач, включение
     * фар, включение дворников.
     *
     * 2. Создать конкретный автомобиль путём наследования класса
     *      * «Car».
     *
     * 3. Расширить абстрактный класс «Car», добавить метод: подметать
     *      * улицу. Создать конкретный автомобиль путём наследования
     *      * класса «Car». Провести проверку принципа SRP.
     *
     *  4. Расширить абстрактный класс «Car», добавить метод:
     *      * включение противотуманных фар, перевозка груза. Провести
     *      * проверку принципа OCP.
     *
     *  5. Создать конкретный автомобиль путём наследования класса
     *      * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     *
     *   6. Создать конкретный автомобиль путём наследования класса
     *      * «Car», определить метод «движение» - «полёт». Провести
     *      * проверку принципа LSP.
     *
     *   7. Создать интерфейс «Заправочная станция», создать метод:
     *      * заправка топливом.
     *
     * 8. Имплементировать метод интерфейса «Заправочная станция» в
     *      * конкретный класс «Car».
     *
     *      9. Добавить в интерфейс «Заправочная станция» методы: протирка
     *      * лобового стекла, протирка фар, протирка зеркал.
     *
     * 10. Имплементировать все методы интерфейса «Заправочная
     *      * станция» в конкретный класс «Car». Провести проверку
     *      * принципа ISP. Создать дополнительный/е интерфейсы и
     *      * имплементировать их в конкретный класс «Car». Провести
     *      * проверку принципа ISP.
     *
     *  11. Создать путём наследования класса «Car» два
     *      * автомобиля: с бензиновым и дизельным двигателями,
     *      * имплементировать метод «Заправка топливом» интерфейса
     *      * «Заправочная станция». Реализовать заправку каждого
     *      * автомобиля подходящим топливом. Провести проверку принципа DIP.
     */
    public static void main(String[] args) {

    }

    public static double calculateMaintenance(Car car){
        if (car.getWheelsCount() == 6){
            return 900*6;
        }
        else {
            return 1000 * 4;
        }
    }

    public static void movementCar(Car car){
        car.movement();
    }

}

interface Wiping{
    void wipMirrors();
    void wipWindshield();
    void wipHeadlights();
}

class RefuelingStation1 implements Refueling{

    @Override
    public void fuel(FuelType type) {
        switch (type){
            case Gasoline -> System.out.println("Автомобиль заправлен бензином");
            case Diesel -> System.out.println("Автомобиль заправлен дизельным топливом");
        }
    }
}
class RefuelingStation2 implements Refueling{

    @Override
    public void fuel(FuelType type) {
        switch (type){
            case Gasoline -> System.out.println("Автомобиль заправлен бензином");
            case Diesel -> System.out.println("Автомобиль заправлен дизельным топливом");
        }
    }
}

class RefuelingStation3 implements Refueling{

    @Override
    public void fuel(FuelType type) {
        switch (type){
            case Gasoline -> System.out.println("Автомобиль заправлен бензином");
            case Diesel -> throw new RuntimeException("Автомобили на дизельном топливе не обслуживаются!!!");
        }
    }
}

interface Refueling{

    /**
     * Заправка
     */
    void fuel(FuelType type);


}

/**
 * Тип коробки передач
 */
enum GearboxType{
    AT, // Automatic transmission
    MT  // Manual transmission
}

/**
 * Тип топлива
 */
enum FuelType{
    Diesel,
    Gasoline
}

/**
 * Тип кузова
 */
enum CarType{
    Sedan,
    Hatchback,
    Pickup,
    Sport
}


class SuperCar extends Car implements Wiping{

    private Refueling station;

    public SuperCar(){
        wheelsCount = 3;
        fuelType = FuelType.Gasoline;
    }



    public void setRefuelingStation(Refueling station){
        this.station = station;
        fuel();
    }


    public void fuel() {
        station.fuel(fuelType);
    }

    @Override
    public void movement() {
        fly();
        //System.out.println("Суперкар в движении ...");
    }

    public void fly(){
        System.out.println("Суперкар летит ...");
    }


    @Override
    public void wipMirrors() {

    }

    @Override
    public void wipWindshield() {

    }

    @Override
    public void wipHeadlights() {

    }
}


class Harvester extends Car{

    Harvester(){
        wheelsCount = 6;
        fuelType = FuelType.Diesel;
    }

    public void fuel() {
        switch (fuelType){
            case Gasoline -> System.out.println("Автомобиль заправлен бензином");
            case Diesel -> System.out.println("Автомобиль заправлен дизельным топливом");
        }
    }

    public void sweeping(){
        System.out.println("Автомобиль метет улицу.");
    }

    @Override
    public void movement() {
        System.out.println("Автомобиль в движении ...");
    }

    @Override
    public void shipping() {

        System.out.printf("Уборочная машина перевозит груз весом %d кг.", loadCapacity);
    }


}

abstract class Car{


    public abstract void fuel();
    // Движение
    public abstract void movement();
    // Обслуживание
    public void maintenance(){
        System.out.println("Автомобиль на обслуживании");
    }
    // Переключение передач
    public  void gearShifting(){
        System.out.println("Переключение передачи");
    }
    // Включение фар
    public void switchHeadlights() {
        System.out.println("Включение фар");
    }
    // Включение дворников
    public void switchWipers(){
        System.out.println("Включение дворников");
    }

    // Грузоподъемность
    protected int loadCapacity;

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    // Перевозка груза
    public void shipping(){
        System.out.printf("Автомобиль перевозит груз весом %d кг.", loadCapacity);
    }



    private boolean fogLights = false;
    public boolean switchFogLights(){
        fogLights = !fogLights;
        return fogLights;
    }

    // Марка автомобиля
    private String make;
    // Модель
    private String model;
    // Цвет
    private Color color;
    // Тип
    protected CarType type;
    // Число колес
    protected int wheelsCount;
    // Тип топлива
    protected FuelType fuelType;
    // Тип коробки передач
    private GearboxType gearboxType;
    // Объем двигателя
    private double engineCapacity;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }

    public CarType getType() {
        return type;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }
}
