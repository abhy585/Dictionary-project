import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.LayoutManager;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

class insert extends JFrame implements ActionListener
{
    JTextField t1;
    JTextArea t;
    JButton b;
    
    insert() {
        final JLabel l = new JLabel("Word");
        final JLabel l2 = new JLabel("Meaning");
        l2.setBounds(50, 100, 50, 20);
        this.t1 = new JTextField();
        (this.t = new JTextArea()).setBounds(100, 100, 100, 100);
        (this.b = new JButton("Add")).setBounds(100, 200, 100, 20);
        l.setBounds(50, 50, 50, 20);
        this.t1.setBounds(100, 50, 50, 20);
        this.b.addActionListener(this);
        this.add(this.b);
        this.add(l);
        this.add(this.t1);
        this.add(this.t);
        this.add(l2);
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(300, 300);
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final String s = this.t1.getText();
        final String s2 = this.t.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anurag", "root", "root123");
            final Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into info values('" + s + "','" + s2 + "')");
            JOptionPane.showMessageDialog(this, "Value Inserted....");
            con.close();
        }
        catch (Exception e2) {
            System.out.println(e2);
        }
    }
    
    public static void main(final String[] s) {
        new insert();
    }
}
