package modelelements;

import java.util.Collection;

public class Poligon {

    private Collection<Point3D> Points;

    public Collection<Point3D> getPoints() {
        return Points;
    }

    public Poligon(Collection<Point3D> points) {
        this.Points = points;
    }
}