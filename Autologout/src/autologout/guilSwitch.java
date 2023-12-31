package autologout;
import java.util.*;
import org.sikuli.script.*;
import javax.swing.Timer.*;
import javax.swing.Timer;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.swing.SwingUtilities;
import java.awt.Robot.*;
import javax.swing.table.DefaultTableModel;
class Cr implements Runnable{
    private Screen screen = new Screen();
    private String imagePath;
    Cr(String imp)
    {   
        imagePath =imp; 
    }
    public void run()
        {
           
            Pattern pattern = new Pattern(imagePath).similar(0.7);
            while (true) {
                try {
                    System.out.println(" found");
                    if (screen.exists(pattern) != null) {
                        screen.click(pattern);
                        System.out.println(" found");
                        Thread.sleep(600);
                    }
//                    p@gmail.com
                    else System.out.println("not found "+imagePath);
                
                }catch(Exception e){ e.printStackTrace();}
            }
        }
}
 class guilSwitch extends javax.swing.JFrame {
       DefaultTableModel model= new DefaultTableModel(new Object[]{"Gmail", "Custom"}, 0);;
       Custom cus;
       Thread run;

    public CustomCheck() {
        initComponents();
         try{
            Runnable runner = new Runnable(){
                public void run()
                {
                    cus = new Custom();
                    run = new Thread(cus);
                    System.out.println("passed");
                    run.start();
                    tcustom.setModel(model);
                }
            };
            Thread runner_th = new Thread(runner);
            runner_th.setName("Gmail selector ");
            runner_th.start();
        }catch(Exception e){e.printStackTrace();}
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tcustom = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tcustom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Gmail", "Custom"
            }
        ));
        jScrollPane2.setViewportView(tcustom);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
             
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomCheck customCheck = new CustomCheck();
                customCheck.setAlwaysOnTop(true); // Ye line add karein
                customCheck.setVisible(true);
                
            }
        });
    }

    class Custom implements Runnable  {
        private Region sc_gmail = new Region(418,260,563,350);
        private Screen sc = new Screen();
        private String temp[]={new String(),new String()};
        public volatile ArrayList<String[]> custom = new ArrayList<>();
        private ArrayList<String> stack = new ArrayList<>();
        private String base = "C:\\Users\\Piyush Singh\\Documents\\GitHub\\NetBeansProjects\\Autologout\\src\\autologout\\";
        private ArrayList<String> que = new ArrayList<>();
        Custom(){}
        public void run()
        {   
            while(true)
                try{
                    Thread.sleep(3000);
                    this.gmails();
                    this.ready();
                }catch(Exception e){e.printStackTrace();}
        }

        public ArrayList<String> gmails()  
        {
    //        362,276,959,609

            ArrayList<String> arr = new ArrayList<>();
            try{
                Region sc_gmail = new Region(428,266,563,350);
//                sc.mouseMove(200,200);
                String gmail[] = sc_gmail.text().split("\n");
                que.clear();
                for(int i=0;i<gmail.length;i++)
                {
                    if(gmail[i].contains(".com"))
                    {
                        System.out.println(gmail[i]);
                        arr.add(gmail[i]);
                        que.add(gmail[i]);
                    }
                }
            }
            catch(Exception e){e.printStackTrace();}
        return arr;
        }
        public void ready()
            {
//                sc_gmail.highlight();
                try{
                    for(String q :que)
                        {
                         q  = q.trim();
                        if(!this.stack.contains(q)&& Character.isLetter(q.charAt(0)))
                            {
                            try
                                {
                                Match text = sc_gmail.findText(q);
                                sc_gmail.click(text);
                                sc_gmail.click(text);
                                Thread.sleep(1*1000);
                                String []IMAGES = {"c4.png", "confirm.png", "copy.png", "cr1.png", "cr2.png", "cr3.png", "custom.png", "ok.png"};
                                ArrayList<Thread> execute=new ArrayList<>();

                                 for (String imageName : IMAGES) {
                                        System.out.println(imageName);
                                        Cut task = new Cut(imageName);
                                        execute.add(new Thread(task));
                                        execute.get(execute.size()-1).start();
                                    }
//                          p@p.com
                                Thread.sleep(3*1000);
                                sc.type("p");
                                Thread.sleep(30*1000);
                                for(Thread th:execute){th.stop();}
                                execute.clear();
                                this.waitCustom(q);
                                this.stack.add(new String(q));
                                que.clear();
                                return;
                                }
                            catch(Exception e)
                            {e.printStackTrace();}

                            }
                        }
                    try
                        {
                            if(!que.isEmpty())
                                {
                                    try{
                                    sc_gmail.type("8",KeyModifier.CTRL);
                                    Thread.sleep(600);
                                    }catch(Exception e){e.printStackTrace();}
                                }
                        }catch(Exception e){e.printStackTrace();}
                    }catch(Exception e){e.printStackTrace();}
            }
        public void waitCustom(String q)
            {
                        try
                        {
                            Screen screen = new Screen();
                            sc.type(".",KeyModifier.CTRL);
                            
                                
                        }
                        catch(Exception e){e.printStackTrace();}
                
            }
        
         public  void  crop() {
            try {
                Screen screen = new Screen();
                Region region = new Region(1065,40,148,100);
                ScreenImage screenImage = screen.capture(region);
                String savePath = "C:\\Users\\duana\\OneDrive\\Documents\\NetBeansProjects\\Autologout\\src\\autologout\\";
    //            screenImage.save(savePath, savePath)
                screenImage.save(savePath,"1.png");
                System.out.println("Cropped image saved as: " + savePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        public  String getClip()  {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable contents = clipboard.getContents(null);
                if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                   String val=new String();
                    try{
                        val =  (String) contents.getTransferData(DataFlavor.stringFlavor);
                   }catch(Exception e){}
                   return val;
                }
                return null;
            }
    }


    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tcustom;
    // End of variables declaration                   
}
