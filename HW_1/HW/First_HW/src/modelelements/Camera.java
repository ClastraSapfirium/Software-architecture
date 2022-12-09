package modelelements;
import java.util.Collection;

    //TODO: Добавить реализацию

public class Camera {
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

    public class Rotate {

        private Collection<Angle3D> Rotate;
    
        public Collection<Angle3D> getPoints() {
            return Rotate;
        }
        private int degree;
    
        public int getdegree() {
            return degree;
        }
        public void setdegree(int degree) {
            this.degree = degree;
        }
    }

    public class Move {

        private Collection<Point3D> Move;
    
        public Collection<Point3D> getPoints() {
            return Move;
        }
    }
}
