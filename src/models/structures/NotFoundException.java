package models.structures;

public class NotFoundException extends  Exception{

    private static final String MESSAGE_NOT_FOUND = "El elemento buscando no existe en la lista.";

    public NotFoundException() {
        super(MESSAGE_NOT_FOUND);
    }
}
