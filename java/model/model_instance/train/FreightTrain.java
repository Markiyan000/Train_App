package model.model_instance.train;

import model.model_instance.data.Route;

import java.util.Objects;
import java.util.Scanner;


/**
 * Class for describing freight train
 */


public class FreightTrain extends Train {
    /**
     * Field number of wagons
     */
    private int numberWagons;

    /**
     * Field cargo
     */
    private String cargo;

    /**
     * Constructor without parameters
     */
    public FreightTrain() {
    }

    /**
     * Constructor for creating new FreightTrain object
     *
     * @param ID           - index of train
     * @param name         - name of train
     * @param route        - route
     * @param numberWagons - number of wagons
     * @param cargo        - cargo
     */
    public FreightTrain(int ID, String name, Route route, int numberWagons, String cargo) {
        super(ID, name, route);
        this.numberWagons = numberWagons;
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FreightTrain that = (FreightTrain) o;
        return numberWagons == that.numberWagons &&
                cargo.equals(that.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberWagons, cargo);
    }

    /**
     * Method for creating new FreightTrain object
     *
     * @return return new FreightTrain object
     */
    @Override
    public FreightTrain create(Scanner scanner) {
        Train baseTrain = super.create(scanner);
        System.out.print("Enter number of wagons -> ");
        int numberWagons = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter cargo -> ");
        cargo = scanner.nextLine();
        return new FreightTrain(baseTrain.ID, baseTrain.name, baseTrain.route, numberWagons, cargo);
    }

    /**
     * Method for an extended description of the train
     *
     * @return return extended description of the train
     */
    @Override
    public String infoTrain() {
        return super.infoTrain() + "\nNumber of wagons: " + numberWagons + "\nCargo: " + cargo;
    }
}
