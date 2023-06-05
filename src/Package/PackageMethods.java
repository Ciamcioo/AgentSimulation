package Package;

import AgentClasses.Agent;

public interface PackageMethods {
    void beingPickedUp(Agent agentToBeInfluence);
    double getChanceOfSpawn();
    void setChanceOfSpawn(double chanceOfSpawn);
    boolean isEmpty();
    void setEmpty();

}

