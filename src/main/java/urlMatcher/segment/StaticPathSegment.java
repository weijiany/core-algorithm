package urlMatcher.segment;

import urlMatcher.node.AbstractNode;
import urlMatcher.node.NodeConstant;
import urlMatcher.node.NormalNode;
import urlMatcher.node.SeparatorNode;

public class StaticPathSegment implements PathSegment {

    private String path;

    public StaticPathSegment(String path) {
        this.path = path.trim().toLowerCase();
    }

    @Override
    public AbstractNode insert(AbstractNode node) {
        char[] chars = path.toCharArray();
        for (char aChar : chars) {
            if (node.getNode(aChar) == null)
                node.setNode(aChar, new NormalNode());
            node = node.getNode(aChar);
        }


        node.setNode(NodeConstant.SEPARATOR, new SeparatorNode());
        return node.getNode(NodeConstant.SEPARATOR);
    }
}
