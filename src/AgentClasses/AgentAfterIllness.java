package AgentClasses;
import Map.Map;

/**
 * Klasa agenta po chorobie
 */
public class AgentAfterIllness extends Agent {
    /**
     * Konstruktor klasy <code>AgentAfterIllness</code>
     * @param coordinateX współrzędna X
     * @param coordinateY współrzędna Y
     * @param mapPartOf mapa na której znajduje się agent
     */
    public AgentAfterIllness(int coordinateX, int coordinateY, Map mapPartOf) {
        super(coordinateX, coordinateY, mapPartOf);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }

    /**
     * Reprezentacja agenta w konsoli
     * @return litera odpowiadająca agentowi po chorobie (A)
     */
    @Override
    public String toString() {
        return "A";
    }
}
