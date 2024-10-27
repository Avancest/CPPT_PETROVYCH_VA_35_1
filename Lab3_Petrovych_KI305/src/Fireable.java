import java.io.IOException;

/**
 * Interface defining methods for reloading and shooting.
 */
public interface Fireable {
    void shoot() throws IOException;
    void reload(int newAmmo) throws IOException;
}