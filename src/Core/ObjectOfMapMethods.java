package Core;
import Map.Map;

public interface ObjectOfMapMethods {
    int getCoordinateX();
    void setCoordinateX(int newCoordinateX, Map mapPartOf);
    int getCoordinateY();
    void setCoordinateY(int newCoordinateY);
    Map getMapPartOf();
    void setMapPartOf(Map map);
    String toString();


}
