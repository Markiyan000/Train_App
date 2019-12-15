package model.model_instance;

import java.util.InputMismatchException;

public interface Creatable {
    Creatable create() throws InputMismatchException;
}
