package Trie_Tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrieTreeTest {

    private TrieTree tree;

    @Before
    public void before() {
        tree = new TrieTree();
        tree.insert("abcd");
        tree.insert("abc");
        tree.insert("abd");
        tree.insert("bcd");
        tree.insert("efg");
        tree.insert("hii");
    }

    @Test
    public void should_exist_abcd_in_tree() {
        int count = tree.search("abcd");

        assertEquals(1, count);
    }

    @Test
    public void should_return_pre_count_when_search_with_abc() {
        int count = tree.searchPrefix("abc");

        assertEquals(2, count);
    }
}