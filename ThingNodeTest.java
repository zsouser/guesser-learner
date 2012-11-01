

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ThingNodeTest.
 *
 * @author  Zach Souser
 * @version 1.0
 */
public class ThingNodeTest
{
    /**
     * Only test for ThingNode
     * 
     * Functionality is very straightforward.
     * 
     * Tests the value, and whether left and right
     * children are null
     */
    @Test
    public void thingTest() {
        ThingNode tn = new ThingNode("test");
        assertEquals(tn.getValue(),"test");
        assertNull(tn.getLeftChild());
        assertNull(tn.getRightChild());
    }
}
