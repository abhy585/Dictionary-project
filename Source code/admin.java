import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.LayoutManager;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

class admin extends JFrame implements ActionListener
{
    JButton b;
    JButton b1;
    JButton b2;
    JButton b3;
    JLabel l1;
    String s1;
    String s2;
    
    public admin() {
        (this.l1 = new JLabel("What do you want to do: ")).setBounds(50, 10, 200, 20);
        (this.b = new JButton("Add Word")).setBounds(75, 50, 80, 30);
        this.b.addActionListener(this);
        (this.b1 = new JButton("Delete Word")).setBounds(75, 100, 80, 30);
        this.b1.addActionListener(this);
        (this.b2 = new JButton("Search Word")).setBounds(75, 150, 80, 30);
        this.b2.addActionListener(this);
        (this.b3 = new JButton("Update Word")).setBounds(75, 200, 80, 30);
        this.b3.addActionListener(this);
        this.add(this.b1);
        this.add(this.b2);
        this.add(this.b);
        this.add(this.l1);
        this.add(this.b3);
        this.setSize(425, 300);
        this.setLayout(null);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == this.b) {
            final insert insert = new insert();
        }
        else if (e.getSource() == this.b1) {
            final delete delete = new delete();
        }
        else if (e.getSource() == this.b2) {
            final search search = new search();
        }
        else if (e.getSource() == this.b3) {
            final update update = new update();
        }
        else {
            JOptionPane.showMessageDialog(this, "wrong");
        }
    }
    
    public static void main(final String[] args) {
        new admin();
    }
}
