package urlMatcher.node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractNode {

    private Map<Character, AbstractNode> nextNode;

    public AbstractNode() {
        this.nextNode = new HashMap<>();
    }

    public AbstractNode getNode(char c)
    {
        return nextNode.getOrDefault(c, null);
    }

    public void setNode(char c, AbstractNode node)
    {
        if (!nextNode.containsKey(c))
            nextNode.put(c, node);
    }

    public abstract AbstractNode next(char c, List<String> ids, StringBuilder stringBuilder);
}
