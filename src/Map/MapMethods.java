package Map;

import AgendClasses.Agent;
import Core.ObjectOfMap;

public interface MapMethods {
    ObjectOfMap[][] agentInitializationOnMap(int size, int numberOfHealthyAgents, int numberOfSickAgents);
    void printMap();
    int getSize();
    boolean checkPosition(int coordinateX, int coordinateY);
    void changePositionOfAgent(Agent agent,int X,int Y);


}
