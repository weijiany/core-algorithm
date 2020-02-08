package urlMatcher;

import urlMatcher.node.AbstractNode;
import urlMatcher.node.NormalNode;
import urlMatcher.segment.PathSegment;

import java.util.ArrayList;
import java.util.List;

public class TrieTree {

    private AbstractNode root = new NormalNode();

    public void insert(List<List<PathSegment>> linkPattern) {
        for (List<PathSegment> links : linkPattern) {
            AbstractNode current = root;
            for (PathSegment pathSegment : links) {
                current = pathSegment.insert(current);
            }
        }
    }

    public List<String> search(String url) {
        var current = root;
        var ids = new ArrayList<String>();
        var idBuilder = new StringBuilder();

        for (char c : url.toCharArray()) {
            current = current.next(c, ids, idBuilder);
            if (current == null)
                break;
        }

        return ids;
    }
}
