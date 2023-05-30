package AgendClasses;
import Map.Map;
import Package.VaccineKit;
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
    public void checkingForVaccine(){         // Metoda poszukująca szczepionki w okolicy
        if(this.checkIfNeighbor(this.getMapPartOf(), VaccineKit.class)){
            // TODO dopisać jakieś zwracanie pozycji tego obiektu, którego będziemy poszukiwać
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
