package AgendClasses;
import Map.Map;
public class VaccinatedAgent extends Agent {
    public VaccinatedAgent(int coordinateX, int coordinateY, Map partMapOf){
        super(coordinateX, coordinateY, partMapOf);
    }

    @Override
    public void checkPosition(int X, int Y) {

    }

    @Override
    public void chengingStatusOfAgent(Agent agent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chengingStatusOfAgent'");
    }
    @Override
    public String toString(){
        return "VA";
    }
    public void move(){
    }
}
