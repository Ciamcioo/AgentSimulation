package AgendClasses;
import Map.Map;
public class VaccinatedAgent extends Agent {
    public VaccinatedAgent(int coordinateX, int coordinateY, Map partMapOf){ // Konstruktor SickAgent, który wywołuje konstruktor Agent
        super(coordinateX, coordinateY, partMapOf);
    }
    @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "V";
    }
}
