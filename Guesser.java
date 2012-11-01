import java.io.*;
/**
 * The Guesser/Learner logic of the Decision Tree
 * 
 * @author Zach Souser
 * @version 1.0
 */
public class Guesser
{
    // The root of the Decision Tree
    private DecisionTreeNode root;
    // The user interface
    private UI ui;
    
    /** 
     * The main method - initializes the tree and ensures 
     * that the root is not null.
     * 
     * @param args The arguments passed by command line
     */
    
    public static void main(String[] args) {    
        Guesser g = new Guesser();
        if (g.root == null)
            g.root = new ThingNode(g.ui.askUser("Empty tree - name an object"));
        g.guess(null,g.root);
        g.saveTree();
    }
    
    /**
     * Constructor for class Guesser
     * 
     * Loads and unserializes the tree saved in tree.ser
     */
    
    public Guesser() {
        this.ui = new UI();
        try {
            InputStream file = new FileInputStream("tree.ser");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            try {
                this.root = (DecisionTreeNode)input.readObject();
            }
            finally { 
                input.close();
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Could not deserialize");
        } catch (IOException ex) {
            System.out.println("Could not read file");
        }
    }
    
    /**
     * Save the current tree in the tree.ser file
     */
    
    public void saveTree() {
        try {
            OutputStream file = new FileOutputStream("tree.ser");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try { output.writeObject(this.root); }
            finally { output.close(); }
        } catch (IOException ex) {
            System.err.println("Unsuccessful serialization. " + ex);
        }
    }       
    
    /**
     * Guess the current node.
     * 
     * If the node is a ThingNode, guess the node and learn a
     * new question and thing if the guess is incorrect.
     * 
     * If it is a question node, ask the question and recursively,
     * halting when a ThingNode is encountered again
     * 
     * @param parent    the QuestionNode that must point to the new question
     * @param node      the DecisionTreeNode that will be guessed and passed as the new parent
     */
    
    public void guess(DecisionTreeNode parent, DecisionTreeNode node) {
        if (node instanceof ThingNode) {
            if (ui.confirmUser("Is it a " + node + "?")) 
                ui.tellUser("I guessed it!");
            else 
                this.learn(parent,node);
            if (this.ui.confirmUser("Would you like to play again?")) 
                guess(null,this.root);
        } else if (node instanceof QuestionNode) {
            if (ui.confirmUser(node + "?")) 
                guess(node, node.getYesLink());
            else 
                guess(node, node.getNoLink());
        }
    }
    
    /**
     * Learn a new question and answer.
     * 
     * Prompts the user for the answer they were thinking, and ask them
     * for a question distinguishing it from the last node guessed.
     * 
     * Then assigns a new QuestionNode to the appropriate link from the parent
     * 
     * @param   parent  The parent DecisionTreeNode that will link to the newly learned question
     * @param   node    The DecisionTreeNode that will become the child of the newly learned question
     */
    
    public void learn(DecisionTreeNode parent, DecisionTreeNode node) {
        String answer = this.ui.askUser("What was the answer?");
        String question = this.ui.askUser("What is a question that describes " + answer + " but not " + node + "?");
        ThingNode tn = new ThingNode(answer);
        if (parent == null) {
            this.root = new QuestionNode(question,node,tn);
        } else {
            if(parent.getYesLink() == node) 
                parent.setYesLink(new QuestionNode(question,node,tn));
            else
                parent.setNoLink(new QuestionNode(question,node,tn));
        }
    }
}
