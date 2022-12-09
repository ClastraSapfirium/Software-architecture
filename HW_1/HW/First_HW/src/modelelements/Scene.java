package modelelements;

import java.util.Collection;

    //TODO: Добавить методы по добавлению моделей, света и камер

public class Scene {

    public class id {

        private int id;
        static int counter = 0;
    
    
        public int getId() {
            return id;
        }
    
        {
            id = ++counter;
        }
    
        public id(int id)
        {
            this.id = id;
        }
    
    }

    public class Models {

        private Collection<PoligonalModel> Models;
    
        public Collection<PoligonalModel> getModels() {
            return Models;
        }
    
        public Models(Collection<PoligonalModel> Models) {
            this.Models = Models;
        }
    }

    public class Location {

        private Collection<Flash> flashes;
    
        public Collection<Flash> getPoints() {
            return flashes;
        }
    }



    public class Cameras {

        private Collection<Camera> Cameras;
    
        public Collection<Camera> getPoints() {
            return Cameras;
        }
    }
}

