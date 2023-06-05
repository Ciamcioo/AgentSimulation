package AgentClasses;

public interface AgentMethods {
    boolean getIterationMove(); // Metoda zwarcająca wartość boolean stwierdzająca czy obiekt poruszył się w tej iteracji
    void  setIterationMove(boolean didMoved); // Metoda ustawiająca wartość boolean stwierdzająca czy obiekt poruszył się w tej iteracji
    void move();    // Metoda odpowiadajaca za ruch agenta w jednym z osmiu kierunków jeżeli jest to możliwe
    void changingStatusOfAgent(); // Metoda odpowiadająca za zmianę typu agenta w odpowiednich warunkach
}

