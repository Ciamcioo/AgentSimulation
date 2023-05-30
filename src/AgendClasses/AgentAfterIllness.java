package AgendClasses;
import Map.Map;
public class AgentAfterIllness extends Agent{
    public AgentAfterIllness(int coordinateX, int coordinateY, Map mapPartOf){  //  Konstruktor AgentaAfterIllness, który wywołuje konstruktor Agent
        super(coordinateX, coordinateY, mapPartOf);

    }


    @Override
    public void chengingStatusOfAgent(Agent agent) {
        // TODO zmiana statusu obiektu typu AgentAfterIllness poprzez tworzenie nowego obiektu, który zastąpi ten w tym momencie zmienany
        throw new UnsupportedOperationException("Unimplemented method 'chengingStatusOfAgent'");
    }
    @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "A";
    }


}
