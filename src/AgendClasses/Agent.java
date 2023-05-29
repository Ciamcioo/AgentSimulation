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
//            int directionOfMove = new Random().nextInt(8) + 1;
            int directionOfMove = 1;
            switch (directionOfMove){
                case 1:{
                    int coordinateXToCheck = agent.getCoordinateX() - 1, coordinateYToCheck = agent.getCoordinateY() + 1;
                    if(agent.checkPositionToMove(coordinateXToCheck, coordinateYToCheck))
                        agent.move(coordinateXToCheck, coordinateYToCheck);
                    else
                        System.out.println("Przeniesienie nie udane");
                    break;
                }
                case 2:{

                }
            }

        }while(isMovePossible);
    }

/*public boolean checkIfNeighbor(Map map, ObjectOfMap agent, Class<?> neighborType) {
    ObjectOfMap[][] mapArray = map.getMapArray();
    int size = map.getSize();
    int x = agent.getCoordinateX();
    int y = agent.getCoordinateY();
    for (int dx = -1; dx <= 1; dx++) {
        for (int dy = -1; dy <= 1; dy++) {
            int nx = x + dx;
            int ny = y + dy;
            if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
                if (neighborType.isInstance(mapArray[nx][ny])) {
                    return true;
                }
            }
        }
    }
    return false;
}*/

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
    @Override
    public boolean checkPositionToMove(int X, int Y){
        return this.getMapPartOf().checkPosition(X, Y);
    }
    @Override
    public void move(int X, int Y){
        this.getMapPartOf().changePositionOfAgent(this, X, Y);
    }

}
