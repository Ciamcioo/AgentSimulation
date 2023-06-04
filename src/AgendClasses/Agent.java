package AgendClasses;

import Core.ObjectOfMap;
import Map.Map;
import java.util.Random;
import Map.EmptyField;

public abstract class Agent extends ObjectOfMap implements AgentMethods {
    public Agent(int coordinateX, int coordinateY, Map mapPartOf){      //  Konstruktor Agenta, który wywołuje konstruktor ObjectOfMap
        super(coordinateX, coordinateY, mapPartOf);
    }
    public void move(){
        boolean isMovePossible = true;
        do {
            int directionOfMove = new Random().nextInt(8);
            switch (directionOfMove){
                case 1:{
                    int coordinateXToCheck = this.getCoordinateX() - 1, coordinateYToCheck = this.getCoordinateY() + 1;
                    // tu jeszcze chyba trzeba sprawdzać czy koordynaty nie są mniejsze od 0 i większe od rozmiaru
                    if(this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 2:{
                    int coordinateXToCheck = this.getCoordinateX() , coordinateYToCheck = this.getCoordinateY() + 1;
                    if(this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;

                    break;
                }
                case 3:{
                    int coordinateXToCheck = this.getCoordinateX() + 1, coordinateYToCheck = this.getCoordinateY() + 1;
                    if(this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 4:{
                    int coordinateXToCheck = this.getCoordinateX() - 1, coordinateYToCheck = this.getCoordinateY();
                    if(this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 5:{
                    int coordinateXToCheck = this.getCoordinateX() + 1, coordinateYToCheck = this.getCoordinateY();
                    if(this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 6:{
                    int coordinateXToCheck = this.getCoordinateX() - 1, coordinateYToCheck = this.getCoordinateY() - 1;
                    if(this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 7:{
                    int coordinateXToCheck = this.getCoordinateX(), coordinateYToCheck = this.getCoordinateY() - 1;
                    if(this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 8:{
                    int coordinateXToCheck = this.getCoordinateX() + 1, coordinateYToCheck = this.getCoordinateY() - 1;
                    if(this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
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

    @Override
    public void chengingStatusOfAgent() {
        try {
            throw new Exception("Error not correct agent class");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void searching(){

    }
}
