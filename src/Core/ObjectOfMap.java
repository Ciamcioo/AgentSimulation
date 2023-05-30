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

    public int getCoordinateX(){ // Zwraca współrzedną X obiektu typu ObjectOfMap
        return this.coordinateX;
    }

    public void setCoordinateX(int newCoordinateX, Map mapPartOf){ // Ustawia współrzedną X obiektu typu ObjectOfMap
        if(newCoordinateX > 0 && newCoordinateX < mapPartOf.getSize())
            this.coordinateX = newCoordinateX;
    }
    public int getCoordinateY(){ // Zwraca współrzedną Y obiektu typu ObjectOfMap
        return this.coordinateY;
    }
    public void setCoordinateY(int newCoordinateY){ // Ustawianie współrzedną Y obiektu typu ObjectOfMap
        if(newCoordinateY > 0 || newCoordinateY < mapPartOf.getSize())
            this.coordinateY = newCoordinateY;
    }
    public Map getMapPartOf(){ // Zwraca mapę do której należy obiekty typu ObjectOfMap
        return this.mapPartOf;
    }

    public void setMapPartOf(Map map){ // Ustawia mapę do której należy obiekty typu ObjectOfMap
        this.mapPartOf = map;
    }



}
