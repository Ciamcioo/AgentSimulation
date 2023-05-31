package Core;
import Map.Map;

public interface ObjectOfMapMethods {
    int getCoordinateX();
    void setCoordinateX(int newCoordinateX, Map mapPartOf);
    int getCoordinateY();
    void setCoordinateY(int newCoordinateY);
    Map getMapPartOf();
    ObjectOfMap checkIfNeighbor(Map map, Class<?> neighborType);
    void setMapPartOf(Map map);
    void searching();
    String toString();


}
