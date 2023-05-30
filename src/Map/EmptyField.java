package Map;

import Core.ObjectOfMap;

public class EmptyField extends ObjectOfMap {
    private boolean isEmpty;

    public EmptyField(int coordinateX,int coordinateY, Map mapPartOf){  // Konstrukotr klasy EmptyField, który wywołuje konstruktor klasy ObjectOfMap
        super(coordinateX, coordinateY, mapPartOf);
        this.isEmpty = true;

    }
    public String toString(){ // Reprezentacja EmptyField w konsoli
        return " ";
    }
}
