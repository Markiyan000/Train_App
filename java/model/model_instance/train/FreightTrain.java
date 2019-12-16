package model.model_instance.train;

import model.model_instance.data.Route;


/**
 * Class for describing freight train
 */


public class FreightTrain extends Train {
    /** Field number of wagons */
    private int numberWagons;

    /**Field cargo*/
    private String cargo;

    /**
     * Constructor without parameters
     */
    public FreightTrain() {}

    /**
     * Constructor for creating new FreightTrain object
     * @param ID - index of train
     * @param name - name of train
     * @param route - route
     * @param numberWagons - number of wagons
     * @param cargo - cargo
     */
    public FreightTrain(int ID, String name, Route route, int numberWagons, String cargo) {
        super(ID, name, route);
        this.numberWagons = numberWagons;
        this.cargo = cargo;
    }

    /**
     * Method for creating new FreightTrain object
     * @return return new FreightTrain object
     */
    @Override
    public FreightTrain create() {
        Train baseTrain = super.create();
        System.out.print("Enter number of wagons -> ");
        int numberWagons = scanner.nextInt();
        System.out.print("Enter cargo -> ");
        cargo = scanner.nextLine();
        return new FreightTrain(baseTrain.ID, baseTrain.name, baseTrain.route, numberWagons, cargo);
    }

    /**
     * Method for an extended description of the train
     * @return return extended description of the train
     */
    @Override
    public String infoTrain() {
        return super.toString() + "Number of wagons: " + numberWagons + "\nCargo: " + cargo;
    }
}
