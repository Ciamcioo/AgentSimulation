package AgentClasses;
import Map.Map;
import Map.EmptyField;

import java.util.Random;

public class SickAgent extends Agent{
    private int dayTillEndOfIllness;
    private double chanceOfDeath;
    public SickAgent(int coordinateX, int coordinateY, Map partMapOf){
        super(coordinateX, coordinateY, partMapOf);
        this.setChanceOfDeath(new Random().nextDouble(0.1));
        this.setDayTillEndOfIllness(new Random().nextInt(21)+1);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }
    public int getDayTillEndOfIllness(){
        return this.dayTillEndOfIllness;
    }
    public void setDayTillEndOfIllness(int dayTillEndOfIllness){
        if(dayTillEndOfIllness >= 0)
            this.dayTillEndOfIllness = dayTillEndOfIllness ;
    }
    public double getChanceOfDeath(){ // Zwraca procentową szanse śmierci agenta
        return this.chanceOfDeath;
    }
    public void setChanceOfDeath(double chanceOfDeath){
        if(chanceOfDeath > 0 && chanceOfDeath < 1)
         this.chanceOfDeath = chanceOfDeath;
    }
    @Override
    public void changingStatusOfAgent(){
        if(this.dayTillEndOfIllness == 0){
            AgentAfterIllness newAgent = new AgentAfterIllness(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newAgent);
            this.getMapPartOf().setSickAgents(this.getMapPartOf().getSickAgents() - 1);
            this.getMapPartOf().setChangedObjects(this.getMapPartOf().getChangedObjects() + 1);
        }
        else{
            EmptyField newField = new EmptyField(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newField);
            this.getMapPartOf().setSickAgents(this.getMapPartOf().getSickAgents() - 1);
            this.getMapPartOf().setChangedObjects(this.getMapPartOf().getChangedObjects() + 1);
        }
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
        if (this.getDayTillEndOfIllness() == 0)
            this.changingStatusOfAgent();
        else if (this.getChanceOfDeath() >= new Random().nextDouble(1))
            this.changingStatusOfAgent();
        // TODO dopisanie testu do tej metody, ale tak samo to tez ja mogę zrobić
    }
    @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "S";
    }

}