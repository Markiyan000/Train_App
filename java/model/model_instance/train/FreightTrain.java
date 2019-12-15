package model.model_instance.train;

import model.model_instance.data.Route;

public class FreightTrain extends Train {

    public FreightTrain(){}

    public FreightTrain(int ID, String name,Route route) {
        super(ID, name, route);
    }

}
