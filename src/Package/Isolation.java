package Package;
import AgentClasses.SickAgent;
import Map.Map;

public class Isolation extends Package{
    // Konstruktor klasy Isoaltion
    public Isolation(int coordinateX,int coordinateY, Map mapPartOf){
        super(coordinateX, coordinateY, mapPartOf);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }
    public void responseForCallingOfActionOfObject(){
        SickAgent foundObject = (SickAgent) this.checkIfNeighbor(this.getMapPartOf(), SickAgent.class);
        if(foundObject != null){
            foundObject.changingStatusOfAgent();
            this.setEmpty();
            foundObject.getMapPartOf().getDataOfSimulation().setNumberOfSickAgents(this.getMapPartOf().getDataOfSimulation().getNumberOfSickAgents() - 1);
            this.getMapPartOf().setChangedObjects(this.getMapPartOf().getChangedObjects() + 1);
        }
    }
    @Override
    public String toString(){ // Reprezentacje Isolation w konsoli
        return "I";
    }

}
