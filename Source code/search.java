import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.LayoutManager;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

class search extends JFrame implements ActionListener
{
    JTextField t1;
    final JLabel l1;
    JButton b;
    
    search() {
        (this.l1 = new JLabel()).setBounds(120, 100, 200, 20);
        final JLabel l2 = new JLabel("Meaning");
        l2.setBounds(50, 100, 100, 20);
        final JLabel i = new JLabel("Word");
        this.t1 = new JTextField();
        (this.b = new JButton("Search")).setBounds(100, 200, 100, 20);
        i.setBounds(50, 50, 50, 20);
        this.t1.setBounds(120, 50, 50, 20);
        this.b.addActionListener(this);
        this.add(this.b);
        this.add(i);
        this.add(this.l1);
        this.add(l2);
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
            final ResultSet rs = stmt.executeQuery("select * from info where word='" + s + "'");
            while (rs.next()) {
                this.l1.setText(rs.getString(2));
            }
            con.close();
        }
        catch (Exception e2) {
            System.out.println(e2);
        }
    }
    
    public static void main(final String[] s) {
        new search();
    }
}
