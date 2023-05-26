package AgendClasses;

import Core.ObjectOfMap;
import Map.Map;
import java.util.Random;

public abstract class Agent extends ObjectOfMap implements AgentMethods {
    public Agent(int coordinateX, int coordinateY, Map mapPartOf){
        super(coordinateX, coordinateY, mapPartOf);
    }
    public void move(Agent agent){
        boolean isMovePossible = false;
        do {
            int directionOfMove = new Random().nextInt(8) + 1;
            switch (directionOfMove){
                case 1:{
                    int coordinateXToCheck = agent.getCoordinateX() - 1, coordinateYToCheck = agent.getCoordinateY() + 1;

                    break;
                }
                case 2:{

                }
            }

        }while(isMovePossible);
    }
//    @Override
//    public int getCoordinateX(){
//        return
//    }
//    @Override
//    public void setCoordinateX(int newValueForX){
//        // musimy sprawdzić czy wartość taka X znajduje się w mapie jeśli tak to dokonujemy zmiany
//    }
//
//    @Override
//    public int getCoordinateY(){
//        return this.coordinateY;
//    }
//    @Override
//    public void setCoordinateY(int newValueForY){
//        // musimy sprawdzić czy wartość taka Y znajduje się w mapie jeśli tak to dokonujemy zmiany
//
//    }


}
