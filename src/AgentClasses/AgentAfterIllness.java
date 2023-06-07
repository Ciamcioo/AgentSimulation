package AgentClasses;
import Map.Map;
public class AgentAfterIllness extends Agent{
    public AgentAfterIllness(int coordinateX, int coordinateY, Map mapPartOf){
        super(coordinateX, coordinateY, mapPartOf);

    }
    public void responseForCallingOfActionOfObject(){
        // TODO okodowanie wszystkich kroków obiektu typu AgentAfterIllness, czyli np. metoda move dla tego obiektu. To chyba tyle bo ten obiekt na tym swoje dzialanie konczy
    }

    @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "A";
    }


}
