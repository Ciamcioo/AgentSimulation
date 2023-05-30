package AgendClasses;

import Core.ObjectOfMap;
import Map.Map;
import java.util.Random;

public abstract class Agent extends ObjectOfMap implements AgentMethods {
    public Agent(int coordinateX, int coordinateY, Map mapPartOf){      //  Konstruktor Agenta, który wywołuje konstruktor ObjectOfMap
        super(coordinateX, coordinateY, mapPartOf);
    }
    public void move(Agent agent){               // Funkcja losuje jeden z pośród ośmiu możliwych ruchów, sprawdza czy mozna wykonać tam ruch, jeżeli to możliwe przesuwa agenta. Jeżeli to nie możliwe to powtarza to dla tego agenta.
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
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
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

    public boolean checkIfNeighbor(Map map, Class<?> neighborType) { //  Sprawdza sąsiedztwo obiektu określonej klasy w około wybranego agenta/obiektu
        ObjectOfMap[][] mapArray = map.getArrayOfObjects();
        int size = map.getSize();
        int x = this.getCoordinateX();
        int y = this.getCoordinateY();
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
        // TODO usunąc duplikat tej metody i ujednolicić metody sprawdzające
        this.getMapPartOf().changePositionOfAgent(this, X, Y);
    }

}
