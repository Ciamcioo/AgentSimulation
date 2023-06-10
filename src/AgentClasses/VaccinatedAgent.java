package AgentClasses;
import Map.Map;
public class VaccinatedAgent extends Agent {
    // Konstruktor klasy VaccinatedAgent
    public VaccinatedAgent(int coordinateX, int coordinateY, Map partMapOf){
        super(coordinateX, coordinateY, partMapOf);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }

    @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "V";
    }
}
