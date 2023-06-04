package AgendClasses;
import Core.ObjectOfMap;
import Map.Map;
import Map.EmptyField;

public class SickAgent extends Agent{
    private int dayTillEndOfIllness;
    private double chanceOfDeath;
    public SickAgent(int coordinateX, int coordinateY, Map partMapOf, int dayTillEndOfIllness, double chanceOfDeath){
        super(coordinateX, coordinateY, partMapOf);
        this.setChanceOfDeath(chanceOfDeath);
        this.setDayTillEndOfIllness(dayTillEndOfIllness);
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
    public void searching(){ // TODO dopisać test dla tej metody
        ObjectOfMap foundObject = this.checkIfNeighbor(this.getMapPartOf(), AgentBeforeIllness.class);
        if(foundObject != null){
            AgentBeforeIllness agentFound = (AgentBeforeIllness) foundObject;
            agentFound.chengingStatusOfAgent();
        }

    }


    @Override
    public void chengingStatusOfAgent(){
        if(this.dayTillEndOfIllness == 0){
            AgentAfterIllness newAgent = new AgentAfterIllness(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newAgent);
        }
        else{
            EmptyField newField = new EmptyField(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newField);
        }
    } @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "S";
    }

}