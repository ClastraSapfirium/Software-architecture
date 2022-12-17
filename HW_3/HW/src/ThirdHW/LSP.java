package ThirdHW;

public class LSP {

    public static void main(String[] args) {

        // Тип S будет подтипом Т тогда и только тогда,
        // когда каждому объекту oS типа S соответствует некий объект oT типа T таким образом,
        // что для всех программ P,
        // реализованных в терминах T, поведение P не будет меняться, если oT заменить на oS.

        Bird oT1 = new Bird();
        Bird oT2 = new Bird();
        Bird oT3 = new Bird();

        fly(oT1);
        fly(oT2);
        fly(oT3);

        Duck oS1 = new Duck();
        Duck oS2 = new Duck();
        Duck oS3 = new Duck();

        fly(oS1);
        fly(oS2);
        fly(oS3);

        Penguin oS11 = new Penguin();
        Penguin oS22 = new Penguin();
        Penguin oS33 = new Penguin();

        fly(oS11);
        fly(oS22);
        fly(oS33);
    }

    public static void fly(Bird bird){ //ИЗ ОПРЕДЕЛЕНИЯ - P
        //bird.fly();

        if (bird instanceof Penguin){
            System.out.println("Пингвин не умеет летать!");
        }
        else {
            bird.fly();
        }

    }



}

/**
 * T
 */
class Bird{
    private int flySpeed = 10;

    public int getFlySpeed() {
        return flySpeed;
    }

    public void fly() {
        System.out.printf("Птица летит со скоростью %d км/ч\n", flySpeed);
    }
}

/**
 * S
 */
class Duck extends Bird {

    @Override
    public void fly() {
        System.out.printf("Птица летит со скоростью %d км/ч\n", 8);
    }

}

class Penguin extends Bird{
    @Override
    public void fly() {
        throw new RuntimeException("Пингвин не умеет летать!");
    }
}
