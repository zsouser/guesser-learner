
/**
 * Abstract class DecisionTreeNode - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class DecisionTreeNode extends BTNode<String>
{
    // instance variables - replace the example below with your own
    private int x;

    public DecisionTreeNode() {
        super();
    }
    
    public DecisionTreeNode(String value, DecisionTreeNode yes, DecisionTreeNode no) {
        super(value,yes,no);
    }
    
    public DecisionTreeNode getNoLink() {
        return (DecisionTreeNode)this.getLeftChild();
    }
    
    public void setNoLink(DecisionTreeNode node) {
        this.setLeftChild(node);
    }
    
    public DecisionTreeNode getYesLink() {
        return (DecisionTreeNode)this.getRightChild();
    }
    
    public void setYesLink(DecisionTreeNode node) {
        this.setRightChild(node);
    }
    
    public String getString() {
        return this.getValue();
    }
}
