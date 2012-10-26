
/**
 * Write a description of class QuestionNode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuestionNode extends DecisionTreeNode
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class QuestionNode
     */
    public QuestionNode(String question, DecisionTreeNode noAnswer, DecisionTreeNode yesAnswer) {
        super(question,noAnswer,yesAnswer);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getQuestion() {
        return this.getValue();
    }
    
    public String toString() {
        return this.getValue();
    }
}
