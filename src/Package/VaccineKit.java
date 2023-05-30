package Package;

import Map.Map;

public class VaccineKit extends Package{
    private int numberOfVaccineInside;
    public VaccineKit(int coordinateX,int coordinateY, Map mapPartOf, double chanceOfSpawn, int numberOfVaccineInside){ // Konstruktor klasy VaccineKit, który wywołuje konstruktor klasy Package
        super(coordinateX, coordinateY, mapPartOf, chanceOfSpawn);
        this.numberOfVaccineInside = numberOfVaccineInside;
    }
    @Override
    public String toString(){ // Reprezentacja VaccinKit w konsoli
        return "K";
    }
    
}
