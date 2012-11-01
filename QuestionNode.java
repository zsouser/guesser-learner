
/**
 * QuestionNode - a DecisionTreeNode that has a question 
 * and possible ThingNode answers.
 * 
 * @author Zach Souser
 * @version 1.0
 */
public class QuestionNode extends DecisionTreeNode
{
    /**
     * Constructor for objects of class QuestionNode.
     * Calls the parent constructor
     * 
     * @param   question    The text of the question
     * @param   noAnswer    The DecisionTreeNode of the no answer
     * @param   yesAnswer   The DecisionTreeNode of the yes answer
     */
    
    public QuestionNode(String question, DecisionTreeNode noAnswer, DecisionTreeNode yesAnswer) {
        super(question,noAnswer,yesAnswer);
    }

    /**
     * Accessor method for the question
     * 
     * @return  The question for this node
     */
    public String getQuestion() {
        return this.getValue();
    }
    
    /**
     * toString implementation
     * 
     * @return  The string for a QuestionNode
     */
    
    public String toString() {
        return this.getValue();
    }
}
