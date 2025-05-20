import java.util.*;

public class SymbolGenerator {
    private static final char[] ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f'};
    private Random rand = new Random();

    public List<Character> generate(int length) {
        List<Character> sequence = new ArrayList<>();
        double[] probabilities = {0.05, 0.1, 0.15, 0.18, 0.22, 0.3};

        for (int i = 0; i < length; i++) {
            if (i > 0 && i % 200 == 0) {
                // Swap probabilities
                double temp = probabilities[0];
                probabilities[0] = probabilities[2];
                probabilities[2] = temp;

                temp = probabilities[3];
                probabilities[3] = probabilities[5];
                probabilities[5] = temp;
            }

            char symbol = pickSymbol(probabilities);
            sequence.add(symbol);
        }
        return sequence;
    }

    private char pickSymbol(double[] probs) {
        double r = rand.nextDouble();
        double cum = 0.0;
        for (int i = 0; i < probs.length; i++) {
            cum += probs[i];
            if (r < cum) return ALPHABET[i];
        }
        return ALPHABET[ALPHABET.length - 1]; // fallback
    }
}
