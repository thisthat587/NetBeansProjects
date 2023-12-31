package autologout;
import java.awt.Robot;
import java.util.*;
import org.sikuli.script.*;
class Automation implements Runnable{
    Screen sc = new Screen();
    ArrayList<String> stack = new ArrayList<>();
    ArrayList<String> que = new ArrayList<>();
    public void run()
    {   
        while(true)
            try{
                Thread.sleep(3000);
                this.gmails();
                this.ready();
            }catch(Exception e){}
    }
    
    public ArrayList<String> gmails()  
    {
        ArrayList<String> arr = new ArrayList<>();
        try{
            Region sc_gmail = new Region(359,244,594,389);
            String gmail[] = sc_gmail.text().split("\n");
            que.clear();
            for(int i=0;i<gmail.length;i++)
            {
                if(gmail[i].contains(".com"))
                {
                    arr.add(gmail[i]);
                    que.add(gmail[i]);
                    
                }
            }
        }
        catch(Exception e){}
    return arr;
    }
    public void ready()
        {
            Region sc_gmail = new Region(359,244,594,389);
            for(String q :que)
                {
                if(!this.stack.contains(q))
                    {
                    try
                        {
                        this.stack.add(q);
                        Match text = sc_gmail.findText(q);
                        sc_gmail.click(text);
                        this.logout();
                        System.out.println(que.get(0));
                        que.clear();
                        return;
                        }
                    catch(Exception e)
                    {}
                    
                    }
                }
            try
                {
                    if(!que.isEmpty())
                        {
                        sc_gmail.type("8",KeyModifier.CTRL);
                        Thread.sleep(600);
                        }
                }
            catch(Exception e){}
        }
    public void logout()
        {
            Region sc_signout = new Region(600,526,482,170);
            System.out.println("puch gaye hai sahi salamat");
            while (true)
                try
                    {
                    Thread.sleep(10*1000);
                    String found= sc_signout.text();
                    System.out.println("signout conatain :\n"+found);
                    if(found.contains("Signed")||found.length()==0)
                        {
                        sc.type("3",KeyModifier.CTRL);
                        System.out.println(" found exiting");
                        return;
                        }
                    else
                        {
                        System.out.println("wait signouting ");
                        sc.type("1",KeyModifier.CTRL);
                        Thread.sleep(5*1000);
                        sc.type("`",KeyModifier.CTRL);
                        Thread.sleep(2*1000);
                        System.out.println("signouting complete");
                        }
                    }
                catch(Exception e)
                    {
                        System.out.println("Error in signout \n"+e);
                    }
        }
}
public class Autologout {
    public static void main(String[] args) {
        Thread atom = new Thread(new Automation());
        atom.start();
    }
    
}
