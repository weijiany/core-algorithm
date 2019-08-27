package Trie_Tree;

import lombok.Data;

@Data
public class TrieNode {

    private int count;
    private int preCount;
    private TrieNode[] nextNodes = new TrieNode[26];

    public TrieNode() {
        this.count = 0;
        this.preCount = 0;
    }

    public void countPlusOne() {
        this.count ++;
    }

    public void preCountPlusOne() {
        this.preCount++;
    }

    public TrieNode getNodeByIndex(int index) {
        return this.nextNodes[index];
    }

    public void setNodeByIndex(int index) {
        this.nextNodes[index] = new TrieNode();
    }
}
