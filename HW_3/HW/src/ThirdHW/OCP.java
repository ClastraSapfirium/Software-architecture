package ThirdHW;

public class OCP {


    public static void main(String[] args) {

    }

}

enum ShapeType{
    Circle,
    Square
}

class Shape{

    private ShapeType type;

    public ShapeType getType() {
        return type;
    }
}

class SimpleDrawer{

    public void Drawer(Shape shape){
        switch (shape.getType()){
            case Circle:
                drawCircle(shape);
                break;
            case Square:
                drawSquare(shape);
                break;
        }
    }

    private void drawCircle(Shape shape){
        //...
    }

    private void drawSquare(Shape shape){
        //...
    }

}

class SimpleDrawerV2{

    public void Draw(ShapeV2 shape){
        shape.draw();
    }

    public void move(int a, int b){

    }

    public void move(int a, int b, int c){

    }

    public void clear(int a){

    }

}

abstract class ShapeV2{

    public abstract void draw();

}

class CircleV2 extends ShapeV2{

    @Override
    public void draw() {
        //...
    }
}
