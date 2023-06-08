package Core;

import AgentClasses.Agent;
import Map.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Package.Package;
import Map.EmptyField;
public interface SimulationMethods {
     static int getSize(){
        return Simulation.size;
    }
    static void setSize(int size){
        if(size > 0)
            Simulation.size = size;
        else
            Simulation.size = 0;
    }
     static int getNumberOfIterations(){
        return Simulation.numberOfIterations;
    }
    static void setNumberOfIterations(int numberOfIterations){
        if(numberOfIterations > 0)
            Simulation.numberOfIterations = numberOfIterations;
        else
            Simulation.numberOfIterations = 0;
    }
    static int getNumberOfHealthyAgents(){
        return Simulation.numberOfHealthyAgents;
    }
    static void setNumberOfHealthyAgents(int numberOfHealthyAgents){
        if(numberOfHealthyAgents > 0)
            Simulation.numberOfHealthyAgents = numberOfHealthyAgents;
        else
            Simulation.numberOfHealthyAgents = 0;
    }
    static int getNumberOfSickAgents(){
        return Simulation.numberOfSickAgents;
    }
    static void setNumberOfSickAgents(int numberOfSickAgents){
        if(numberOfSickAgents > 0)
            Simulation.numberOfSickAgents = numberOfSickAgents;
        else
            Simulation.numberOfSickAgents = 0;
    }
    static int getNumberOfVaccineKit(){
         return Simulation.numberOfVaccineKits;
    }
    static void setNumberOfVaccineKit(int numberOfVaccineKit){
         if(numberOfVaccineKit >=0 && numberOfVaccineKit <= Math.floor(getNumberOfHealthyAgents()/4.))
             Simulation.numberOfVaccineKits = numberOfVaccineKit;
         else
             Simulation.numberOfVaccineKits = 0;
     }
    static int getNumberOfIsolation(){
         return Simulation.numberOfIsolation;
    }
    static void setNumberOfIsolation(int numberOfIsolation){
         if(numberOfIsolation >= 0 && numberOfIsolation <= Math.floor(getNumberOfSickAgents()/2.))
             Simulation.numberOfIsolation = numberOfIsolation;
         else
             Simulation.numberOfIsolation = 0;
    }
    static void enteringDateForSimulation(){
         // TODO Dopisanie testu dla tej metody
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Wprowadz liczbe iteracji systemu: ");
            SimulationMethods.setNumberOfIterations(Integer.parseInt(reader.readLine()));
            System.out.println("---------------------------------------------------");
            System.out.print("Wprowadz wielkosc mapy: ");
            SimulationMethods.setSize(Integer.parseInt(reader.readLine()));
            System.out.print("Wprowadz liczbe zdrowych agentow na poczatku symulacji: ");
            SimulationMethods.setNumberOfHealthyAgents(Integer.parseInt(reader.readLine()));
            System.out.print("Wprowadz liczbe chorych agentow na poczatku symulacji: ");
            SimulationMethods.setNumberOfSickAgents(Integer.parseInt(reader.readLine()));
            System.out.println("Wprowadz liczbe pakietow szczepionki, ktore moga pojawic sie w czasie iteracji");
        }
        catch (IOException e) {
            throw new RuntimeException("Something went wrong. Application is closing.", e);
        }
    }
    static void agentControlMethod(Map map){
         //TODO Dopsisanie testu dla tej metody
         for(int i = 0; i < map.getSize(); i++){
             for(int j = 0; j < map.getSize(); j++){
                 if(map.getOneObjectOfMap(j,i) instanceof Agent)
                    map.getOneObjectOfMap(j,i).responseForCallingOfActionOfObject();
             }
         }
    }
}
