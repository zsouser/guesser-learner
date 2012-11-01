
/**
 * Abstract class DecisionTreeNode - implementation of a
 * BTNode with a String as its generic paramater. Utilizes
 * the left and right children for no and yes answers, and
 * is extended by QuestionNode and ThingNode
 * 
 * @author Zach Souser
 * @version 1.0
 */
public abstract class DecisionTreeNode extends BTNode<String>
{
    /**
     * No-argument constructor
     */
    public DecisionTreeNode() {
        super();
    }
    
    /**
     * Constructor with paramaters
     * 
     * @param   value   the value of the node
     * @param   yes     the "yes" child
     * @param   no      the "no" child
     */
    
    public DecisionTreeNode(String value, DecisionTreeNode yes, DecisionTreeNode no) {
        super(value,yes,no);
    }
    
    /**
     * Accessor for the "no" link
     * 
     * @return  the DecisionTreeNode "no" link
     */
    public DecisionTreeNode getNoLink() {
        return (DecisionTreeNode)this.getLeftChild();
    }
    
    /**
     * Mutator for the "no" link
     * 
     * @param   node    The DecisionTreeNode that will be the "no" link
     */
    
    public void setNoLink(DecisionTreeNode node) {
        this.setLeftChild(node);
    }
    
    /**
     * Accessor for the "yes" link
     * 
     * @return  the DecisionTreeNode "yes" link
     */
    public DecisionTreeNode getYesLink() {
        return (DecisionTreeNode)this.getRightChild();
    }
    
    /**
     * Mutator for the "yes" link
     * 
     * @param   node    The DecisionTreeNode that will be the "yes" link
     */
    
    public void setYesLink(DecisionTreeNode node) {
        this.setRightChild(node);
    }
    
    /**
     * toString implementation for the DecisionTreeNode
     * 
     * @return  the String representation of the node
     */
    
    public String toString() {
        return "[" + this.getNoLink() + "|" + this.getValue() + "|" + this.getYesLink() + "]";
    }
}
