package autologout;
import java.util.*;
import org.sikuli.script.*;
import javax.swing.Timer.*;
import javax.swing.Timer;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.swing.SwingUtilities;
import java.awt.Robot.*;
import javax.swing.table.DefaultTableModel;
class Cross implements Runnable{
    private Screen screen = new Screen();
    private String imagePath;
    Cross(String imp)
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
 class CustomCheck extends javax.swing.JFrame {
       DefaultTableModel model= new DefaultTableModel(new Object[]{"Gmail", "Custom"}, 0);;
       Custom cus;
       Thread run;

    public CustomCheck() {
        initComponents();
         
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guild = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Guild Id");

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guild, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButton1)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     public static void copyClip(String textToCopy) {
        StringSelection stringSelection = new StringSelection(textToCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
     private Thread tt ;
     private boolean flag=true;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            if(flag){
                        Runnable runner = new Runnable(){
                        public void run()
                            {
                                cus = new Custom();
                                copyClip(guild.getText());
                                run = new Thread(cus);
                                System.out.println("passed");
                                run.start();
                            }
                        };
                        tt = new Thread(runner);
                        tt.setName("Gmail selector ");
                        tt.start();
                        flag=false;
                        jButton1.setText("Stop");
            }
            else{
                tt.stop();
                flag=true;
                jButton1.setText("Start");
            }
            
        }catch(Exception e){e.printStackTrace();}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
        private Region sc_gmail = new Region(588, 360, 749, 490);
        private Screen sc = new Screen();
        private String temp[]={new String(),new String()};
        public volatile ArrayList<String[]> custom = new ArrayList<>();
        private ArrayList<String> stack = new ArrayList<>();
        private String base = "C:\\Users\\duana\\OneDrive\\Documents\\NetBeansProjects\\Autologout\\src\\autologout\\";
        private ArrayList<String> que = new ArrayList<>();
        private boolean flag=true;
        Custom(){}
        public void run()
        {   
//            sc_gmail.highlight();
            while(true)
                try{
                    Thread.sleep(3000);
                    this.gmails();
                    System.out.println("progress is Starting...");
                    this.ready();
                }catch(Exception e){e.printStackTrace();}
        }

        public ArrayList<String> gmails()  
        {
    //        362,276,959,609

            ArrayList<String> arr = new ArrayList<>();
            try{
                Region sc_gmail = new Region(588, 360, 749, 490);
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
                        String qtemp = q;
                        q  = q.trim();
                        if(!this.stack.contains(q)&& Character.isLetter(q.charAt(0)))
                            {
                            try
                                {
                                Match text = sc_gmail.findText(qtemp);
                                sc_gmail.click(text);
                                Thread.sleep(1*1000);
                                String []IMAGES = {"c4.png", "confirm.png", "copy.png", "cr1.png", "cr2.png", "cr3.png", "ok.png"};
                                ArrayList<Thread> execute=new ArrayList<>();

                                 for (String imageName : IMAGES) {
                                        System.out.println(imageName);
                                        Cut task = new Cut(imageName);
                                        Thread temp = new Thread(task);
                                        execute.add(temp);
                                        temp.start();
                                }
                                System.out.println("Process is started");
                                Thread.sleep(3*1000);
                                sc.type("p");
                                Thread.sleep(30*1000);
                                for(Thread th:execute){th.stop();}
                                sc.type("p");
                                Thread.sleep(200);
                                sc.type(";");
                                this.stack.add(new String(q));
                                que.clear();
                                return;
                                }
                            catch(Exception e)
                            {e.printStackTrace();}
                                  return;
                            }
                        }
                }catch(Exception e){e.printStackTrace();}
            }
        public void waitCustom(String q)
            {
                        try
                        {
                            Screen screen = new Screen();
                            sc.type(".",KeyModifier.CTRL);
                            Pattern texter = new Pattern(base+"custom.png");
                            screen.wait(texter,60*5);
                            Region rg = new Region(1065,38,200,32);
                            String text= "";
                            System.out.println(text);
                            
                            if(text.contains("CUSTOM"))
                                {
                                    String arr[]={q,text};
                                    this.custom.add(arr);
                                    model.addRow(arr);
                                    System.out.println("Gmail "+custom.get(custom.size() - 1)[0]+" Custom"+custom.get(custom.size()- 1)[1]);
//                                    Thread.sleep(2000);
                                    
                                    sc.type("/",KeyModifier.CTRL);
                                    return ;
                                }
                                
                        }
                        catch(Exception e){e.printStackTrace();}
                try{
                    Screen screen = new Screen();
                    crop();
                    String command = "cmd /c  C:\\Users\\duana\\OneDrive\\Documents\\NetBeansProjects\\Autologout\\src\\autologout\\1.png";
                    Runtime.getRuntime().exec(command);
                    {
                        Pattern textField = new Pattern(base+"Ocr.png").similar(0.6);
                        screen.wait(textField, 30);
                        screen.click(textField);

                    }
                    {
                        Pattern textField = new Pattern(base+"copy.png").similar(0.6);
                        screen.wait(textField, 30);
                        screen.click(textField);
                    }
                    String txt[] = getClip().split("\n");
                    screen.type(Key.F4, KeyModifier.ALT);
                    System.out.println("MyOcr Result :"+txt[0]);
                    String arr[]={q,txt[0]};
                    this.custom.add(arr);
                    model.addRow(arr);
                    System.out.println("Gmail "+custom.get(custom.size() - 1)[0]+" Custom"+custom.get(custom.size()- 1)[1]);
                    Pattern texter = new Pattern(base+"custom.png");
                    screen.wait(texter,20);
                    screen.click(texter);
                    sc.type("/",KeyModifier.CTRL);
                }catch(Exception e){}
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField guild;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
