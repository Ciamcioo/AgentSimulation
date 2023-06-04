package AgendClasses;

import Core.ObjectOfMap;
import Map.Map;
import java.util.Random;
import Map.EmptyField;

public abstract class Agent extends ObjectOfMap implements AgentMethods {
    public Agent(int coordinateX, int coordinateY, Map mapPartOf){      //  Konstruktor Agenta, który wywołuje konstruktor ObjectOfMap

        super(coordinateX, coordinateY, mapPartOf);
    }

    public void moveObjects() { // ruch wszystkich obiektów
        int[] directionOfX = {-1,-1,-1,0,0,1,1,1};
        int[] directionOfY = {-1,0,1,-1,1,-1,0,1};

        ObjectOfMap[][] arrayOfObjects = this.getMapPartOf().getArrayOfObjects();
        int size = this.getMapPartOf().getSize();

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {

                int index = new Random().nextInt(8);
                int newX = j + directionOfX[index];
                int newY = i + directionOfY[index];

                if(newX>=0 && newX<size && newY>=0 && newY<size && EmptyField.class.isInstance(arrayOfObjects[newX][newY])) {
                    arrayOfObjects[newX][newY] = arrayOfObjects[j][i];
                    arrayOfObjects[newX][newY].setCoordinateX(newX,this.getMapPartOf());
                    arrayOfObjects[newX][newY].setCoordinateY(newY);
                    arrayOfObjects[j][i] = new EmptyField(j, i, this.getMapPartOf());
                }

            }
        }
    }

    public void move(){
        boolean isMovePossible = true;
        do {
            int directionOfMove = new Random().nextInt(8);
            switch (directionOfMove){
                case 1:{
                    int coordinateXToCheck = this.getCoordinateX() - 1, coordinateYToCheck = this.getCoordinateY() + 1;
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                    {this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck); isMovePossible = true;}
                    else
                        isMovePossible = false;
                    break;
                }
                case 2:{
                    int coordinateXToCheck = this.getCoordinateX() , coordinateYToCheck = this.getCoordinateY() + 1;
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                    {this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck); isMovePossible = true;}
                    else
                        isMovePossible = false;

                    break;
                }
                case 3:{
                    int coordinateXToCheck = this.getCoordinateX() + 1, coordinateYToCheck = this.getCoordinateY() + 1;
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                    {this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck); isMovePossible = true;}
                    else
                        isMovePossible = false;
                    break;
                }
                case 4:{
                    int coordinateXToCheck = this.getCoordinateX() - 1, coordinateYToCheck = this.getCoordinateY();
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                    {this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck); isMovePossible = true;}
                    else
                        isMovePossible = false;
                    break;
                }
                case 5:{
                    int coordinateXToCheck = this.getCoordinateX() + 1, coordinateYToCheck = this.getCoordinateY();
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                    {this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck); isMovePossible = true;}
                    else
                        isMovePossible = false;
                    break;
                }
                case 6:{
                    int coordinateXToCheck = this.getCoordinateX() - 1, coordinateYToCheck = this.getCoordinateY() - 1;
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                    {this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck); isMovePossible = true;}
                    else
                        isMovePossible = false;
                    break;
                }
                case 7:{
                    int coordinateXToCheck = this.getCoordinateX(), coordinateYToCheck = this.getCoordinateY() - 1;
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                    {this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck); isMovePossible = true;}
                    else
                        isMovePossible = false;
                    break;
                }
                case 8:{
                    int coordinateXToCheck = this.getCoordinateX() + 1, coordinateYToCheck = this.getCoordinateY() - 1;
                    if(coordinateXToCheck >= 0 && coordinateXToCheck < this.getMapPartOf().getSize() && coordinateYToCheck >= 0 && coordinateYToCheck < this.getMapPartOf().getSize() && this.getMapPartOf().checkField(coordinateXToCheck, coordinateYToCheck, EmptyField.class))
                    {this.getMapPartOf().changePositionOfAgent(this, coordinateXToCheck, coordinateYToCheck); isMovePossible = true;}
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
