package Core;

import Map.Map;
import Map.ObjectOfMap;
import Package.VaccineKit;
import Package.Isolation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Klasa danych symulacji
 */
public class DataOfSimulation implements DataOfSimulationMethods {
    private Integer size = 0, numberOfIterations = 0, numberOfHealthyAgents = 0,numberOfSickAgents = 0, numberOfVaccineKits = 0, numberOfVaccineInKit = 0, numberOfIsolation = 0, minDayTillEndOfIllness = 0, maxDayTillEndOfIllness = 0, numberOfVaccinated = 0, numberOfAfterIllness = 0, numOfVaccineKits = 0, numOfIsolation = 0;
    private Double chanceOfSpawnVaccine = 0., chanceOfSpawnIsolation = 0., chanceOfSickAgentDeath = 0.;

    /**
     * #1 Konstruktor klasy DataOfSimulation
     * @param numberOfIterations liczba iteracji symulacji
     * @param sizeOfMap rozmiar mapy
     * @param numberOfHealthyAgents liczba zdrowych
     * @param numberOfSickAgents liczba chorych
     * @param minDayTillEndOfIllness minimum dni choroby
     * @param maxDayTillEndOfIllness maximum dni choroby
     * @param chanceOfSickAgentDeath szansa na śmierć chorego
     * @param numberOfVaccineKits liczba pakietów szczepionek
     * @param numberOfVaccineInKit liczba szczepionek w pakiecie szczepionek
     * @param chanceOfSpawnVaccine szansa na pojawienie się szczepionek
     * @param numberOfIsolation liczba izolacji
     * @param chanceOfSpawnIsolation szansa na pojawienie się izolacji
     */
    public DataOfSimulation(int numberOfIterations, int sizeOfMap, int numberOfHealthyAgents, int numberOfSickAgents, int minDayTillEndOfIllness, int maxDayTillEndOfIllness, double chanceOfSickAgentDeath, int numberOfVaccineKits, int numberOfVaccineInKit, double chanceOfSpawnVaccine, int numberOfIsolation, double chanceOfSpawnIsolation) {
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

    /**
     * #2 Konstruktor klasy DataOfSimulation
     */
    public DataOfSimulation() {
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

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        if (size > 0)
            this.size = size;
        else
            this.size = 0;
    }

    public int getNumberOfIterations() {
        return this.numberOfIterations;
    }

    public void setNumberOfIterations(int numberOfIterations) {
        if (numberOfIterations >= 0)
            this.numberOfIterations = numberOfIterations;
        else
            this.numberOfIterations = 0;
    }

    public int getNumberOfVaccinated() { return numberOfVaccinated; }

    public void setNumberOfVaccinated(int numberOfVaccinated) {
        if (numberOfVaccinated > 0)
            this.numberOfVaccinated = numberOfVaccinated;
        else
            this.numberOfVaccinated = 0;
    }

    public int getNumberOfAfterIllness() { return numberOfAfterIllness; }

    public void setNumberOfAfterIllness(int numberOfAfterIllness) {
        if (numberOfAfterIllness > 0)
            this.numberOfAfterIllness = numberOfAfterIllness;
        else
            this.numberOfAfterIllness = 0;
    }

    public int getNumberOfHealthyAgents() {
        return this.numberOfHealthyAgents;
    }

    public void setNumberOfHealthyAgents(int numberOfHealthyAgents) {
        if (numberOfHealthyAgents > 0)
            this.numberOfHealthyAgents = numberOfHealthyAgents;
        else
            this.numberOfHealthyAgents = 0;
    }

    public int getNumberOfSickAgents() {
        return this.numberOfSickAgents;
    }

    public void setNumberOfSickAgents(int numberOfSickAgents) {
        if (numberOfSickAgents > 0)
            this.numberOfSickAgents = numberOfSickAgents;
        else
            this.numberOfSickAgents = 0;
    }

    public int getMinDayTillEndOfIllness() {
        return this.minDayTillEndOfIllness;
    }

    public void setMinDayTillEndOfIllness(int minDayTillEndOfIllness) {
        if (minDayTillEndOfIllness > 0)
            this.minDayTillEndOfIllness = minDayTillEndOfIllness;
        else
            this.minDayTillEndOfIllness = 1;
    }

    public int getMaxDayTillEndOfIllness() {
        return this.maxDayTillEndOfIllness;
    }

    public void setMaxDayTillEndOfIllness(int maxDayTillEndOfIllness) {
        if (maxDayTillEndOfIllness > 0)
          this.maxDayTillEndOfIllness = maxDayTillEndOfIllness;
        else
          this.maxDayTillEndOfIllness = 1;
    }

    public double getChanceOfSickAgentDeath() {
        return this.chanceOfSickAgentDeath;
    }

    public void setChanceOfSickAgentDeath(double chanceOfSickAgentDeath) {
        if (chanceOfSickAgentDeath > 0.0 && chanceOfSickAgentDeath < 1.0)
            this.chanceOfSickAgentDeath = chanceOfSickAgentDeath;
        else
            this.chanceOfSickAgentDeath = 0.0;
    }

    public int getNumberOfVaccineKit() {
        return this.numberOfVaccineKits;
    }

    public void setNumberOfVaccineKit(int numberOfVaccineKit) {
        if (numberOfVaccineKit >=0 && numberOfVaccineKit <= Math.floor(getNumberOfHealthyAgents()/4.))
            this.numberOfVaccineKits = numberOfVaccineKit;
        else
            this.numberOfVaccineKits = 0;
    }

    public double getChanceOfSpawnVaccine() {
        return this.chanceOfSpawnVaccine;
    }

    public void setChanceOfSpawnVaccine(double chanceOfSpawnVaccine) {
        if (chanceOfSpawnVaccine >= 0. && chanceOfSpawnVaccine <= 1.)
            this.chanceOfSpawnVaccine = chanceOfSpawnVaccine;
        else
            this.chanceOfSpawnVaccine = 0.;
    }

    public int getNumberOfVaccineInKit() {
        return this.numberOfVaccineInKit;
    }

    public void setNumberOfVaccineInKit(int vaccineInKit) {
        if (vaccineInKit >= 0 && vaccineInKit <= 5)
            this.numberOfVaccineInKit = vaccineInKit;
        else
            this.numberOfVaccineInKit = 0;
    }

    public int getNumberOfIsolation() {
        return this.numberOfIsolation;
    }

    public void setNumberOfIsolation(int numberOfIsolation) {
        if (numberOfIsolation >= 0 && numberOfIsolation <= Math.floor(getNumberOfSickAgents()/4.))
            this.numberOfIsolation = numberOfIsolation;
        else
            this.numberOfIsolation = 0;
    }

    public double getChanceOfSpawnIsolation() {
        return this.chanceOfSpawnIsolation;
    }

    public void setChanceOfSpawnIsolation(double chanceOfSpawnIsolation) {
        if (chanceOfSpawnIsolation >=0. && chanceOfSpawnIsolation <= 1.)
            this.chanceOfSpawnIsolation = chanceOfSpawnIsolation;
        else
            this.chanceOfSpawnIsolation = 0.;
    }

    public void updateData(Map map) {
        this.numberOfHealthyAgents = map.getDataOfSimulation().getNumberOfHealthyAgents();
        this.numberOfSickAgents = map.getDataOfSimulation().getNumberOfSickAgents();
        this.numberOfVaccinated = map.getDataOfSimulation().getNumberOfVaccinated();
        this.numberOfAfterIllness = map.getDataOfSimulation().getNumberOfAfterIllness();

        ObjectOfMap[][] array = map.getArrayOfObjects();
        for (int i = 0; i < map.getDataOfSimulation().getSize(); i++) {
            for (int j = 0; j < map.getDataOfSimulation().getSize(); j++) {
                if (array[j][i].getClass() == VaccineKit.class) { numOfVaccineKits++; }
                if (array[j][i].getClass() == Isolation.class) { numOfIsolation++; }
            }
        }
    }

    public void displayData(Map map) {
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("Agenci zdrowi: " + this.numberOfHealthyAgents);
        System.out.println("Agenci chorzy: " + this.numberOfSickAgents);
        System.out.println("Agenci zaszczepieni: " + this.numberOfVaccinated);
        System.out.println("Agentci po chorobie: " + this.numberOfAfterIllness);
        System.out.println("Liczba pakietów szczepionki dostępna: " + this.numOfVaccineKits);
        System.out.println("Liczba pakietów izolacji dostępna: " + this.numOfIsolation);
        System.out.println("Wolne pola na mapie: " +  (map.getDataOfSimulation().getSize() * map.getDataOfSimulation().getSize() - numberOfSickAgents - numberOfHealthyAgents - numberOfVaccinated - numberOfAfterIllness - numOfVaccineKits - numOfIsolation));
        System.out.println("Liczba zmienionych obiektów w tej iteracji: " + map.getChangedObjects());
        System.out.println("---------------------------------------------");
        System.out.println();
        map.setChangedObjects(0);
        numOfVaccineKits = 0;
        numOfIsolation = 0;
    }
}
