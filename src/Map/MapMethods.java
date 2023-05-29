package Map;

import AgendClasses.Agent;
import Core.ObjectOfMap;
import Package.Package;

public interface MapMethods {
    ObjectOfMap[][] getArrayOfObjects();
    ObjectOfMap[][] agentInitializationAndMap(int numberOfHealthyAgents, int numberOfSickAgents);
    void printMap();
    int getSize();
    boolean checkPosition(int coordinateX, int coordinateY);
    void changePositionOfAgent(Agent agent,int X,int Y);
    void packageInitialization(Package kit);

}
