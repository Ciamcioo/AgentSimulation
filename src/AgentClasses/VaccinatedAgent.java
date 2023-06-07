package AgentClasses;
import Map.Map;
public class VaccinatedAgent extends Agent {
    public VaccinatedAgent(int coordinateX, int coordinateY, Map partMapOf){
        super(coordinateX, coordinateY, partMapOf);
    }

    @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "V";
    }
}
