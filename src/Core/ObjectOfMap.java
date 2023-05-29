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

    public int getCoordinateX(){
        return this.coordinateX;
    }

    public void setCoordinateX(int newCoordinateX, Map mapPartOf){
        if(newCoordinateX > 0 && newCoordinateX < mapPartOf.getSize())
            this.coordinateX = newCoordinateX;
    }
    public int getCoordinateY(){
        return this.coordinateY;
    }
    public void setCoordinateY(int newCoordinateY){
        if(newCoordinateY > 0 || newCoordinateY < mapPartOf.getSize())
            this.coordinateY = newCoordinateY;
    }
    public Map getMapPartOf(){
        return this.mapPartOf;
    }

    public void setMapPartOf(Map map){
        this.mapPartOf = map;
    }



}
