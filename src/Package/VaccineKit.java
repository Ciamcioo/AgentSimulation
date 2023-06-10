package Package;

import Map.Map;

public class VaccineKit extends Package{
    private int numberOfVaccineInside;

    // Konstruktor klasy VaccineKit
    public VaccineKit(int coordinateX,int coordinateY, Map mapPartOf){
        super(coordinateX, coordinateY, mapPartOf);
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }
    public void responseForCallingOfActionOfObject(){
        if(this.getMapPartOf().getDataOfSimulation().getNumberOfVaccineInKit() == 0)
            this.setEmpty();
        // TODO napisać dla tej metody testy jednostkowe
    }
    @Override
    public String toString(){ // Reprezentacja VaccinKit w konsoli
        return "K";
    }
    
}
