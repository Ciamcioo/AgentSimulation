package AgentClasses;

public interface AgentMethods {
    // Metoda zwarcająca wartość boolean stwierdzająca czy obiekt poruszył się w tej iteracji
    boolean getIterationMove();
    // Metoda ustawiająca wartość boolean stwierdzająca czy obiekt poruszył się w tej iteracji
    void  setIterationMove(boolean didMoved);
    // Metoda odpowiadajaca za ruch agenta w jednym z osmiu kierunków jeżeli jest to możliwe
    void move();
    // Metoda odpowiadająca za zmianę statusu agenta w odpowiednich warunkach
    void changingStatusOfAgent();

}

