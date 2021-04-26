
package treatment_appointment_booking;

/**
 *
 * @author Roy
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class Login extends javax.swing.JFrame {

    File f = new File("C:\\Text File");
    int ln;
    String Username,Password,Email;
    
    public Login() {
        initComponents();
    }

    void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
    }
    
    void readFile(){
        try {
            FileReader fr = new FileReader(f+"\\logins.txt");
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f+"\\logins.txt");
                System.out.println("File created");
            } catch (IOException ex1) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    }
    
    void addData(String usr,String pswd,String mail){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            for(int i=0;i<ln;i++){
                raf.readLine();
            }
           
            if(ln>0){
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            }
            raf.writeBytes("Username:"+usr+ "\r\n");
            raf.writeBytes("Password:"+pswd+ "\r\n");
            raf.writeBytes("Email:"+mail);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   
    void logic(String usr,String pswd){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            Physician c=new Physician();
            for(int i=0;i<ln;i+=4){System.out.println("count "+i);
            
                String forUser = raf.readLine().substring(9);
                String forPswd = raf.readLine().substring(9);
                if(usr.equals(forUser) & pswd.equals(forPswd)){
                    JOptionPane.showMessageDialog(null, "password matched");
                    setVisible(false);
                    c.setVisible(true);
                    break;
                }else if(i==(ln-3)){
                    JOptionPane.showMessageDialog(null, "incorrect username/password");
                    break;
                }
               
                for(int k=1;k<=2;k++){
                    raf.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void countLines(){
        try {
            ln=0;
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            for(int i=0;raf.readLine()!=null;i++){
                ln++;
            }
            System.out.println("number of lines:"+ln);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfusr = new javax.swing.JTextField();
        tfpswd = new javax.swing.JTextField();
        tfmail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Registration & Login");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Password");

        tfusr.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        tfpswd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        tfmail.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jButton1.setText("Register");
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
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfusr)
                                    .addComponent(tfpswd)
                                    .addComponent(tfmail, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfusr, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfpswd, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfmail, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     
        createFolder(); 
    readFile();
    countLines();
    logic(tfusr.getText(), tfpswd.getText());

    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    createFolder(); 
    readFile();
    countLines();
    addData(tfusr.getText(),tfpswd.getText(),tfmail.getText());  
    JOptionPane.showMessageDialog(null,"Data Registered");       
    }                                        

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tfmail;
    private javax.swing.JTextField tfpswd;
    private javax.swing.JTextField tfusr;
                    
}

