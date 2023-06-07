package AgentClasses;
import Map.Map;
public class AgentAfterIllness extends Agent{
    public AgentAfterIllness(int coordinateX, int coordinateY, Map mapPartOf){
        super(coordinateX, coordinateY, mapPartOf);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }
    @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "A";
    }


}
