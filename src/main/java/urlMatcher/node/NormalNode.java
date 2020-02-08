package urlMatcher.node;

import java.util.List;

public class NormalNode extends AbstractNode {

    @Override
    public AbstractNode next(char c, List<String> ids, StringBuilder stringBuilder) {
        return getNode(c);
    }
}
