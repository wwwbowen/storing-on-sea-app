package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchUsersResult extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private JLabel l_bb = new JLabel("性 别:");
    private JLabel l_cc = new JLabel("电 话:");
    private final JTextField bb = new JTextField(20);
    private final JTextField cc = new JTextField(20);

    private JButton ok = new JButton("确定");

    public SearchUsersResult(){

        bb.setText(SelectUsers.b);
        cc.setText(SelectUsers.c);



        this.setModal(true);
        this.setSize(400,260);
        this.setLocation(300, 300);
        this.setTitle("搜索结果");
        this.setLayout(null);

        this.add(l_bb);
        l_bb.setFont(kaiFont);
        this.add(bb);
        bb.setFont(kaiFont);
        bb.setEditable(false);
        this.add(l_cc);
        l_cc.setFont(kaiFont);
        this.add(cc);
        cc.setFont(kaiFont);
        cc.setEditable(false);
        this.add(ok);
        ok.setFont(kaiFont);

        l_bb.setBounds(10, 10, 110, 30);
        bb.setBounds(120, 10, 280, 30);
        l_cc.setBounds(10, 50, 110, 30);
        cc.setBounds(120, 50, 280, 30);
        ok.setBounds(140, 220, 100, 30);


        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小

        

        ok.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                SearchUsersResult.this.dispose();
            }

        });


    }






}