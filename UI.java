import javax.swing.*;

/**
 * UI Class - implementation of JOptionPane
 * 
 * @author Zach Souser
 * @version 1.0
 */
public class UI extends JOptionPane
{
    // instance variables - replace the example below with your own
    private int x;
    
    /**
     * Constructor for objects of class HangmanGUI
     */
    public UI()
    {
        super();
        setSize(400,100);
    }

    /**
     * Ask the user a question
     * 
     * @param  question the question
     * @return the string submitted by the user 
     */
    public String askUser(String question)
    {
       String answer = showInputDialog(this,question);
       if (answer == null) System.exit(1);
       if(answer.isEmpty()) return askUser(question);
       return answer;
    }
    
    /**
     * Confirm something from the user
     * 
     * @param question The question asked
     * @return the true/false yes/no response
     */
    public boolean confirmUser(String question) {
        return showConfirmDialog(this,question) == 0;
    } 
    
    /**
     * Tell the user something
     * 
     * @param message The message to be passed to the user
     */
    
    public void tellUser(String message) {
        showMessageDialog(this, message);
    }
}
