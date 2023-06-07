package Package;

import Map.Map;

public class VaccineKit extends Package{
    private int numberOfVaccineInside;
    public VaccineKit(Map mapPartOf, double chanceOfSpawn,int numberOfVaccineInside){
        super(mapPartOf, chanceOfSpawn);
        this.setNumberOfVaccineInside(numberOfVaccineInside);

    }
    public VaccineKit(int coordinateX,int coordinateY, Map mapPartOf, double chanceOfSpawn, int numberOfVaccineInside){ // Konstruktor klasy VaccineKit, który wywołuje konstruktor klasy Package
        super(coordinateX, coordinateY, mapPartOf, chanceOfSpawn);
        this.numberOfVaccineInside = numberOfVaccineInside;
        this.getMapPartOf().setOneObjectOfMap(this.getCoordinateX(), this.getCoordinateY(), this);
    }
    public int getNumberOfVaccineInside(){
        return this.numberOfVaccineInside;
    }
    public void setNumberOfVaccineInside(int newNumberOfVaccineInside){
        if(newNumberOfVaccineInside >= 0 && newNumberOfVaccineInside < 4)
            this.numberOfVaccineInside = newNumberOfVaccineInside;
        else
            this.numberOfVaccineInside = -5;
    }
    public void responseForCallingOfActionOfObject(){
        // TODO napisać dla obiektu typu VaccineKit odpowiednie metody wywoływane w czasie jednej iteracji na obiekcie respown -> otczekanie do końca iteracji -> zniszczenie obiektu
        // TODO napisać dla tej metody testy jednostkowe
    }
    @Override
    public String toString(){ // Reprezentacja VaccinKit w konsoli
        return "K";
    }
    
}
