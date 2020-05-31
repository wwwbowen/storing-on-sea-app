package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AlterUsers extends JDialog {

    private static final long serialVersionUID = -5116968700267175491L;

    private Font kaiFont1 = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private final JLabel Login_title = new JLabel("您确定需要变更用户吗？");

    private JButton ok = new JButton("确定");
    private JButton cancel = new JButton("取消");

    public AlterUsers() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setSize(300,200);
        this.setLocation(625,300);
        this.setTitle("更换用户");
        this.setLayout(null);


        this.add(ok);
        this.add(cancel);
        this.add(Login_title);

        Login_title.setBounds(40, 40, 250, 40);
        Login_title.setFont(kaiFont1);


        ok.setBounds(40, 120, 80, 40);
        cancel.setBounds(180, 120, 80, 40);
        ok.setFont(kaiFont1);
        cancel.setFont(kaiFont1);
        
        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小


        cancel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                AlterUsers.this.dispose();
                new Administrator().setVisible(true);
            }

        });


        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                new Login().setVisible(true);
                AlterUsers.this.dispose();
            }

        });

       

    }

}