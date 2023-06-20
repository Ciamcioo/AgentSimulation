package Map;

/**
 * Klasa pustego pola
 */
public class EmptyField extends ObjectOfMap {
    /**
     * Konstruktor klasy <code>EmptyField</code>
     * @param coordinateX współrzędna X agenta
     * @param coordinateY współrzędna Y agenta
     * @param mapPartOf mapa na której znajduje się agent
     */
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

    public void responseForCallingOfActionOfObject() {
    }

    /**
     * Reprezentacja w konsoli
     * @return znak odpowiadający pustemu polu (spacja)
     */
    public String toString() {
        return " ";
    }
}
