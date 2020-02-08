package urlMatcher;

import org.junit.Assert;
import org.junit.Test;
import urlMatcher.segment.DynamicPathSegment;
import urlMatcher.segment.StaticPathSegment;

import java.util.List;

public class TrieTreeTest {

    @Test
    public void should_return_correct_ids() {
        TrieTree tree = new TrieTree();

        tree.insert(List.of(
                List.of(new StaticPathSegment("clubs"), new DynamicPathSegment(), new StaticPathSegment("persons"), new DynamicPathSegment())
        ));

        List<String> ids = tree.search("clubs/123/persons/456/");

        Assert.assertEquals(List.of("123", "456"), ids);
    }
}
