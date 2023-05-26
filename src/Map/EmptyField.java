package Map;

import Core.ObjectOfMap;

public class EmptyField extends ObjectOfMap {
    private boolean isEmpty;

    public EmptyField(int coordinateX,int coordinateY, Map mapPartOf){
        super(coordinateX, coordinateY, mapPartOf);
        this.isEmpty = true;

    }
    public String toString(){
        return " ";
    }
}
