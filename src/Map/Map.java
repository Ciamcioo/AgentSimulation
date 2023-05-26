package Map;


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

    public Map(int size, int numberOfHealthyAgents, int numberOfSickAgents) {
        this.size = size;
        this.numberOfAgents = numberOfAgents;
        this.arrayOfObjects = this.agentInitializationOnMap(this.size, numberOfHealthyAgents, numberOfSickAgents);
    }

    public ObjectOfMap[][] agentInitializationOnMap(int size, int numberOfHealthyAgents, int numberOfSickAgents) {
        ObjectOfMap[][] map = new ObjectOfMap[size + border][size + border];
        int numOfHealthyAgents = numberOfHealthyAgents, numOfSickAgents = numberOfSickAgents;
        ArrayList<Integer> agent = new ArrayList<Integer>();

        for (int i = 0; i < numberOfHealthyAgents + numberOfSickAgents; i++)
            agent.add(1);

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (agent.indexOf(1) == new Random().nextInt(agent.size())) {
                    if (new Random().nextInt(2) == 0 && numOfHealthyAgents > 0) {
                        map[i][j] = new AgentBeforeIllness(i, j, this);
                        numOfHealthyAgents--;
                    } else if(numberOfSickAgents > 0){
                        int dayOfSickness = new Random().nextInt(40);
                        map[i][j] = new SickAgent(i, j, this, dayOfSickness, 0.4 );
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
        return this.getSize();
    }
    public boolean checkPosition(int coordinateX, int coordinateY){
        return this.arrayOfObjects[coordinateX][coordinateY] instanceof EmptyField;
    }
}