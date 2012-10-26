import java.io.*;
/**
 * Write a description of class Guesser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Guesser
{
    DecisionTreeNode root;
    
    public static void main(String[] args) {
        if (args.length == 1) { // serialized file exists;
            Guesser g = new Guesser(args[0]);
        } else {
            Guesser g = new Guesser();
        }
        
    }
    
    public Guesser() {
        this.root = null;
    }
    
    public Guesser(String fileName) {
        try {
            InputStream file = new FileInputStream(fileName);
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
    
    public void saveTree(String fileName) {
        try {
            OutputStream file = new FileOutputStream(fileName);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try { output.writeObject(this.root); }
            finally { output.close(); }
        } catch (IOException ex) {
            System.err.println("Unsuccessful serialization. " + ex);
        }
    }       
        
}
