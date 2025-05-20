import java.util.*;

public class AdaptiveHuffmanTree {
    private Map<Character, AdaptiveHuffmanNode> nodes = new HashMap<>();
    private AdaptiveHuffmanNode root;

    public AdaptiveHuffmanTree() {
        root = new AdaptiveHuffmanNode('\0', 0); // NYT node initially
    }

    public List<Boolean> encode(char symbol) {
        List<Boolean> bits = new ArrayList<>();

        if (!nodes.containsKey(symbol)) {
            // Not Yet Transmitted (NYT): send code for NYT + symbol
            List<Boolean> nytCode = getCode(root);
            bits.addAll(nytCode);
            bits.addAll(toBinary(symbol));
        } else {
            bits.addAll(getCode(nodes.get(symbol)));
        }

        updateTree(symbol);
        return bits;
    }

    private List<Boolean> getCode(AdaptiveHuffmanNode node) {
        LinkedList<Boolean> code = new LinkedList<>();
        while (node != root && node.parent != null) {
            code.addFirst(node == node.parent.right);
            node = node.parent;
        }
        return code;
    }

    private List<Boolean> toBinary(char symbol) {
        List<Boolean> bits = new ArrayList<>();
        int val = symbol - 'a';
        for (int i = 2; i >= 0; i--) bits.add(((val >> i) & 1) == 1);
        return bits;
    }

    private void updateTree(char symbol) {
        AdaptiveHuffmanNode node = nodes.get(symbol);

        if (node == null) {
            AdaptiveHuffmanNode newLeaf = new AdaptiveHuffmanNode(symbol, 1);
            AdaptiveHuffmanNode newInternal = new AdaptiveHuffmanNode(root, newLeaf);
            root = newInternal;
            nodes.put(symbol, newLeaf);
        } else {
            node.weight++;
        }
        // Add balancing and sibling property updates if needed
    }

    public int getTotalBitsEncoded() {
        // Not implemented: for tracking encoded bit size.
        return -1;
    }
}
