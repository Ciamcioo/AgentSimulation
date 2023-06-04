package AgendClasses;
import Core.ObjectOfMap;
import Map.Map;
import Package.VaccineKit;

public class AgentBeforeIllness extends Agent {
    private boolean isVaccinated = false;
    public AgentBeforeIllness(int coordinateX, int coordinateY, Map partMapOf){
        super(coordinateX, coordinateY, partMapOf);

    }
    public boolean getVaccinated(){ // TODO dopisać test dla tej metody
        return this.isVaccinated;
    }

    public void setVaccinated(boolean isVaccinated){
        this.isVaccinated = isVaccinated;
    }
    @Override
    public void chengingStatusOfAgent() {
        if(isVaccinated){
            VaccinatedAgent newAgent = new VaccinatedAgent(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newAgent);
        }
        else{
            SickAgent newAgent = new SickAgent(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf(), 40, 0.4);
            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newAgent);
        }
    }
    @Override
    public void searching(){    // TODO dopisać test dla tej metody
        ObjectOfMap foundObject = this.checkIfNeighbor(this.getMapPartOf(), VaccineKit.class);
        if(foundObject != null){
            VaccineKit foundKit = (VaccineKit) foundObject;
            if(foundKit.getNumberOfVaccineInside() != 0) {
                this.setVaccinated(true);
                this.chengingStatusOfAgent();
                foundKit.setNumberOfVaccineInside(foundKit.getNumberOfVaccineInside()-1);
            }
        }
    }
    @Override
    public String toString(){  // Reprezentacja agenta w konsoli
        return "B";
    }
}
