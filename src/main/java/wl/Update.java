package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Update extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private JLabel l_name = new JLabel("请选择要修改的产品属性:");
    private JButton name = new JButton("产品名称");
    private JButton number = new JButton("产品数量");

    public Update() {
        this.setModal(true);
        this.setSize(280,400);
        this.setLocation(200, 200);
        this.setTitle("修改产品");
        this.setLayout(null);
        this.setFont(kaiFont);
        this.setResizable(false);

        this.add(l_name);
        l_name.setFont(kaiFont);
        this.add(name);
        name.setFont(kaiFont);
        this.add(number);
        number.setFont(kaiFont);

        l_name.setBounds(20, 10, 240, 30);
        name.setBounds(20, 60, 230, 30);
        number.setBounds(20, 110, 230, 30);

        

        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小

        name.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateName().setVisible(true);

            }

        });

        number.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateNumber().setVisible(true);

            }

        });
        
    }
    
};