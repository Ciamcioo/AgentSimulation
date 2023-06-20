package Map;

/**
 * Interfejs metod obiektu mapy
 */
public interface ObjectOfMapMethods {
    /**
     * Zwraca wartość int odpowiadającą współrzędnej X obiektu
     * @return współrzedna X obiektu
     */
    int getCoordinateX();

    /**
     * Przypisuje poprawną wartość int odpowiadającą współrzędnej X obiektu
     * @param newCoordinateX nowa współrzedna X obiektu
     */
    void setCoordinateX(int newCoordinateX);

    /**
     * Zwraca wartość int odpowiadającą współrzędnej Y obiektu
     * @return współrzedna Y obiektu
     */
    int getCoordinateY();

    /**
     * Przypisuje poprawną wartość int odpowiadającą współrzędnej Y obiektu
     * @param newCoordinateY nowa współrzedna X obiektu
     */
    void setCoordinateY(int newCoordinateY);

    /**
     * Zwraca mapę do której należy obiekt
     * @return mapa do której należy obiekt
     */
    Map getMapPartOf();

    /**
     * Przypisuje obiektowi mapę do której należy
     * @param map mapa do której należy obiekt
     */
    void setMapPartOf(Map map);

    /**
     * Zwraca referencję do obiektu typu <code>ObjectOfMap</code>, jeżeli obiekt danej w argumencie klasy znajduje się wokół pierwotnego obiektu. W przeciwnym wypadku zwraca <code>null</code>
     * @param map mapa symulacji
     * @param neighborType typ szukanego obiektu
     * @return szukany obiekt
     */
    ObjectOfMap checkIfNeighbor(Map map, Class<?> neighborType);

    /**
     * Metoda współdziałająca z metodą <code>checkIfNeighbor</code>, analizuje zwrócone dane przez wyżej wymienioną funkcję i podejmuje odpowiednie działanie
     */
    void searching();

    /**
     * Zwraca reprezentację obiektu w konsoli w postaci String-a
     * @return znak reprezentujący dany obiekt
     */
    String toString();

    /**
     * Metoda odpowiedzialna za wywoływanie poszczególnych zachowań dla obiektów określonych typów
     */
    void responseForCallingOfActionOfObject();

}
