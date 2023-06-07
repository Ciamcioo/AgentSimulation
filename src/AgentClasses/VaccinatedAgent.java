package AgentClasses;
import Map.Map;
public class VaccinatedAgent extends Agent {
    public VaccinatedAgent(int coordinateX, int coordinateY, Map partMapOf){
        super(coordinateX, coordinateY, partMapOf);
    }
    public void responseForCallingOfActionOfObject(){
        // TODO Napisanie metody przechodzącej przez kolejne kroki obiektu typu VacinatedAgent to będzie jedynie move
        // TODO Napisanie testu do tej metody, tak samo mogę ja to zrobić
    }
    @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "V";
    }
}
