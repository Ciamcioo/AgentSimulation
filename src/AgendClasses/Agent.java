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
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 2:{
                    int coordinateXToCheck = this.getCoordinateX() , coordinateYToCheck = this.getCoordinateY() + 1;
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;

                    break;
                }
                case 3:{
                    int coordinateXToCheck = this.getCoordinateX() + 1, coordinateYToCheck = this.getCoordinateY() + 1;
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 4:{
                    int coordinateXToCheck = this.getCoordinateX() - 1, coordinateYToCheck = this.getCoordinateY();
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 5:{
                    int coordinateXToCheck = this.getCoordinateX() + 1, coordinateYToCheck = this.getCoordinateY();
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 6:{
                    int coordinateXToCheck = this.getCoordinateX() - 1, coordinateYToCheck = this.getCoordinateY() - 1;
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 7:{
                    int coordinateXToCheck = this.getCoordinateX(), coordinateYToCheck = this.getCoordinateY() - 1;
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                        this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck);
                    else
                        isMovePossible = false;
                    break;
                }
                case 8:{
                    int coordinateXToCheck = this.getCoordinateX() + 1, coordinateYToCheck = this.getCoordinateY() - 1;
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
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
