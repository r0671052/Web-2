package domain.model;

public class ModelException extends RuntimeException{
    public ModelException(String message){
        super(message);
    }
    public ModelException(){
        super();
    }
}
