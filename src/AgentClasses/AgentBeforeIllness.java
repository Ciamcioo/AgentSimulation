package AgentClasses;
import Map.Map;
import Package.VaccineKit;

/**
 * Klasa przed chorobą
 */
public class AgentBeforeIllness extends Agent {
    private boolean isVaccinated = false;
    /**
     * Konstruktor klasy AgentBeforeIllness
     * @param coordinateX współrzędna X
     * @param coordinateY współrzędna Y
     * @param partMapOf mapa na której znajduje się agent
     */
    public AgentBeforeIllness(int coordinateX, int coordinateY, Map partMapOf){
        super(coordinateX, coordinateY, partMapOf);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }

    /**
     * Zwraca wartość boolean odpowiadającą informacji czy obiektu typu AgentBeforeIllness jest zaszczepiony
     * @return <code>true</code> jeżeli zaszczepiony
     */
    public boolean getVaccinated(){
        return this.isVaccinated;
    }

    /**
     * Przypisuje wartość boolean przekazaną w argumencie, czy obiekt jest zaszczepiony
     * @param isVaccinated informacja czy obiekt jest zaszczepiony
     */
    public void setVaccinated(boolean isVaccinated){
        this.isVaccinated = isVaccinated;
    }

    /**
     * Zmienia status agenta. Jeżeli zaszczepiony, tworzy nowego agenta <code>VaccinatedAgent</code>. Jeżeli niezaszczepiony, tworzy <code>SickAgent</code>.
     */
    @Override
    public void changingStatusOfAgent() {
        if(isVaccinated){
            new VaccinatedAgent(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
            this.getMapPartOf().getDataOfSimulation().setNumberOfHealthyAgents(this.getMapPartOf().getDataOfSimulation().getNumberOfHealthyAgents() - 1);
            this.getMapPartOf().getDataOfSimulation().setNumberOfVaccinated(this.getMapPartOf().getDataOfSimulation().getNumberOfVaccinated()+1);
            this.getMapPartOf().setChangedObjects(this.getMapPartOf().getChangedObjects() + 1);
        }
        else{
            new SickAgent(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf(), this.getMapPartOf().getDataOfSimulation().getMinDayTillEndOfIllness(), this.getMapPartOf().getDataOfSimulation().getMaxDayTillEndOfIllness());
            this.getMapPartOf().getDataOfSimulation().setNumberOfHealthyAgents(this.getMapPartOf().getDataOfSimulation().getNumberOfHealthyAgents() - 1);
            this.getMapPartOf().getDataOfSimulation().setNumberOfSickAgents(this.getMapPartOf().getDataOfSimulation().getNumberOfSickAgents() + 1);
            this.getMapPartOf().setChangedObjects(this.getMapPartOf().getChangedObjects() + 1);
        }
    }

    /**
     * Szuka pakietu szczepionki <code>VaccineKit</code> metodą {@link Agent#checkIfNeighbor(Map, Class)}. Jeżeli znajdzie, zmienia status agenta na zaszczepiony
     * ({@link AgentBeforeIllness#setVaccinated(boolean)}, {@link AgentBeforeIllness#changingStatusOfAgent()}) i zmniejsza ilość szczepionek w pakiecie szczepionki.
     */
    @Override
    public void searching(){
        VaccineKit foundObject = (VaccineKit) this.checkIfNeighbor(this.getMapPartOf(), VaccineKit.class);
        if(foundObject != null){
            if(foundObject.getMapPartOf().getDataOfSimulation().getNumberOfVaccineInKit() != 0) {
                this.setVaccinated(true);
                this.changingStatusOfAgent();
                foundObject.getMapPartOf().getDataOfSimulation().setNumberOfVaccineInKit(foundObject.getMapPartOf().getDataOfSimulation().getNumberOfVaccineInKit()-1);
                if(foundObject.getMapPartOf().getDataOfSimulation().getNumberOfVaccineInKit() == 0)
                    foundObject.setEmpty();
            }
        }
    }

    /**
     * Wywołuje akcje obiektu. Porusza obiekt ({@link AgentBeforeIllness#move()}) i przeszukuje pola wokół ({@link AgentBeforeIllness#searching()})
     */
    @Override
    public void responseForCallingOfActionOfObject(){
        this.move();
        this.searching();
    }

    /**
     * Reprezentacja agenta w konsoli
     * @return litera odpowiadająca agentowi przed chorobą (B)
     */
    @Override
    public String toString(){
        return "B";
    }
}
