import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.LayoutManager;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

class delete extends JFrame implements ActionListener
{
    JTextField t1;
    JButton b;
    
    delete() {
        final JLabel l = new JLabel("Word");
        this.t1 = new JTextField();
        (this.b = new JButton("Delete")).setBounds(100, 200, 100, 20);
        l.setBounds(50, 50, 50, 20);
        this.t1.setBounds(100, 50, 50, 20);
        this.b.addActionListener(this);
        this.add(this.b);
        this.add(l);
        this.add(this.t1);
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(300, 300);
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final String s = this.t1.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anurag", "root", "root123");
            final Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from info where word='" + s + "'");
            JOptionPane.showMessageDialog(this, "Value deleted....");
            con.close();
        }
        catch (Exception e2) {
            System.out.println(e2);
        }
    }
    
    public static void main(final String[] s) {
        new delete();
    }
}
