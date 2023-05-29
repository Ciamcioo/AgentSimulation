package Package;

import Map.Map;

public class VaccineKit extends Package{
    private int numberOfVaccineInside;
    public VaccineKit(int coordinateX,int coordinateY, Map mapPartOf, double chanceOfSpawn, int numberOfVaccineInside){
        super(coordinateX, coordinateY, mapPartOf, chanceOfSpawn);
        this.numberOfVaccineInside = numberOfVaccineInside;
    }
    @Override
    public String toString(){
        return "K";
    }
    
}
