package Core;

public abstract class ObjectOfMap implements ObjectOfMapMethods{
    private int coordinateX;
    private int coordinateY;
    @Override
    public int getCoordinateX(){
        return this.coordinateX;
    }
    @Override
    public void setCoordinateX(int newCoordinateX){
        // TODO kontrola błędów przy ustawianiu kordynatów X
        this.coordinateX = newCoordinateX;
    }
    public int getCoordinateY(){
        return this.coordinateY;
    }
    public void setCoordinateY(int newCoordinateY){
        // TODO kontrola błęów przy ustawianiu kordynatów Y
        this.coordinateY = newCoordinateY;
    }


}
