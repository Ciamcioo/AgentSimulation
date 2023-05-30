package AgendClasses;
import Map.Map;
import Package.VaccineKit;
public class AgentBeforeIllness extends Agent {
    public AgentBeforeIllness(int coordinateX, int coordinateY, Map partMapOf){ //  Konstruktor AgentaBeforeIllness, który wywołuje konstruktor Agent
        super(coordinateX, coordinateY, partMapOf);
    }

    @Override
    public void chengingStatusOfAgent(Agent agent) {
        // TODO zmiana statusu obiektu typu AgentBeforeIllness poprzez tworzenie nowego obiektu, który zastąpi ten w tym momencie zmienany
        throw new UnsupportedOperationException("Unimplemented method 'chengingStatusOfAgent'");
    }
    public void checkingForVaccine(){         // Metoda poszukująca szczepionki w okolicy
        if(this.checkIfNeighbor(this.getMapPartOf(), VaccineKit.class)){
            // TODO dopisać jakieś zwracanie pozycji tego obiektu, którego będziemy poszukiwać
        }
    }
    @Override
    public String toString(){  // Reprezentacja agenta w konsoli
        return "B";
    }
}
