package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JDialog;

public class QuitSure extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JLabel l1 = new JLabel("您确定要退出吗？");
    private JButton ok = new JButton("确定");
    private JButton cancel = new JButton("取消");

    private Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    public QuitSure() {
        super();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(200, 80);
        this.setLocation(150, 150);
        this.setTitle("退出确认！");
        this.setLayout(new FlowLayout());
        this.setResizable(false);

        this.add(l1);
        l1.setFont(kaiFont);
        this.add(ok);
        ok.setFont(kaiFont);
        this.add(cancel);
        cancel.setFont(kaiFont);

        

        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小

        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                QuitSure.this.dispose();
            }

        });
    }

}