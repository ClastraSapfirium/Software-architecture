package modelelements;
import java.util.Collection;

public class Flash {
    //TODO: Добавить реализацию
    public class Location {

        private Collection<Point3D> Location;
    
        public Collection<Point3D> getPoints() {
            return Location;
        }
    }

    public class Angle {

        private Collection<Angle3D> Angle;
    
        public Collection<Angle3D> getPoints() {
            return Angle;
        }
    }

    public class Color {
        //id цвета
        private int id;
        // кол-во прожекторов
        static int counter = 0;
        // имя цветовой палитры
        private String name;
    
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
    
        {
            id = ++counter;
        }
    
        public Color(String name)
        {
            this.name = name;
        }
    }

    public class Pover {

        public boolean isActive() {
            return true;
        }
    }
}