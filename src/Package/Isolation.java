package Package;
import Map.Map;

public class Isolation extends Package{
    public Isolation(Map mapPartOf, double chanceOfSpawn){
        super(mapPartOf, chanceOfSpawn);
    }
    public Isolation(int coordinateX,int coordinateY, Map mapPartOf, double chanceOfSpawn){
        super(coordinateX, coordinateY, mapPartOf, chanceOfSpawn);
    }
    public void responseForCallingOfActionOfObject(){
        // TODO napisać dla obiektu typu Isolation odpowiednie metody wywoływane w czasie jednej iteracji na obiekcie respown -> sprawdzanie otoczenia czyli searching -> jeżli możemy wpływany na obiekty w otoczeniu to zmieniamy ich stan -> zniszczenie obiektu
        // TODO napisać dla tej metody testy jednostkowe
    }
    @Override
    public String toString(){ // Reprezentacje Isolation w konsoli
        return "I";
    }

}
