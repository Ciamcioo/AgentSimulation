package Package;

import Map.Map;

public class VaccineKit extends Package{
    // Konstruktor klasy VaccineKit
    public VaccineKit(int coordinateX,int coordinateY, Map mapPartOf){
        super(coordinateX, coordinateY, mapPartOf);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }
    public void responseForCallingOfActionOfObject(){
        if(this.getMapPartOf().getDataOfSimulation().getNumberOfVaccineInKit() == 0) {
            this.setEmpty();
            this.getMapPartOf().getDataOfSimulation().setNumberOfVaccineKit(this.getMapPartOf().getDataOfSimulation().getNumberOfVaccineKit()-1);
            this.getMapPartOf().setChangedObjects(this.getMapPartOf().getChangedObjects() + 1);
        }
    }
    @Override
    public String toString(){ // Reprezentacja VaccinKit w konsoli
        return "K";
    }
    
}
