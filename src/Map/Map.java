package Map;

import Package.Package;
import AgentClasses.Agent;
import AgentClasses.AgentBeforeIllness;
import AgentClasses.SickAgent;

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
        return this.arrayOfObjects[coordinateX][coordinateY];
    }

    public void setOneObjectOfMap(int coordinateX, int coordinateY, ObjectOfMap newAgent) {
        this.arrayOfObjects[coordinateX][coordinateY] = newAgent;

    }

    public ObjectOfMap[][] emptyMapInitialization(){
        ObjectOfMap[][] map = new ObjectOfMap[this.getSize()][this.getSize()];
        for(int i = 0; i < this.getSize(); i++){
            for(int j =0; j < this.getSize(); j++)
                map[i][j] = new EmptyField(i,j, this);
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
                this.arrayOfObjects[coordinateX][coordinateY] = new AgentBeforeIllness(coordinateX, coordinateY, this);
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
                this.arrayOfObjects[coordinateX][coordinateY] = new SickAgent(coordinateX, coordinateY, this);
                i++;
            }
        }
        return this.arrayOfObjects;
    }

    @Override
    public void changePositionOfAgent(Agent agent, int newX, int newY) {
        int oldCoordinateX = agent.getCoordinateX(), oldCoordinateY = agent.getCoordinateY();
        this.arrayOfObjects[newX][newY] = this.arrayOfObjects[oldCoordinateX][oldCoordinateY];
        this.arrayOfObjects[newX][newY].setCoordinateX(newX);
        this.arrayOfObjects[newX][newY].setCoordinateY(newY);
        this.arrayOfObjects[oldCoordinateX][oldCoordinateY] = new EmptyField(oldCoordinateX, oldCoordinateY, this);
        agent.setIterationMove(true);
    }
    public void packageInitialization(Package kit) {
        boolean inSuccessfullOfOperation = false;
        do {
            if ((kit.getChanceOfSpawn() * 10) <= new Random().nextInt(10) + 1) {
                int coordinateX = new Random().nextInt(kit.getMapPartOf().size), coordinateY = new Random().nextInt(kit.getMapPartOf().getSize());
                if (kit.getMapPartOf().getOneObjectOfMap(coordinateX,coordinateY) instanceof EmptyField) {
                    this.setOneObjectOfMap(coordinateX, coordinateY, kit);
                    inSuccessfullOfOperation = true;
                }
            }
        } while (!(inSuccessfullOfOperation));
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
        System.out.println();
    }
     public void agentControlMethod(){
        //TODO Dopsisanie testu dla tej metody
        for(int i = 0; i < this.getSize(); i++){
            for(int j = 0; j < this.getSize(); j++){
                if(this.getOneObjectOfMap(j,i) instanceof Agent)
                    this.getOneObjectOfMap(j,i).responseForCallingOfActionOfObject();
            }
        }
    }
    public void packageSpawn(){

    }
    @Override   // TODO napisać test jednostkowy dla tej metody
    public void packageDestruction(){
        for (int i = 0; i < this.getSize(); i++){
            for (int j = 0; j < this.getSize(); j++){
                if (this.getOneObjectOfMap(j,i) instanceof Package) {
                    new EmptyField(j,i,this);
                }
            }
        }

    }

    @Override   //TODO napisać do tej metody test
    public void settingValueOfMoveIterationToFalse() {
        for (int i = 0; i < this.getSize(); i++){
            for (int j =0; j < this.getSize(); j++){
                if (this.getOneObjectOfMap(j,i) instanceof Agent){
                    ((Agent) this.getOneObjectOfMap(j,i)).setIterationMove(false);
                }
            }
        }
    }
}
