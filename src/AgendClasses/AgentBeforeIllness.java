package AgendClasses;
import Map.Map;
public class AgentBeforeIllness extends Agent {
    public AgentBeforeIllness(int coordinateX, int coordinateY, Map partMapOf){ //  Konstruktor Agenta, który wywołuje konstruktor ObjectOfMap
        super(coordinateX, coordinateY, partMapOf);
    }

    @Override
    public void chengingStatusOfAgent(Agent agent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chengingStatusOfAgent'");
    }
    @Override
    public String toString(){
        return "B";
    } // wyświetla na mapie
}
