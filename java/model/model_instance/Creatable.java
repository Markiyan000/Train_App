package model.model_instance;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface Creatable {
    Creatable create(Scanner scanner) throws InputMismatchException;
}
