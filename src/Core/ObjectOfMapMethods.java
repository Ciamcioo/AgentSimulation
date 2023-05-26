package Core;
import Map.Map;

public interface ObjectOfMapMethods {
    int getCoordinateX();
    void setCoordinateX(int newCoordinateX);
    int getCoordinateY();
    void setCoordinateY(int newCoordinateY);
    String toString();
    Map getMapPartOf();
    void setMapPartOf(Map map);


}
