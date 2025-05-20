public class AdaptiveHuffmanNode {
    public int weight;
    public char symbol;
    public AdaptiveHuffmanNode left, right, parent;
    public boolean isLeaf;

    public AdaptiveHuffmanNode(char symbol, int weight) {
        this.symbol = symbol;
        this.weight = weight;
        this.isLeaf = true;
    }

    public AdaptiveHuffmanNode(AdaptiveHuffmanNode left, AdaptiveHuffmanNode right) {
        this.left = left;
        this.right = right;
        this.weight = left.weight + right.weight;
        this.isLeaf = false;
        left.parent = this;
        right.parent = this;
    }
}
