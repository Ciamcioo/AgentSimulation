package AgendClasses;
import Map.Map;
public class AgentAfterIllness extends Agent{
    public AgentAfterIllness(int coordinateX, int coordinateY, Map mapPartOf){
        super(coordinateX, coordinateY, mapPartOf);

    }


    @Override
    public void chengingStatusOfAgent(Agent agent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chengingStatusOfAgent'");
    }
    @Override
    public String toString(){
        return "A";
    }


}
