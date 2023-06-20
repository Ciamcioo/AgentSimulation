package AgentClasses;
import Map.Map;
import Map.EmptyField;

import java.util.Random;

/**
 * Klasa chorego agenta
 */
public class SickAgent extends Agent {
    private int  dayTillEndOfIllness;

    /**
     * Konstruktor klasy SickAgent
     * @param coordinateX współrzędna X
     * @param coordinateY współrzędna Y
     * @param partMapOf mapa na której znajduje się agent
     * @param minDayTillEndOfIllness minimalna długość choroby
     * @param maxDayTillEndOfIllness maksymalna długość choroby
     */
    public SickAgent(int coordinateX, int coordinateY, Map partMapOf,int minDayTillEndOfIllness, int maxDayTillEndOfIllness) {
        super(coordinateX, coordinateY, partMapOf);
        this.setDayTillEndOfIllness(new Random().nextInt(maxDayTillEndOfIllness - minDayTillEndOfIllness) + minDayTillEndOfIllness);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }

    /**
     * Zwraca wartość int, która określa ilość dni obiektu zanim zakończy się jego choroba
     * @return ilość dni do końca choroby
     */
    public int getDayTillEndOfIllness() {
        return this.dayTillEndOfIllness;
    }

    /**
     * Przypisuje wartość int odpowiadająca ilości dni jaka musi upłynąć by obiekty wyzdrowiał
     * @param dayTillEndOfIllness ilość dni do końca choroby
     */
    public void setDayTillEndOfIllness(int dayTillEndOfIllness) {
        if (dayTillEndOfIllness >= 0)
            this.dayTillEndOfIllness = dayTillEndOfIllness ;
    }

    /**
     * Zmienia status agenta. Jeżeli ilość dni do końca choroby jest równa zero, tworzy nowego agenta <code>AgentAfterIllness</code>.
     * W innym przypadku tworzy nowe puste pole <code>EmptyField</code>.
     */
    @Override
    public void changingStatusOfAgent() {
        if (this.dayTillEndOfIllness == 0) {
            new AgentAfterIllness(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
            this.getMapPartOf().getDataOfSimulation().setNumberOfAfterIllness(this.getMapPartOf().getDataOfSimulation().getNumberOfAfterIllness()+1);
        }
        else {
            EmptyField newField = new EmptyField(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
            this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), newField);
        }
        this.getMapPartOf().getDataOfSimulation().setNumberOfSickAgents(this.getMapPartOf().getDataOfSimulation().getNumberOfSickAgents() - 1);
        this.getMapPartOf().setChangedObjects(this.getMapPartOf().getChangedObjects() + 1);
    }

    /**
     * Szuka agenta <code>AgentBeforeIllness</code>; jeżeli znajdzie zmienia jego status ({@link AgentBeforeIllness#changingStatusOfAgent()})
     */
    @Override
    public void searching() {
        AgentBeforeIllness foundObject = (AgentBeforeIllness) this.checkIfNeighbor(this.getMapPartOf(), AgentBeforeIllness.class);
        if (foundObject != null)
            foundObject.changingStatusOfAgent();
    }

    /**
     * Wywołuje akcje obiektu:
     * Porusza obiekt ({@link AgentBeforeIllness#move()}) i przeszukuje pola wokół ({@link AgentBeforeIllness#searching()}).
     * Zmniejsza o 1 dni do końca choroby.
     * Zmienia status agenta jeżeli zostało 0 dni do końca choroby lub zmienia status w zależności od szansy na śmierć.
     */
    public void responseForCallingOfActionOfObject() {
        this.move();
        this.searching();
        this.setDayTillEndOfIllness(this.getDayTillEndOfIllness() - 1);
        if (this.getDayTillEndOfIllness() == 0)
            this.changingStatusOfAgent();
        else if (this.getMapPartOf().getDataOfSimulation().getChanceOfSickAgentDeath() >= new Random().nextDouble(1))
            this.changingStatusOfAgent();
    }

    /**
     * Reprezentacja agenta w konsoli
     * @return litera odpowiadająca agentowi choremu (S)
     */
    @Override
    public String toString() {
        return "S";
    }
}