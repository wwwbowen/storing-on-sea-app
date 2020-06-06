package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchResult extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private JLabel l_bb = new JLabel("产品序号:");
    private JLabel l_cc = new JLabel("产品数量:");
    private final JTextField bb = new JTextField(20);
    private final JTextField cc = new JTextField(20);

    private JButton ok = new JButton("确定");

    public SearchResult(){

        bb.setText(Search.b);
        cc.setText(Search.c);



        this.setModal(true);
        this.setSize(400,260);
        this.setLocation(300, 300);
        this.setTitle("搜索结果");
        this.setLayout(null);

        this.add(l_bb);
        l_bb.setFont(kaiFont);
        this.add(bb);
        bb.setFont(kaiFont);
        this.add(l_cc);
        l_cc.setFont(kaiFont);
        this.add(cc);
        cc.setFont(kaiFont);
        this.add(ok);
        ok.setFont(kaiFont);

        l_bb.setBounds(10, 10, 110, 30);
        bb.setBounds(120, 10, 280, 30);
        l_cc.setBounds(10, 50, 110, 30);
        cc.setBounds(120, 50, 280, 30);
        ok.setBounds(140, 220, 100, 30);

        
        ((JComponent) getContentPane()).setOpaque(false);
        final ImageIcon img = new ImageIcon("src/pic/back/2.jpg");
        final JLabel background = new JLabel(img);
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        

        ok.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                SearchResult.this.dispose();
            }

        });


    }






}