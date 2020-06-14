package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Notice extends JDialog {


    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private final JTextField aa = new JTextField(20);
    private JButton ok = new JButton("收到");

    public Notice(){

        aa.setText(StaffFrame.a);


        this.setModal(true);
        this.setSize(400,260);
        this.setLocation(300, 300);
        this.setTitle("最新公告");
        this.setLayout(null);

        this.add(aa);
        aa.setFont(kaiFont);
        this.add(ok);
        ok.setFont(kaiFont);

        aa.setBounds(10, 10, 380, 180);
        ok.setBounds(150, 200, 100, 40);

        

        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小

        

        ok.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Notice.this.dispose();
            }

        });


    }
        
    

}