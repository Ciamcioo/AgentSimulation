package AgentClasses;
import Map.ObjectOfMap;
import Map.Map;
import Package.VaccineKit;

public class AgentBeforeIllness extends Agent {
    private boolean isVaccinated = false;
    // Konstruktor klasy AgentBeforeIllness
    public AgentBeforeIllness(int coordinateX, int coordinateY, Map partMapOf){
        super(coordinateX, coordinateY, partMapOf);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }
    // Metoda zwraca wartość boolean odpowiadającą informacji czy obiektu typu AgentBeforeIllness jest zaszczepiony
    public boolean getVaccinated(){
        return this.isVaccinated;
    }
    // Metoda przypisuje wartość boolean odpowiadającą informacji jaka zostanie przekazana w argumencie funkcji, czy obiekt jest zaszczepiony lub nie
    public void setVaccinated(boolean isVaccinated){
        this.isVaccinated = isVaccinated;
    }
    @Override
    public void changingStatusOfAgent() {
        if(isVaccinated){
            VaccinatedAgent newAgent = new VaccinatedAgent(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newAgent);
        }
        else{
            SickAgent newAgent = new SickAgent(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf(), this.getMapPartOf().getDataOfSimulation().getMinDayTillEndOfIllness(), this.getMapPartOf().getDataOfSimulation().getMaxDayTillEndOfIllness());
            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newAgent);
            this.getMapPartOf().getDataOfSimulation().setNumberOfHealthyAgents(this.getMapPartOf().getDataOfSimulation().getNumberOfHealthyAgents() - 1);
            this.getMapPartOf().getDataOfSimulation().setNumberOfSickAgents(this.getMapPartOf().getDataOfSimulation().getNumberOfSickAgents() + 1);
            this.getMapPartOf().setChangedObjects(this.getMapPartOf().getChangedObjects() + 1);
        }
    }
    @Override
    public void searching(){
        VaccineKit foundObject = (VaccineKit) this.checkIfNeighbor(this.getMapPartOf(), VaccineKit.class);
        if(foundObject != null){
            if(foundObject.getMapPartOf().getDataOfSimulation().getNumberOfVaccineInKit() != 0) {
                this.setVaccinated(true);
                this.changingStatusOfAgent();
                foundObject.getMapPartOf().getDataOfSimulation().setNumberOfVaccineInKit(foundObject.getMapPartOf().getDataOfSimulation().getNumberOfVaccineInKit()-1);
            }
        }
    }
    @Override
    public void responseForCallingOfActionOfObject(){
        this.move();
        this.searching();
    }
    @Override
    public String toString(){  // Reprezentacja agenta w konsoli
        return "B";
    }
}
