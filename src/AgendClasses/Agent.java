package AgendClasses;

import Core.ObjectOfMap;
import Map.Map;
import java.util.Random;

public abstract class Agent extends ObjectOfMap implements AgentMethods {
    public Agent(int coordinateX, int coordinateY, Map mapPartOf){      //  Konstruktor Agenta, który wywołuje konstruktor ObjectOfMap
        super(coordinateX, coordinateY, mapPartOf);
    }
    public void move(Agent agent){
        boolean isMovePossible = true;
        do {
            int directionOfMove = new Random().nextInt(8) + 1;
            switch (directionOfMove){
                case 1:{
                    int coordinateXToCheck = agent.getCoordinateX() - 1, coordinateYToCheck = agent.getCoordinateY() + 1;
                    if(agent.getMapPartOf().checkIsAgent(coordinateXToCheck, coordinateYToCheck))
                        agent.move(coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 2:{
                    int coordinateXToCheck = agent.getCoordinateX() , coordinateYToCheck = agent.getCoordinateY() + 1;
                    if(agent.getMapPartOf().checkIsAgent(coordinateXToCheck, coordinateYToCheck))
                        agent.move(coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;

                    break;
                }
                case 3:{
                    int coordinateXToCheck = agent.getCoordinateX() + 1, coordinateYToCheck = agent.getCoordinateY() + 1;
                    if(agent.getMapPartOf().checkIsAgent(coordinateXToCheck, coordinateYToCheck))
                        agent.move(coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 4:{
                    int coordinateXToCheck = agent.getCoordinateX() - 1, coordinateYToCheck = agent.getCoordinateY();
                    if(agent.getMapPartOf().checkIsAgent(coordinateXToCheck, coordinateYToCheck))
                        agent.move(coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;

                    break;
                }
                case 5:{
                    int coordinateXToCheck = agent.getCoordinateX() + 1, coordinateYToCheck = agent.getCoordinateY();
                    if(agent.getMapPartOf().checkIsAgent(coordinateXToCheck, coordinateYToCheck))
                        agent.move(coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;

                    break;
                }
                case 6:{
                    int coordinateXToCheck = agent.getCoordinateX() - 1, coordinateYToCheck = agent.getCoordinateY() - 1;
                    if(agent.getMapPartOf().checkIsAgent(coordinateXToCheck, coordinateYToCheck))
                        agent.move(coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;

                    break;
                }
                case 7:{
                    int coordinateXToCheck = agent.getCoordinateX(), coordinateYToCheck = agent.getCoordinateY() - 1;
                    if(agent.getMapPartOf().checkIsAgent(coordinateXToCheck, coordinateYToCheck))
                        agent.move(coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;

                    break;
                }
                case 8:{
                    int coordinateXToCheck = agent.getCoordinateX() + 1, coordinateYToCheck = agent.getCoordinateY() - 1;
                    if(agent.getMapPartOf().checkIsAgent(coordinateXToCheck, coordinateYToCheck))
                        agent.move(coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;

                    break;
                }
                default:{
                    isMovePossible = false;
                }
            }

        }while(!(isMovePossible));
    }

    public boolean checkIfNeighbor(Map map, ObjectOfMap agent, Class<?> neighborType) { //  Sprawdza sąsiedztwo obiektu mapy
        ObjectOfMap[][] mapArray = map.getArrayOfObjects();
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
}

    @Override
    public void move(int X, int Y){   // Zmienia pozycje agenta
        this.getMapPartOf().changePositionOfAgent(this, X, Y);
    }

}
