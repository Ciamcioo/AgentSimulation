package Map;

public abstract class ObjectOfMap implements ObjectOfMapMethods{

    private int coordinateX;
    private int coordinateY;
    private Map mapPartOf;

    // Konstruktor klasy ObjectOfMap
    public ObjectOfMap(int coordinateX, int coordinateY, Map mapPartOf){
            this.setMapPartOf(mapPartOf);
            this.setCoordinateX(coordinateX);
            this.setCoordinateY(coordinateY);
    }

    public int getCoordinateX(){ // Zwraca współrzedną X obiektu typu ObjectOfMap
        return this.coordinateX;
    }

    public void setCoordinateX(int newCoordinateX){
        if(newCoordinateX >= 0 && newCoordinateX < mapPartOf.getDataOfSimulation().getSize())
            this.coordinateX = newCoordinateX;
    }
    public int getCoordinateY(){ // Zwraca współrzedną Y obiektu typu ObjectOfMap
        return this.coordinateY;
    }
    public void setCoordinateY(int newCoordinateY){
        if(newCoordinateY >= 0 || newCoordinateY < mapPartOf.getDataOfSimulation().getSize())
            this.coordinateY = newCoordinateY;
    }
    public Map getMapPartOf(){ // Zwraca mapę do której należy obiekty typu ObjectOfMap
        return this.mapPartOf;
    }

    public void setMapPartOf(Map map){ // Ustawia mapę do której należy obiekty typu ObjectOfMap
        this.mapPartOf = map;
    }

    public ObjectOfMap checkIfNeighbor(Map map, Class<?> neighborType) {
        ObjectOfMap[][] mapArray = map.getArrayOfObjects();
        int size = map.getDataOfSimulation().getSize();
        int x = this.getCoordinateX();
        int y = this.getCoordinateY();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = x + dx;
                int ny = y + dy;
                if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
                    if (neighborType.isInstance(mapArray[nx][ny])) {
                        return map.getOneObjectOfMap(nx, ny);
                    }
                }
            }
        }
    return null;
}
}
