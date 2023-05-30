package AgendClasses;
import Map.Map;
public class VaccinatedAgent extends Agent {
    public VaccinatedAgent(int coordinateX, int coordinateY, Map partMapOf){ // Konstruktor SickAgent, który wywołuje konstruktor Agent
        super(coordinateX, coordinateY, partMapOf);
    }


    @Override
    public void chengingStatusOfAgent(Agent agent) {
        // TODO zmiana statusu obiektu typu VaccinatedAgent poprzez tworzenie nowego obiektu, który zastąpi ten w tym momencie zmienany
        throw new UnsupportedOperationException("Unimplemented method 'chengingStatusOfAgent'");
    }
    @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "V";
    }
}
