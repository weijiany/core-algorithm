package urlMatcher.node;

import java.util.List;

/**
 * 匹配所有的 '/'
 */
public class SeparatorNode extends AbstractNode {

    @Override
    public AbstractNode next(char c, List<String> ids, StringBuilder stringBuilder) {
        var nextNode = getNode(NodeConstant.WILDCARD);
        if (nextNode == null)
            return getNode(c);

        stringBuilder.append(c);
        return nextNode;
    }
}
