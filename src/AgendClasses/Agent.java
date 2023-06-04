package AgendClasses;

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
    public void setIterationMove(boolean changingStatus){
        this.iterationMove = changingStatus;
    }

    public void moveObjects() { // ruch wszystkich obiektów
        int[] directionOfX = {-1,-1,-1,0,0,1,1,1};
        int[] directionOfY = {-1,0,1,-1,1,-1,0,1};
        ObjectOfMap[][] arrayOfObjects = this.getMapPartOf().getArrayOfObjects();

        for(int i = 0; i < this.getMapPartOf().getSize(); i++) {
            for(int j = 0; j < this.getMapPartOf().getSize(); j++) {

                int index = new Random().nextInt(8);
                int newX = j + directionOfX[index];
                int newY = i + directionOfY[index];

                if(newX>=0 && newX<this.getMapPartOf().getSize() && newY>=0 && newY<this.getMapPartOf().getSize() && arrayOfObjects[newX][newY] instanceof EmptyField) {
//                    this.getMapPartOf().changePositionOfAgent(this,newX,newY);
                    // chyba dalej changePositionOfAgent niekoniecznie dobrze działa, bo wygląda jakby mniej ruszał tymi agentami? xD nwm
                    arrayOfObjects[newX][newY] = arrayOfObjects[j][i];
                    arrayOfObjects[newX][newY].setCoordinateX(newX);
                    arrayOfObjects[newX][newY].setCoordinateY(newY);
                    arrayOfObjects[j][i] = new EmptyField(j, i, this.getMapPartOf());
                    this.setIterationMove(true);
                }

            }
        }
    }

    public void move(){
        boolean isMovePossible = true;
        do {
            int directionOfMove = new Random().nextInt(8) + 1;
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
