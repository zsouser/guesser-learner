

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class QuestionNodeTest.
 *
 * Since DecisionTreeNode cannot be instantiated, much of the testing
 * for its functionality occurs here.
 * 
 * @author  Zach Souser
 * @version 1.0
 */
public class QuestionNodeTest
{
    /**
     * Test the getQuestion functionality. 
     * 
     * Since getQuestion overwrites getValue, this tests getValue
     * from DecisionTreeNode as well.
     */
    
    @Test
    public void getQuestionTest() {
        QuestionNode qn = new QuestionNode("test",null,null);
        assertEquals(qn.getQuestion(),"test");
    }
    
    /**
     * Test the LinkTest functionality.
     * 
     * Both yes and no links are tested, and since DecisionTreeNode's
     * getLeftChild and getRightChild are overwritten by these methods 
     * they are tested as well
     */
    
    @Test
    public void getLinkTest() {
        QuestionNode yes = new QuestionNode("yes",null,null);
        QuestionNode no = new QuestionNode("no",null,null);
        QuestionNode qn = new QuestionNode("?",no,yes);
        assertEquals(yes,qn.getYesLink());
        assertEquals(no,qn.getNoLink());
    }
}
