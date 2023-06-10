package AgentClasses;
import Map.Map;
import Map.EmptyField;

import java.util.Random;

public class SickAgent extends Agent{
    private int minDayTillEndOfIllness, maxDayTillEndOfIllness, dayTillEndOfIllness;

    // Konstruktor klasy SickAgent
    public SickAgent(int coordinateX, int coordinateY, Map partMapOf,int minDayTillEndOfIllness, int maxDayTillEndOfIllness){
        super(coordinateX, coordinateY, partMapOf);
        this.setDayTillEndOfIllness(new Random().nextInt(maxDayTillEndOfIllness - minDayTillEndOfIllness) + minDayTillEndOfIllness);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }
    // Metoda zwraca wartość int, która określa ilość dni obiektu zanim zakończy się jego choroba
    public int getDayTillEndOfIllness(){
        return this.dayTillEndOfIllness;
    }
    // Metoda przypisuje wartość int odpowiadająca ilości dni jaka musi upłynąć by obiekty wyzdrowiał
    public void setDayTillEndOfIllness(int dayTillEndOfIllness){
        if(dayTillEndOfIllness > 0)
            this.dayTillEndOfIllness = dayTillEndOfIllness ;
    }
    @Override
    public void changingStatusOfAgent(){
        if(this.dayTillEndOfIllness == 0){
            AgentAfterIllness newAgent = new AgentAfterIllness(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newAgent);
        }
        else{
            EmptyField newField = new EmptyField(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newField);
        }
        this.getMapPartOf().getDataOfSimulation().setNumberOfSickAgents(this.getMapPartOf().getDataOfSimulation().getNumberOfSickAgents() - 1);
        this.getMapPartOf().setChangedObjects(this.getMapPartOf().getChangedObjects() + 1);
    }

    @Override
    public void searching(){
        AgentBeforeIllness foundObject = (AgentBeforeIllness) this.checkIfNeighbor(this.getMapPartOf(), AgentBeforeIllness.class);
        if(foundObject != null)
            foundObject.changingStatusOfAgent();
    }
    public void responseForCallingOfActionOfObject(){
        this.move();
        this.searching();
        this.setDayTillEndOfIllness(this.getDayTillEndOfIllness() - 1);
        if (this.getDayTillEndOfIllness() == 0)
            this.changingStatusOfAgent();
        else if (this.getMapPartOf().getDataOfSimulation().getChanceOfSickAgentDeath() >= new Random().nextDouble(1))
            this.changingStatusOfAgent();
    }
    @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "S";
    }

}