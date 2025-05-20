import java.util.*;

public class Encoder {
    private AdaptiveHuffmanTree tree = new AdaptiveHuffmanTree();

    public List<Boolean> encode(List<Character> sequence) {
        List<Boolean> encoded = new ArrayList<>();
        int count = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : sequence) {
            encoded.addAll(tree.encode(c));

            // Adapt every 100 symbols
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if (++count % 100 == 0) {
                freq.clear();
            }
        }
        return encoded;
    }


}
