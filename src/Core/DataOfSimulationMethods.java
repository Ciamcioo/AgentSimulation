package Core;

import Map.Map;

public interface DataOfSimulationMethods {
    int getSize();
    void setSize(int size);
    int getNumberOfIterations();
    void setNumberOfIterations(int numberOfIterations);
    int getNumberOfHealthyAgents();
    void setNumberOfHealthyAgents(int numberOfHealthyAgents);
    int getNumberOfSickAgents();
    void setNumberOfSickAgents(int numberOfSickAgents);
    int getNumberOfVaccineKit();
    void setNumberOfVaccineKit(int numberOfVaccineKit);
    double getChanceOfSpawnVaccine();
    void setChanceOfSpawnVaccine(double chanceOfSpawnVaccine);
    int getNumberOfIsolation();
    void setNumberOfIsolation(int numberOfIsolation);
    double getChanceOfSpawnIsolation();
    void setChanceOfSpawnIsolation(double chanceOfSpawnIsolation);
    void updateData(Map map);
    void displayData(Map map);

}
