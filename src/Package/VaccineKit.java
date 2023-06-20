package Package;

import Map.Map;

/**
 * Klasa pakietu szczepionek
 */
public class VaccineKit extends Package {
    /**
     * Konstruktor klasy <code>VaccineKit</code>
     * @param coordinateX współrzędna X pakietu szczepionek
     * @param coordinateY współrzędna Y pakietu szczepionek
     * @param mapPartOf mapa na której znajduje się pakiet szczepionek
     */
    public VaccineKit(int coordinateX,int coordinateY, Map mapPartOf) {
        super(coordinateX, coordinateY, mapPartOf);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }

    /**
     * Wywołuje akcje obiektu. Jeżeli pakiet szczepionek jest pusty, jego miejsce zastępuje <code>EmptyField</code>.
     */
    public void responseForCallingOfActionOfObject() {
        if (this.getMapPartOf().getDataOfSimulation().getNumberOfVaccineInKit() == 0) {
            this.setEmpty();
            this.getMapPartOf().getDataOfSimulation().setNumberOfVaccineKit(this.getMapPartOf().getDataOfSimulation().getNumberOfVaccineKit() - 1);
            this.getMapPartOf().setChangedObjects(this.getMapPartOf().getChangedObjects() + 1);
        }
    }

    /**
     * Reprezentacja pakietu szczepionki w konsoli
     * @return litera odpowiadająca pakietowi szczepionki (K)
     */
    @Override
    public String toString() {
        return "K";
    }
    
}
