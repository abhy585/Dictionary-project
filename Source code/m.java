import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.LayoutManager;
import java.awt.Component;
import java.awt.Label;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.Frame;

// 
// Decompiled by Procyon v0.5.36
// 

class m extends Frame implements ActionListener
{
    TextField t1;
    TextArea t;
    Button b;
    
    m() {
        final Label l = new Label("Word");
        final Label l2 = new Label("Meaning");
        this.t1 = new TextField();
        this.t = new TextArea();
        (this.b = new Button("Add")).setBounds(100, 200, 50, 20);
        l.setBounds(50, 50, 50, 20);
        l2.setBounds(50, 100, 50, 20);
        this.t1.setBounds(100, 50, 50, 20);
        this.t.setBounds(100, 100, 100, 100);
        this.b.addActionListener(this);
        this.add(this.b);
        this.add(l);
        this.add(l2);
        this.add(this.t);
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
            System.out.println("Value deleted");
            con.close();
        }
        catch (Exception e2) {
            System.out.println(e2);
        }
    }
    
    public static void main(final String[] s) {
        new m();
    }
}
