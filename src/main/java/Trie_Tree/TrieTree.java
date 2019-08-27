package Trie_Tree;

public class TrieTree {

    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    public void insert(String str) {
        if (str.isBlank())
            return;

        TrieNode root = this.root;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            // 如果分支不存在，创建一个节点
            if (root.getNodeByIndex(index) == null)
                root.setNodeByIndex(index);
            root = root.getNodeByIndex(index);
            // 以该字符开头的元素 + 1
            root.preCountPlusOne();
        }

        // 以该单词结尾的元素 + 1
        root.countPlusOne();
    }

    public int search(String str) {
        TrieNode node = serchNode(str);

        return node == null ? -1 : node.getCount();
    }

    public int searchPrefix(String str) {
        TrieNode node = serchNode(str);

        return node == null ? -1 : node.getPreCount();
    }

    private TrieNode serchNode(String str) {
        if (str.isBlank())
            return null;

        TrieNode root = this.root;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            if (root.getNodeByIndex(index) == null)
                return null;
            root = root.getNodeByIndex(index);
        }

        return root;
    }
}
