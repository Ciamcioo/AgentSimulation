package Package;
import AgentClasses.SickAgent;
import Map.Map;

/**
 * Klasa izolacji
 */
public class Isolation extends Package {
    /**
     * Konstruktor klasy <code>Isolation</code>
     * @param coordinateX współrzędna X izolacji
     * @param coordinateY współrzędna Y izolacji
     * @param mapPartOf mapa na której znajduje się izolacja
     */
    public Isolation(int coordinateX,int coordinateY, Map mapPartOf) {
        super(coordinateX, coordinateY, mapPartOf);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }

    /**
     * Wywołuje akcje obiektu. Jeżeli znajdzie wokół chorego, zmienia pole tego chorego na puste.
     */
    public void responseForCallingOfActionOfObject() {
        SickAgent foundObject = (SickAgent) this.checkIfNeighbor(this.getMapPartOf(), SickAgent.class);
        if (foundObject != null) {
            foundObject.changingStatusOfAgent();
            this.setEmpty();
            foundObject.getMapPartOf().getDataOfSimulation().setNumberOfSickAgents(this.getMapPartOf().getDataOfSimulation().getNumberOfSickAgents() - 1);
        }
    }

    /**
     * Reprezentacja izolacji w konsoli
     * @return litera odpowiadająca izolacji (I)
     */
    @Override
    public String toString(){ // Reprezentacje Isolation w konsoli
        return "I";
    }

}
