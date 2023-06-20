package AgentClasses;

/**
 * Interfejs metod agenta
 */
public interface AgentMethods {
    /**
     * Metoda zwracająca informację czy agent się poruszył w danej iteracji
     * @return <code>true</code> jeżeli agent się poruszył
     */
    boolean getIterationMove();

    /**
     * Ustawia informację o poruszeniu agenta w iteracji
     * @param didMoved informacja o poruszeniu agenta w iteracji <code>true</code>/<code>false</code>
     */
    void  setIterationMove(boolean didMoved);

    /**
     * Zmienia status agenta w odpowiednich warunkach
     */
    void changingStatusOfAgent();

    /**
     * Porusza agentem w jeden z ośmiu kierunków jeżeli to możliwe
     */
    void move();
}

