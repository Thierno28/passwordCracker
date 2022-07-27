

// import hack.Cracker;

// import java.util.*;

public class CrackerFactory {
    public Cracker algo(String type) {
        switch (type) {
            case "BRUTE_FORCE":
                return new BruteForce();
            case "DICTIONNARY":
                return new DictionaryAttack();
            default:
                return new BruteForce();
        }
    }
}
