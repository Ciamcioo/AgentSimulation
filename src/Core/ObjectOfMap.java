package Core;
import Map.Map;
public abstract class ObjectOfMap implements ObjectOfMapMethods{

    private int coordinateX;
    private int coordinateY;
    private Map mapPartOf;
    public ObjectOfMap(int coordinateX, int coordinateY, Map mapPartOf){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.mapPartOf = mapPartOf;
    }
    @Override
    public int getCoordinateX(){
        return this.coordinateX;
    }
    @Override
    public void setCoordinateX(int newCoordinateX){
        // TODO kontrola błędów przy ustawianiu kordynatów X
        this.coordinateX = newCoordinateX;
    }
    public int getCoordinateY(){
        return this.coordinateY;
    }
    public void setCoordinateY(int newCoordinateY){
        // TODO kontrola błęów przy ustawianiu kordynatów Y
        this.coordinateY = newCoordinateY;
    }
    public Map getMapPartOf(){
        return this.mapPartOf;
    }
    public void setMapPartOf(Map map){
        this.mapPartOf = map;
    }



}
