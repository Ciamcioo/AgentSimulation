package AgendClasses;
import Core.ObjectOfMap;
import Map.Map;
import Package.VaccineKit;

import java.io.Console;
import java.lang.reflect.Constructor;

public class AgentBeforeIllness extends Agent {
    private boolean isVaccinated = false;
    public AgentBeforeIllness(int coordinateX, int coordinateY, Map partMapOf){ //  Konstruktor AgentaBeforeIllness, który wywołuje konstruktor Agent
        super(coordinateX, coordinateY, partMapOf);

    }

    @Override
    public void chengingStatusOfAgent() {
        if(isVaccinated){
            VaccinatedAgent newAgent = new VaccinatedAgent(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
            this.getMapPartOf().swapAgent(this.getCoordinateX(), this.getCoordinateY(), newAgent);
        }
        else{
            SickAgent newAgent = new SickAgent(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf(), 40, 0.4);
            this.getMapPartOf().swapAgent(this.getCoordinateX(), this.getCoordinateY(), newAgent);
        }
    }
    @Override
    public void searching(){
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
    public void setVaccinated(boolean isVaccinated){
        this.isVaccinated = isVaccinated;
    }
}
