package AgentClasses;

import Core.ObjectOfMap;
import Map.Map;
import java.util.Random;
import Map.EmptyField;

public abstract class Agent extends ObjectOfMap implements AgentMethods {
    private boolean iterationMove = false;
    public Agent(int coordinateX, int coordinateY, Map mapPartOf){
        super(coordinateX, coordinateY, mapPartOf);
    }
    public boolean getIterationMove(){
        return this.iterationMove;
    }
    public void setIterationMove(boolean didMoved){
        this.iterationMove = didMoved;
    }

    public void move() {
        int[] directionOfX = {-1,-1,-1,0,0,1,1,1};
        int[] directionOfY = {-1,0,1,-1,1,-1,0,1};
        do {
            int index = new Random().nextInt(8);
            int newX = this.getCoordinateX() + directionOfX[index];
            int newY = this.getCoordinateY() + directionOfY[index];

            if (newX >= 0 && newX < this.getMapPartOf().getSize() && newY >= 0 && newY < this.getMapPartOf().getSize() && this.getMapPartOf().getOneObjectOfMap(newX, newY) instanceof EmptyField)
                this.getMapPartOf().changePositionOfAgent(this, newX, newY);

        }while(!(this.iterationMove));
    }



    @Override
    public void changingStatusOfAgent() {
        try {
            throw new Exception("Error not correct agent class");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void searching(){
        try {
            throw new Exception("Error this object cannot search");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
