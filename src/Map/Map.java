package Map;

import Package.Package;
import AgendClasses.Agent;
import AgendClasses.AgentBeforeIllness;
import AgendClasses.SickAgent;
import Core.ObjectOfMap;

import java.util.ArrayList;
import java.util.Random;

public class Map implements MapMethods {

    private ObjectOfMap[][] arrayOfObjects;
    private int healthyAgents;
    private int sickAgents;
    private int size;
    public Map(){

    }

    public Map(int size, int numberOfHealthyAgents, int numberOfSickAgents) { // Konstruktor klasy Map
        this.setSize(size);
        this.arrayOfObjects = this.mapInitialization(size);
        this.setSickAgents(numberOfSickAgents);
        this.setHealthyAgents(numberOfHealthyAgents);
        this.agentInitializationOnMap();
    }
    public int getSize(){
        return this.size;
    }

    public void setSize(int size){
        this.size = size > 0 ? size : -1;
    }
    public int getSickAgents(){
        return this.sickAgents;
    }
    public void setSickAgents(int sickAgents){
        this.sickAgents = sickAgents > 0 ? sickAgents : -2;
    }
    public int getHealthyAgents(){
        return this.healthyAgents;
    }
    public void setHealthyAgents(int healthyAgents){
        this.healthyAgents = (healthyAgents > 0) ? healthyAgents : -3;
    }

    public ObjectOfMap[][] mapInitialization(int size){
        return new ObjectOfMap[size][size];
    }

    public void agentInitializationOnMap() {
        ArrayList<Integer> listAgents = this.createAndFillArrayRepresentingAgents();
        int counterHealthy = 0, counterOfSick = 0;

            for (int i = 0; i < this.getSize(); i++) {
                for (int j = 0; j < this.getSize(); j++) {
                    if (listAgents.indexOf(1) == new Random().nextInt(listAgents.size()) && this.healthyAgents + this.sickAgents != counterOfSick + counterHealthy) {
                        if (new Random().nextInt(2) == 0 && this.healthyAgents != counterHealthy) {
                            this.arrayOfObjects[i][j] = new AgentBeforeIllness(i, j, this);
                            counterHealthy++;
                        }
                        else if (this.sickAgents != counterOfSick) {
                            this.arrayOfObjects[i][j] = new SickAgent(i, j, this, (int) new Random().nextInt(40), 0.4);
                            counterOfSick++;
                        }
                    }
                    else
                        this.arrayOfObjects[i][j] = new EmptyField(i, j, this);
                }
            }
    }

    public void printMap() {
        for (int i = 0; i < size; i++) {
            System.out.print(" __");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print("  " + this.arrayOfObjects[i][j].toString());
            }
            System.out.print("|");
            System.out.println();
        }
        for (int i = 0; i < size; i++) {
            System.out.print(" __");
        }
    }


    @Override
    public void changePositionOfAgent(Agent agent, int X, int Y) {
        this.arrayOfObjects[agent.getCoordinateX()][agent.getCoordinateY()] = new EmptyField(agent.getCoordinateX(), agent.getCoordinateY(), this);
        this.arrayOfObjects[X][Y] = agent;
    }

    public boolean checkField(int x, int y, Class<?> searchingType) {
        return searchingType.isInstance(this.arrayOfObjects[x][y]);
    }

    public ObjectOfMap[][] getArrayOfObjects() {    // Zwraca naszą mape w postaci tablicy
        return this.arrayOfObjects;
    }

    public void packageInitialization(Package kit) {
        boolean successOfOperation = true;
        do {
            if ((kit.getChanceOfSpawn() * 10) <= new Random().nextInt(10) + 1) {
                int coordinateX = new Random().nextInt(kit.getMapPartOf().size), coordinateY = new Random().nextInt(kit.getMapPartOf().getSize());
                if (kit.getMapPartOf().checkField(coordinateX, coordinateY, EmptyField.class))
                    kit.getMapPartOf().arrayOfObjects[coordinateX][coordinateY] = kit;

                else
                    successOfOperation = false;
            } else
                successOfOperation = false;
        } while (!(successOfOperation));
    }
    public ObjectOfMap getOneObjectOfMap(int coordinateX, int coordinateY){
        return this.arrayOfObjects[coordinateX][coordinateY];
    }
    public void showMap(){
        ObjectOfMap[][] array = this.getArrayOfObjects();
        int m = 0;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(array[i][j] instanceof Agent)
                    System.out.println(m + ". "+ array.toString());
                m++;
            }
        }
    }


    public void swapAgent(int coordinateX, int coordinateY, ObjectOfMap newAgent) {
        this.arrayOfObjects[coordinateX][coordinateY] = newAgent;

    }
    public ArrayList<Integer> createAndFillArrayRepresentingAgents(){
        ArrayList<Integer> arrayListOfAgent = new ArrayList<>();
        for(int i = 0; i < this.healthyAgents + this.sickAgents; i++)
            arrayListOfAgent.add(1);
        return arrayListOfAgent;
    }
}
