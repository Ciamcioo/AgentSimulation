package Map;

import Package.Package;
import AgendClasses.Agent;
import AgendClasses.AgentBeforeIllness;
import AgendClasses.SickAgent;
import Core.ObjectOfMap;

import java.util.ArrayList;
import java.util.Random;

public class Map implements MapMethods {

    static final int border = 2;
    private ObjectOfMap[][] arrayOfObjects;
    private int size;
    private int numberOfAgents;

    public Map(int size, int numberOfHealthyAgents, int numberOfSickAgents) { // Konstruktor klasy Map
        this.size = size;
        this.numberOfAgents = numberOfAgents;
        this.arrayOfObjects = this.agentInitializationAndMap(numberOfHealthyAgents, numberOfSickAgents);
    }

    public ObjectOfMap[][] agentInitializationAndMap(int numberOfHealthyAgents, int numberOfSickAgents) {
        ObjectOfMap[][] map = new ObjectOfMap[this.getSize() + border][this.getSize() + border];
        int numOfHealthyAgents = numberOfHealthyAgents, numOfSickAgents = numberOfSickAgents;
        ArrayList<Integer> agent = new ArrayList<Integer>();

        for (int i = 0; i < numberOfHealthyAgents + numberOfSickAgents; i++)
            agent.add(1);

        for (int i = 1; i <= this.getSize(); i++) {
            for (int j = 1; j <= this.getSize(); j++) {
                if (agent.indexOf(1) == new Random().nextInt(agent.size())) {
                    if (new Random().nextInt(2) == 0 && numOfHealthyAgents > 0) {
                        map[i][j] = new AgentBeforeIllness(i, j, this);
                        numOfHealthyAgents--;
                    } else if (numberOfSickAgents > 0) {
                        int dayOfSickness = new Random().nextInt(40);
                        map[i][j] = new SickAgent(i, j, this, dayOfSickness, 0.4);
                        numOfSickAgents--;
                    }
                } else {
                    map[i][j] = new EmptyField(i, j, this);
                }
            }
        }
        return map;
    }


    public void printMap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(" __");
        }
        System.out.println();
        for (int i = 1; i <= size; i++) {
            System.out.print("|");
            for (int j = 1; j <= size; j++) {
                System.out.print("  " + this.arrayOfObjects[i][j].toString());
            }
            System.out.print("|");
            System.out.println();
        }
        for (int i = 1; i <= size; i++) {
            System.out.print(" __");
        }
    }

    public int getSize(){
        return this.size;
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
            if ((kit.getChanceOfSpawn() * 10) <= new Random().nextInt(10)) {
                int coordinateX = new Random().nextInt(kit.getMapPartOf().size) - 1, coordinateY = new Random().nextInt(kit.getMapPartOf().getSize());
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


    public void swapAgent(int coordinateX, int coordinateY, ObjectOfMap newAgent) {
        this.arrayOfObjects[coordinateX][coordinateY] = newAgent;

    }
}
