package model.model_instance.train;

import model.model_instance.data.Route;

public class FreightTrain extends Train {

    public FreightTrain(){}

    public FreightTrain(int ID, String type, String name, int numberCarriages, Route route) {
        super(ID, type, name, route);
    }

}
