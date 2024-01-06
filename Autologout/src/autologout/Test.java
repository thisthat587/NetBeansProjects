/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autologout;
import org.sikuli.script.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.*;
class Cut implements Runnable{
    private String imagePath;
    private String BASE_PATH = "C:\\Users\\Piyush Singh\\Documents\\GitHub\\NetBeansProjects\\Autologout\\src\\autologout\\";

    Cut(String imp)
    {   
        imagePath =BASE_PATH+imp; 
    }
    public void run()
        {
            try{
                Screen screen = new Screen();
                Pattern pattern = new Pattern(imagePath).similar(0.76);
                while (true) {
                    try {

                        if (screen.exists(pattern) != null) {
                            screen.click(pattern);
                        }
                        else System.out.println("not found "+imagePath);
                    } catch (FindFailed e) {
                        e.printStackTrace();
                    }catch(Exception e){ e.printStackTrace();}
                }
            }catch(Exception e){}
        }
}
public class Test {
    private static final String[] IMAGES = {"c4.png", "confirm.png", "copy.png", "cr1.png", "cr2.png", "cr3.png", "custom.png", "ok.png"
    };

    public static void main(String[] args) {
        try{
            Region region = new Region(588, 360, 749, 490);

            // Capture the text in the specified region
            region.highlight();
            Thread.sleep(2000);
            String text = region.text();
            System.out.println("Captured Text: " + text);
            // Try to find the text with adjusted sensitivity
            Match match = region.findText("ncemdmbsbbsjd@gmail.com");

            // Check if the text was found
            if (match != null) {
                System.out.println("Found Text: " + match.text());

                // Click on the found text
                region.click(match);
                Thread.sleep(3000);
            } else {
                System.err.println("Text not found.");
            }
        } catch (FindFailed | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
   
    }

}