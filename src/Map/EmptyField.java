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
    public void searching(){
        try {
            throw new Exception("Error this object cannot search");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
