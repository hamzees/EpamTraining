package by.skakun.textparser.main;

import by.skakun.textparser.entity.Text;
import by.skakun.textparser.logic.Scanner;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apple
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String textForParsing = null;
        Text text = null;
        try {
            textForParsing = Scanner.readFile().trim().replaceAll("\t", " ").replaceAll(" +", " ");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
