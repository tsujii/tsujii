import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sample46 extends JFrame implements ActionListener {
    JButton bt = new JButton("ファイルを開く");
    JLabel lb = new JLabel("ファイル情報表示");
    JLabel lb2 = new JLabel();
    JLabel lb3 = new JLabel();
    JPanel pn = new JPanel();
    FileDialog fd;
    Container cnt = getContentPane();

    public static void main(String args[]) {
        Sample46 sm = new Sample46();
    }

    public Sample46() {
        super("ファイルダイアログ");
        setSize(300, 200);
        pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
        cnt.setLayout(new BorderLayout());
        pn.add(lb);
        pn.add(lb2);
        pn.add(lb3);
        cnt.add(pn, BorderLayout.CENTER);
        cnt.add(bt, BorderLayout.SOUTH);
        bt.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        fd = new FileDialog(this, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        lb2.setText("ファイル名：" + fd.getFile());
        lb3.setText("パス：" + fd.getDirectory());

        try {
            FileReader fr = new FileReader(fd.getDirectory() + "/"
                    + fd.getFile());
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.exit(0);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }
}
