package Map;

public class EmptyField extends ObjectOfMap {
    // Konstruktor klasy EmptyField
    public EmptyField(int coordinateX,int coordinateY, Map mapPartOf){
        super(coordinateX, coordinateY, mapPartOf);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }
    public void searching(){
        try {
            throw new Exception("Error this object cannot search");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void responseForCallingOfActionOfObject(){

    }
    public String toString(){
        return " ";
    }
}
