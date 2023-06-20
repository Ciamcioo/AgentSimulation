package AgentClasses;
import Map.Map;

/**
 * Klasa zaszczepionego agenta
 */
public class VaccinatedAgent extends Agent {
    /**
     * Konstruktor klasy <code>VaccinatedAgent</code>
     * @param coordinateX współrzędna X
     * @param coordinateY współrzędna Y
     * @param partMapOf mapa na której znajduje się agent
     */
    public VaccinatedAgent(int coordinateX, int coordinateY, Map partMapOf) {
        super(coordinateX, coordinateY, partMapOf);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }

    /**
     * Reprezentacja agenta w konsoli
     * @return litera odpowiadająca agentowi zaszczepionemu (V)
     */
    @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "V";
    }
}
