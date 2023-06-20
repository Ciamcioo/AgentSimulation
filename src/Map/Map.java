package Map;

import Core.DataOfSimulation;
import Package.Package;
import AgentClasses.Agent;
import AgentClasses.AgentBeforeIllness;
import AgentClasses.SickAgent;
import Package.VaccineKit;
import java.util.Random;
import Package.Isolation;

/**
 * Klasa mapy
 */
public class Map implements MapMethods {
    private int changedObjects = 0;
    private DataOfSimulation dataOfSimulation;
    private ObjectOfMap[][] arrayOfObjects;

    /**
     * Konstruktor klasy <code>Map</code>
     * @param dataOfSimulation dane symulacji typu <code>DataOfSimulation</code>
     */
    public Map(DataOfSimulation dataOfSimulation) {
        this.setDataOfSimulation(dataOfSimulation);
        this.arrayOfObjects = this.emptyMapInitialization();
        this.agentInitializationOnMap();
    }

    /**
     * Zwraca dane symulacji
     * @return dane symulacji
     */
    public DataOfSimulation getDataOfSimulation(){
        return this.dataOfSimulation;
    }

    /**
     * Ustawia dane symulacji
     * @param dataOfSimulation dane symulacji
     */
    public void setDataOfSimulation(DataOfSimulation dataOfSimulation) {
        if (dataOfSimulation != null)
            this.dataOfSimulation = dataOfSimulation;
    }

    public ObjectOfMap[][] getArrayOfObjects() {
        return this.arrayOfObjects;
    }

    public void setArrayOfObjects(ObjectOfMap[][] arrayOfObjects) {
        this.arrayOfObjects = arrayOfObjects;
    }

    public ObjectOfMap getOneObjectOfMap(int coordinateX, int coordinateY) {
        return this.arrayOfObjects[coordinateX][coordinateY];
    }

    public void setOneObjectOfMap(int coordinateX, int coordinateY, ObjectOfMap newAgent) {
        this.arrayOfObjects[coordinateX][coordinateY] = newAgent;
    }

    public int getChangedObjects() { return changedObjects; }

    public void setChangedObjects(int changedObjects) {
        if (changedObjects >= 0)
            this.changedObjects = changedObjects;
        else
            this.changedObjects = 0;
    }

    public void agentInitializationOnMap() {
        this.arrayOfObjects = this.initializationOfHealthyAgents();
        this.arrayOfObjects = this.initializationOfSickAgents();
    }

    public ObjectOfMap[][] emptyMapInitialization(){
        this.arrayOfObjects = new ObjectOfMap[this.dataOfSimulation.getSize()][this.dataOfSimulation.getSize()];
        for (int i = 0; i < this.dataOfSimulation.getSize(); i++) {
            for (int j = 0; j < this.dataOfSimulation.getSize(); j++)
                this.arrayOfObjects[i][j] = new EmptyField(j,i, this);
        }
        return this.arrayOfObjects;
    }

    public ObjectOfMap[][] initializationOfHealthyAgents(){
        for (int i =0; i < this.getDataOfSimulation().getNumberOfHealthyAgents();) {
            int coordinateX = new Random().nextInt(this.dataOfSimulation.getSize());
            int coordinateY = new Random().nextInt(this.dataOfSimulation.getSize());
            if (this.getOneObjectOfMap(coordinateX, coordinateY) instanceof EmptyField) {
                this.arrayOfObjects[coordinateX][coordinateY] = new AgentBeforeIllness(coordinateX, coordinateY, this);
                i++;
            }
        }
        return this.arrayOfObjects;
    }

    public ObjectOfMap[][] initializationOfSickAgents(){
        for (int i = 0; i < this.getDataOfSimulation().getNumberOfSickAgents();) {
            int coordinateX = new Random().nextInt(this.dataOfSimulation.getSize());
            int coordinateY = new Random().nextInt(this.dataOfSimulation.getSize());
            if (this.getOneObjectOfMap(coordinateX, coordinateY) instanceof EmptyField) {
                this.arrayOfObjects[coordinateX][coordinateY] = new SickAgent(coordinateX, coordinateY, this, this.getDataOfSimulation().getMinDayTillEndOfIllness(), this.getDataOfSimulation().getMaxDayTillEndOfIllness());
                i++;
            }
        }
        return this.arrayOfObjects;
    }

    public void packageInitialization() {
        this.vaccineKitInitialization();
        this.isolationInitialization();
    }

    public void vaccineKitInitialization() {
        for (int i = 0; i < this.dataOfSimulation.getNumberOfVaccineKit(); i++) {
            if ((this.dataOfSimulation.getChanceOfSpawnVaccine() * 10) <= new Random().nextInt(10) + 1) {
                int coordinateX = new Random().nextInt(this.dataOfSimulation.getSize()), coordinateY = new Random().nextInt(this.dataOfSimulation.getSize());
                if (this.getOneObjectOfMap(coordinateX, coordinateY) instanceof EmptyField)
                    new VaccineKit(coordinateX, coordinateY, this);
            }
        }
    }
    public void isolationInitialization() {
        for (int i = 0; i < this.dataOfSimulation.getNumberOfIsolation(); i++) {
            if ((this.dataOfSimulation.getChanceOfSpawnIsolation() * 10) <= new Random().nextInt(10) + 1) {
                int coordinateX = new Random().nextInt(this.dataOfSimulation.getSize()), coordinateY = new Random().nextInt(this.dataOfSimulation.getSize());
                if (this.getOneObjectOfMap(coordinateX,coordinateY) instanceof EmptyField)
                    new Isolation(coordinateX,coordinateY,this);
            }
        }
    }

    public void agentControlMethod() {
        for (int i = 0; i < this.dataOfSimulation.getSize(); i++) {
            for (int j = 0; j < this.dataOfSimulation.getSize(); j++) {
                if (this.getOneObjectOfMap(j,i) instanceof Agent || this.getOneObjectOfMap(j,i) instanceof Package)
                    this.getOneObjectOfMap(j,i).responseForCallingOfActionOfObject();
            }
        }
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

    public void printMap() {
        for (int i = 0; i < this.dataOfSimulation.getSize(); i++) {
            System.out.print(" __");
        }
        System.out.println();
        for (int i = 0; i < this.dataOfSimulation.getSize(); i++) {
            System.out.print("|");
            for (int j = 0; j < this.dataOfSimulation.getSize(); j++) {

                System.out.print("  " + this.arrayOfObjects[i][j].toString());

            }
            System.out.print("|");
            System.out.println();
        }
        for (int i = 0; i < this.dataOfSimulation.getSize(); i++) {
            System.out.print(" __");
        }
        System.out.println();
    }

    @Override
    public void packageDestruction() {
        for (int i = 0; i < this.dataOfSimulation.getSize(); i++) {
            for (int j = 0; j < this.dataOfSimulation.getSize(); j++) {
                if (this.getOneObjectOfMap(j,i) instanceof Package && ((Package) this.getOneObjectOfMap(j,i)).isEmpty()) {
                    new EmptyField(j,i,this);
                }
            }
        }
    }

    @Override
    public void settingValueOfMoveIterationToFalse() {
        for (int i = 0; i < this.dataOfSimulation.getSize(); i++) {
            for (int j =0; j < this.dataOfSimulation.getSize(); j++) {
                if (this.getOneObjectOfMap(j,i) instanceof Agent) {
                    ((Agent) this.getOneObjectOfMap(j,i)).setIterationMove(false);
                }
            }
        }
    }
}
