package AgendClasses;
import Map.Map;
public class AgentAfterIllness extends Agent{
    public AgentAfterIllness(int coordinateX, int coordinateY, Map mapPartOf){  //  Konstruktor AgentaAfterIllness, który wywołuje konstruktor Agent
        super(coordinateX, coordinateY, mapPartOf);

    }

    @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "A";
    }


}
