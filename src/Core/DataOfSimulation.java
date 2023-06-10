package Core;

import Map.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataOfSimulation implements DataOfSimulationMethods {
    private  Integer size = 0, numberOfIterations = 0, numberOfHealthyAgents = 0,numberOfSickAgents = 0, numberOfVaccineKits = 0, numberOfVaccineInKit = 0, numberOfIsolation = 0, minDayTillEndOfIllness = 0, maxDayTillEndOfIllness = 0;
    private  Double chanceOfSpawnVaccine = 0., chanceOfSpawnIsolation = 0., chanceOfSickAgentDeath = 0.;
    // #1 Konstruktor klasy DataOfSimulation
    public DataOfSimulation(int numberOfIterations, int sizeOfMap, int numberOfHealthyAgents, int numberOfSickAgents, int minDayTillEndOfIllness, int maxDayTillEndOfIllness, double chanceOfSickAgentDeath, int numberOfVaccineKits, int numberOfVaccineInKit, double chanceOfSpawnVaccine, int numberOfIsolation, double chanceOfSpawnIsolation ){
        this.setNumberOfIterations(numberOfIterations);
        this.setSize(sizeOfMap);
        this.setNumberOfHealthyAgents(numberOfHealthyAgents);
        this.setNumberOfSickAgents(numberOfSickAgents);
        this.setMinDayTillEndOfIllness(minDayTillEndOfIllness);
        this.setMaxDayTillEndOfIllness(maxDayTillEndOfIllness);
        this.setChanceOfSickAgentDeath(chanceOfSickAgentDeath);
        this.setNumberOfVaccineKit(numberOfVaccineKits);
        this.setNumberOfVaccineInKit(numberOfVaccineInKit);
        this.setChanceOfSpawnVaccine(chanceOfSpawnVaccine);
        this.setNumberOfIsolation(numberOfIsolation);
        this.setChanceOfSpawnIsolation(chanceOfSpawnIsolation);

    }
    // #2 Konstruktor klasy DataOfSimulation
    public DataOfSimulation(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Wprowadz liczbe iteracji systemu: ");
            this.setNumberOfIterations(Integer.parseInt(reader.readLine()));
            System.out.println("---------------------------------------------------");
            System.out.print("Wprowadz wielkosc mapy: ");
            this.setSize(Integer.parseInt(reader.readLine()));
            System.out.print("Wprowadz liczbe zdrowych agentow na poczatku symulacji: ");
            this.setNumberOfHealthyAgents(Integer.parseInt(reader.readLine()));
            System.out.print("Wprowadz liczbe chorych agentow na poczatku symulacji: ");
            this.setNumberOfSickAgents(Integer.parseInt(reader.readLine()));
            System.out.print("Wprowadz liczbe dni jaka minimalnie musi upłynąć by agent chory agent wyzdrowiał: ");
            this.setMinDayTillEndOfIllness(Integer.parseInt(reader.readLine()));
            System.out.print("Wprowadz liczbe dni jaka maksymalnie musi upłynąć by agent wyzdrowiał: ");
            this.setMaxDayTillEndOfIllness(Integer.parseInt(reader.readLine()));
            System.out.print("Wprowadz wartość z przedziału 0.0 - 1.0, która będzie reprezentować szanse śmierci agenta: ");
            this.setChanceOfSickAgentDeath(Double.parseDouble(reader.readLine()));
            System.out.print("Wprowadz liczbe pakietow szczepionki, ktore moga pojawic sie w czasie iteracji: ");
            this.setNumberOfVaccineKit(Integer.parseInt(reader.readLine()));
            System.out.print("Wprowadz liczbe pakietow szczepionki w jednym pakiecie (maksymalna wartosc to 5): ");
            this.setNumberOfVaccineInKit(Integer.parseInt(reader.readLine()));
            System.out.print("Wprowadz wartosc z przedzialu 0.0 - 1.0, ktora bedzie odpowiadać szansie procentowej pojawienia sie szczepionki: ");
            this.setChanceOfSpawnVaccine(Double.parseDouble(reader.readLine()));
            System.out.print("Wprowadz liczbe pakietow izolacji, ktore moga pojawic sie w czasie iteracji: ");
            this.setNumberOfIsolation(Integer.parseInt(reader.readLine()));
            System.out.print("Wprowadz wartosc z przedzialu 0.0 - 1.0, ktora bedzie odpowiadać szansie procentowej pojawienia sie izolacji: ");
            this.setChanceOfSpawnIsolation(Double.parseDouble(reader.readLine()));
        }
        catch (IOException e) {
            throw new RuntimeException("Something went wrong. Application is closing.", e);
        }
    }

    public int getSize(){
        return this.size;
    }

    public void setSize(int size){
        if(size > 0)
            this.size = size;
        else
            this.size = 0;
    }

    public int getNumberOfIterations(){
        return this.numberOfIterations;
    }
    public void setNumberOfIterations(int numberOfIterations){
        if(numberOfIterations >= 0)
            this.numberOfIterations = numberOfIterations;
        else
            this.numberOfIterations = 0;
    }
    public int getNumberOfHealthyAgents(){
        return this.numberOfHealthyAgents;
    }
    public void setNumberOfHealthyAgents(int numberOfHealthyAgents){
        if(numberOfHealthyAgents > 0)
            this.numberOfHealthyAgents = numberOfHealthyAgents;
        else
            this.numberOfHealthyAgents = 0;
    }
    public int getNumberOfSickAgents(){
        return this.numberOfSickAgents;
    }
    public void setNumberOfSickAgents(int numberOfSickAgents){
        if(numberOfSickAgents > 0)
            this.numberOfSickAgents = numberOfSickAgents;
        else
            this.numberOfSickAgents = 0;
    }
    //TODO test jednostkowy
    public int getMinDayTillEndOfIllness(){
        return this.minDayTillEndOfIllness;
    }
    // TODO test jednostkowy
    public void setMinDayTillEndOfIllness(int minDayTillEndOfIllness){
        if(minDayTillEndOfIllness > 0)
            this.minDayTillEndOfIllness = minDayTillEndOfIllness;
    }
    // TODO testy jednostkowe
    public int getMaxDayTillEndOfIllness(){
        return this.maxDayTillEndOfIllness;
    }
    // TODO testy jednostkowe
    public void setMaxDayTillEndOfIllness(int maxDayTillEndOfIllness){
        if(maxDayTillEndOfIllness > 0)
          this.maxDayTillEndOfIllness = maxDayTillEndOfIllness;
    }
    // TODO testy jednostkowe
    public double getChanceOfSickAgentDeath(){
        return this.chanceOfSickAgentDeath;
    }
    // TODO testy jednostkowe
    public void setChanceOfSickAgentDeath(double chanceOfSickAgentDeath){
        if(chanceOfSickAgentDeath > 0.0 && chanceOfSickAgentDeath < 1.0)
            this.chanceOfSickAgentDeath = chanceOfSickAgentDeath;
    }
    public int getNumberOfVaccineKit(){
        return this.numberOfVaccineKits;
    }
    public void setNumberOfVaccineKit(int numberOfVaccineKit){
        if(numberOfVaccineKit >=0 && numberOfVaccineKit <= Math.floor(getNumberOfHealthyAgents()/4.))
            this.numberOfVaccineKits = numberOfVaccineKit;
        else
            this.numberOfVaccineKits = 0;
    }
    public double getChanceOfSpawnVaccine(){
        return this.chanceOfSpawnVaccine;
    }
    public void setChanceOfSpawnVaccine(double chanceOfSpawnVaccine){
        if(chanceOfSpawnVaccine >= 0. && chanceOfSpawnVaccine <= 1.)
            this.chanceOfSpawnVaccine = chanceOfSpawnVaccine;
        else
            this.chanceOfSpawnVaccine = 0.;
    }
    public int getNumberOfVaccineInKit(){
        return this.numberOfVaccineInKit;
    }
    public void setNumberOfVaccineInKit(int vaccineInKit){
        if (vaccineInKit >= 0 && vaccineInKit <= 5)
            this.numberOfVaccineInKit = vaccineInKit;
        else
            this.numberOfVaccineInKit = 0;
    }
    public int getNumberOfIsolation(){
        return this.numberOfIsolation;
    }
    public void setNumberOfIsolation(int numberOfIsolation){
        if(numberOfIsolation >= 0 && numberOfIsolation <= Math.floor(getNumberOfSickAgents()/4.))
            this.numberOfIsolation = numberOfIsolation;
        else
            this.numberOfIsolation = 0;
    }

    public double getChanceOfSpawnIsolation(){
        return this.chanceOfSpawnIsolation;
    }
    public void setChanceOfSpawnIsolation(double chanceOfSpawnIsolation){
        if(chanceOfSpawnIsolation >=0. && chanceOfSpawnIsolation <= 1.)
            this.chanceOfSpawnIsolation = chanceOfSpawnIsolation;
        else
            this.chanceOfSpawnIsolation = 0.;
    }
    // TODO dopisać test do metody updateData
    public void updateData(Map map) {
        this.numberOfHealthyAgents = map.getDataOfSimulation().getNumberOfHealthyAgents();
        this.numberOfSickAgents = map.getDataOfSimulation().getNumberOfSickAgents();
    }
    // TODO dopisać testy do metody displayData
    public void displayData(Map map) {
        System.out.println("chorzy: " + numberOfSickAgents + " zdrowi: " + numberOfHealthyAgents);
        System.out.println("wolne pola: " + (map.getDataOfSimulation().getSize() * map.getDataOfSimulation().getSize() - numberOfSickAgents - numberOfHealthyAgents));
        System.out.println("zmienone obiekty w rundzie: " + map.getChangedObjects());
        map.setChangedObjects(0);
    }
}
