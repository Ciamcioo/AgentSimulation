package Map;

public interface ObjectOfMapMethods {
    // Metoda zwraca wartość int odpowiadającą kordyncacie x dla danego obiektu na mapie
    int getCoordinateX();
    // Metoda przypisuje poprawną  wartość int odpowiadająca kordynacie x dla danego obiektu na mapie
    void setCoordinateX(int newCoordinateX);
    // Metoda zwraca wartość int odpowiadającą kordynacie y dla danego obiektu na mapie
    int getCoordinateY();
    // Metoda przypisuje poprawną wartosć int odpowiadająca kordynacie y dla danego obiektu na mapie
    void setCoordinateY(int newCoordinateY);
    // Metoda zwraca mapę do której należy dany obiekty
    Map getMapPartOf();
    // Metoda przypisuje obiektowi mapę do której należy
    void setMapPartOf(Map map);
    // Metoda zwraca referencje do obiektu typu ObjectOfMap wywołany przez inny obiekty należący do tej samej mapy
    ObjectOfMap checkIfNeighbor(Map map, Class<?> neighborType);
    // Metoda współdziałająca z metoda checkIfNeighbor, analizuje zwrócone dane przez wyżej wymienioną funkcje i podejmuje odpowiednie działanie
    void searching();
    // Metoda zwraca reprezentacje obiektu w konsoli w postaci String-a
    String toString();
    // Metoda odpowiedzialna za wyowływanie poszczególnych zachowań dla obiektów określonych typów
    void responseForCallingOfActionOfObject();


}
