package Map;

import Package.Package;
import AgendClasses.Agent;
import AgendClasses.AgentBeforeIllness;
import AgendClasses.SickAgent;
import Core.ObjectOfMap;

import java.util.ArrayList;
import java.util.Random;

public class Map implements MapMethods {

    private int size;
    private int healthyAgents;
    private int sickAgents;
    private ObjectOfMap[][] arrayOfObjects;

    public Map(int size, int numberOfHealthyAgents, int numberOfSickAgents) {
        this.setSize(size);
        this.setSickAgents(numberOfSickAgents);
        this.setHealthyAgents(numberOfHealthyAgents);
        this.arrayOfObjects = this.emptyMapInitialization();
        this.agentInitializationOnMap();
    }
    public int getSize(){
        return this.size;
    }

    public void setSize(int size){
        this.size = size > 0 ? size : -1;
    }
    public int getHealthyAgents(){
        return this.healthyAgents;
    }
    public void setHealthyAgents(int healthyAgents){
        this.healthyAgents = (healthyAgents > 0) ? healthyAgents : -3;
    }
    public int getSickAgents(){
        return this.sickAgents;
    }
    public void setSickAgents(int sickAgents){
        this.sickAgents = sickAgents > 0 ? sickAgents : -2;
    }

    public ObjectOfMap[][] getArrayOfObjects() {
        return this.arrayOfObjects;
    }

    public void setArrayOfObjects(ObjectOfMap[][] arrayOfObjects) {
        this.arrayOfObjects = arrayOfObjects;
    }

    public ObjectOfMap getOneObjectOfMap(int coordinateX, int coordinateY){
        return this.arrayOfObjects[coordinateY][coordinateX];
    }

    public void setOneObjectOfMap(int coordinateX, int coordinateY, ObjectOfMap newAgent) {
        this.arrayOfObjects[coordinateX][coordinateY] = newAgent;

    }

    public ObjectOfMap[][] emptyMapInitialization(){
        ObjectOfMap[][] map = new ObjectOfMap[this.getSize()][this.getSize()];
        for(int i = 0; i < this.getSize(); i++){
            for(int j =0; j < this.getSize(); j++)
                map[i][j] = new EmptyField(j, i, this);
        }
        return map;
    }

    public void agentInitializationOnMap(){
        this.arrayOfObjects = this.initializationOfHealthyAgents();
        this.arrayOfObjects = this.initializationOfSickAgents();
    }

    public ObjectOfMap[][] initializationOfHealthyAgents(){
        for(int i =0; i < this.healthyAgents;){
            int coordinateX = new Random().nextInt(this.getSize());
            int coordinateY = new Random().nextInt(this.getSize());
            if(this.getOneObjectOfMap(coordinateX, coordinateY) instanceof EmptyField) {
                this.arrayOfObjects[coordinateY][coordinateX] = new AgentBeforeIllness(coordinateX, coordinateY, this);
                i++;
            }
        }
        return this.arrayOfObjects;
    }

    public ObjectOfMap[][] initializationOfSickAgents(){
        for (int i = 0; i < this.sickAgents;) {
            int coordinateX = new Random().nextInt(this.getSize());
            int coordinateY = new Random().nextInt(this.getSize());
            if (this.getOneObjectOfMap(coordinateX, coordinateY) instanceof EmptyField) {
                this.arrayOfObjects[coordinateY][coordinateX] = new SickAgent(coordinateX, coordinateY, this, new Random().nextInt(40) + 1, new Random().nextDouble(1));
                i++;
            }
        }
        return this.arrayOfObjects;
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
    public void changePositionOfAgent(Agent agent, int newX, int newY) {
        this.arrayOfObjects[newY][newX] = this.arrayOfObjects[agent.getCoordinateY()][agent.getCoordinateX()];
        this.arrayOfObjects[agent.getCoordinateX()][agent.getCoordinateY()] = new EmptyField(agent.getCoordinateX(), agent.getCoordinateY(), this);
        arrayOfObjects[newY][newX].setCoordinateY(newY);
        arrayOfObjects[newY][newX].setCoordinateX(newX);
    }

    public boolean checkField(int x, int y, Class<?> searchingType) {
        return searchingType.isInstance(this.arrayOfObjects[x][y]);
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
}
