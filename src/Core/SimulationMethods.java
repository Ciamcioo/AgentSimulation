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
         // TODO Dopisanie testu dla tej metody

        return Simulation.size;
    }
    static void setSize(int size){
        // TODO Dopisanie testu dla tej metody
        if(size > 0)
            Simulation.size = size;
    }
     static int getNumberOfIterations(){
         // TODO Dopisanie testu dla tej metody
        return Simulation.numberOfIterations;
    }

    static void setNumberOfIterations(int numberOfIterations){
        // TODO Dopisanie testu dla tej metody
        if(numberOfIterations > 0)
            Simulation.numberOfIterations = numberOfIterations;
    }
    static int getNumberOfHealthyAgents(){
        // TODO Dopisanie testu dla tej metody
        return Simulation.numberOfHealthyAgents;
    }
    static void setNumberOfHealthyAgents(int numberOfHealthyAgents){
        // TODO Dopisanie testu dla tej metody
        if(numberOfHealthyAgents > 0);
            Simulation.numberOfHealthyAgents = numberOfHealthyAgents;
    }
    static int getNumberOfSickAgents(){
        return Simulation.numberOfSickAgents;
    }
    static void setNumberOfSickAgents(int numberOfSickAgents){
        // TODO Dopisanie testu dla tej metody
        if(numberOfSickAgents > 0)
            Simulation.numberOfSickAgents = numberOfSickAgents;
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
        }
        catch (IOException e) {
            throw new RuntimeException("Something went wrong. Application is closing.", e);
        }
    }
    static void agentControlMethod(Map map){
         //TODO Dopsisanie testu dla tej metody
         for(int i = 0; i < map.getSize(); i++){
             for(int j = 0; j < map.getSize(); j++){
                 map.getOneObjectOfMap(j,i).responseForCallingOfActionOfObject();
             }
         }
    }
    static void respawnOfPackages(Map map){

        //TODO Napisanie metody wywołujące respown pakietu
        //TODO Napisanie testu jednostkowego do teog
    }
    static void packageDestructionAndSettingMovedToFalse(Map map){
        for (int i = 0; i < map.getSize(); i++){
            for (int j =0; j < map.getSize(); j++){
                if (map.getOneObjectOfMap(j,i) instanceof Agent)
                    ((Agent) map.getOneObjectOfMap(j,i)).setIterationMove(false);
                else if(map.getOneObjectOfMap(j,i) instanceof Package)
                    ((Package) map.getOneObjectOfMap(j,i)).destructionOfPackage();
            }
        }
    }
    //TODO Napisanie do tego testu jednostkowego
}
