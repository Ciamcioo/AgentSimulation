package AgentClasses;
import Map.Map;
import Map.EmptyField;

import java.util.Random;

public class SickAgent extends Agent{
    private int dayTillEndOfIllness;
    private double chanceOfDeath;
    // Konstruktor klasy SickAgent
    public SickAgent(int coordinateX, int coordinateY, Map partMapOf){
        super(coordinateX, coordinateY, partMapOf);
        this.setChanceOfDeath(new Random().nextDouble(0.1));
        this.setDayTillEndOfIllness(new Random().nextInt(21)+1);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }
    // Metoda zwraca wartość int, która określa ilość dni obiektu zanim zakończy się jego choroba
    public int getDayTillEndOfIllness(){
        return this.dayTillEndOfIllness;
    }
    // Metoda przypisuje wartość int odpowiadająca ilości dni jaka musi upłynąć by obiekty wyzdrowiał
    public void setDayTillEndOfIllness(int dayTillEndOfIllness){
        if(dayTillEndOfIllness >= 0)
            this.dayTillEndOfIllness = dayTillEndOfIllness ;
    }
    // Metoda zwraca wartość double, która określa jaka jest szansa, że obiekty zginie w czasie iteracji
    public double getChanceOfDeath(){ // Zwraca procentową szanse śmierci agenta
        return this.chanceOfDeath;
    }
    // Metoda przypisuje wartość double odpowiadająca szansie procentowej (zapisanej w postaci liczby double) na to, że obiekt zginie w czasie iteracji
    public void setChanceOfDeath(double chanceOfDeath){
        if(chanceOfDeath > 0 && chanceOfDeath < 1)
         this.chanceOfDeath = chanceOfDeath;
    }
    @Override
    public void changingStatusOfAgent(){
        if(this.dayTillEndOfIllness == 0){
            AgentAfterIllness newAgent = new AgentAfterIllness(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
//            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newAgent);
        }
        else{
            EmptyField newField = new EmptyField(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
//            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newField);
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
        if (this.getDayTillEndOfIllness() == 0)
            this.changingStatusOfAgent();
        else if (this.getChanceOfDeath() >= new Random().nextDouble(1))
            this.changingStatusOfAgent();
    }
    @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "S";
    }

}