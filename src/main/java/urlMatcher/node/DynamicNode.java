package urlMatcher.node;

import java.util.List;

/**
 * 匹配所有的 Id
 */
public class DynamicNode extends AbstractNode {

    @Override
    public AbstractNode next(char c, List<String> ids, StringBuilder stringBuilder) {
        if (c == NodeConstant.SEPARATOR)
        {
            ids.add(stringBuilder.toString());
            stringBuilder.setLength(0);
            return getNode(c);
        }

        stringBuilder.append(c);
        return this;
    }
}
