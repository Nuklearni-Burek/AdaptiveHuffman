import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Generate the 2000-symbol sequence with changing probabilities
        SymbolGenerator generator = new SymbolGenerator();
        List<Character> sequence = generator.generate(2000);

        // Display the first 100 symbols (optional debug)
        System.out.println("Generated sequence (first 100 symbols):");
        for (int i = 0; i < 100; i++) {
            System.out.print(sequence.get(i));
        }
        System.out.println("\n");

        // Encode the sequence using adaptive Huffman coding
        Encoder encoder = new Encoder();
        List<Boolean> encodedBits = encoder.encode(sequence);

        // Calculate sizes
        int originalBits = sequence.size() * 8; // assume 8 bits per char uncompressed
        int compressedBits = encodedBits.size();

        // Print statistics
        System.out.println("Original size:   " + originalBits + " bits");
        System.out.println("Compressed size: " + compressedBits + " bits");
        System.out.printf("Compression ratio: %.2f\n", (double) originalBits / compressedBits);
    }
}
