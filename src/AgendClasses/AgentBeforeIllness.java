package AgendClasses;
import Map.Map;
public class AgentBeforeIllness extends Agent {
    public AgentBeforeIllness(int coordinateX, int coordinateY, Map partMapOf){ //  Konstruktor Agenta, który wywołuje konstruktor ObjectOfMap
        super(coordinateX, coordinateY, partMapOf);
    }

<<<<<<< HEAD
    /*@Override
    public void checkPosition(int X, int Y) {

    }*/

=======
>>>>>>> d8fccfd (Coś tam zacząłem pracować nad pakietami. Uzupełniłem parę rzeczy z listy TODO. Uporządkowałem, dodałem komentarze do funkcji.)
    @Override
    public void chengingStatusOfAgent(Agent agent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chengingStatusOfAgent'");
    }
    @Override
    public String toString(){
        return "B";
    } // wyświetla na mapie
}
