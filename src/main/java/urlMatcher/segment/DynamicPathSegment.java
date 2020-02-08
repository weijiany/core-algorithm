package urlMatcher.segment;

import urlMatcher.node.AbstractNode;
import urlMatcher.node.DynamicNode;
import urlMatcher.node.NodeConstant;
import urlMatcher.node.SeparatorNode;

public class DynamicPathSegment implements PathSegment {

    @Override
    public AbstractNode insert(AbstractNode node) {
        node.setNode(NodeConstant.WILDCARD, new DynamicNode());
        node = node.getNode(NodeConstant.WILDCARD);
        node.setNode(NodeConstant.SEPARATOR, new SeparatorNode());
        return node.getNode(NodeConstant.SEPARATOR);
    }
}
