package AgentClasses;
import Map.ObjectOfMap;
import Map.Map;
import Package.VaccineKit;

public class AgentBeforeIllness extends Agent {
    private boolean isVaccinated = false;
    public AgentBeforeIllness(int coordinateX, int coordinateY, Map partMapOf){
        super(coordinateX, coordinateY, partMapOf);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }
    public boolean getVaccinated(){
        return this.isVaccinated;
    }

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
            SickAgent newAgent = new SickAgent(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newAgent);
            this.getMapPartOf().setHealthyAgents(this.getMapPartOf().getHealthyAgents() - 1);
            this.getMapPartOf().setSickAgents(this.getMapPartOf().getSickAgents() + 1);
            this.getMapPartOf().setChangedObjects(this.getMapPartOf().getChangedObjects() + 1);
        }
    }
    @Override
    public void searching(){
        ObjectOfMap foundObject = this.checkIfNeighbor(this.getMapPartOf(), VaccineKit.class);
        if(foundObject != null){
            VaccineKit foundKit = (VaccineKit) foundObject;
            if(foundKit.getNumberOfVaccineInside() != 0) {
                this.setVaccinated(true);
                this.changingStatusOfAgent();
                foundKit.setNumberOfVaccineInside(foundKit.getNumberOfVaccineInside()-1);
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
