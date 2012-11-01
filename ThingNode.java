
/**
 * ThingNode - a DecisionTreeNode with no children and a value
 * that represents the answer
 * 
 * @author Zach Souser
 * @version 1.0
 */
public class ThingNode extends DecisionTreeNode
{
   
    /**
     * Constructor for objects of class ThingNode
     * 
     * Calls the parent constructor with null children
     */
    public ThingNode(String thing)
    {
        super(thing,null,null);
    }

    /**
     * Get the thing represented by this node
     * 
     * @return     The value fo the node
     */
    public String getThing() {
        return this.getValue();
    }
    
    /**
     * toString implementation for the ThingNode
     * 
     * @return  The String answer for this node
     */
    
    public String toString() {
        return this.getValue();
    }
}
