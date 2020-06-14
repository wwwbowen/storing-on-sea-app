package wl;

import javax.swing.*;
import java.awt.*;

public class Rest extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private final JLabel tip = new JLabel("欢迎使用休息室，请选择座位号:");

    private final JButton seat1 = new JButton("1");
    private final JButton seat2 = new JButton("2");
    private final JButton seat3 = new JButton("3");
    private final JButton seat4 = new JButton("4");
    private final JButton seat5 = new JButton("5");
    private final JButton seat6 = new JButton("6");
    private final JButton seat7 = new JButton("7");
    private final JButton seat8 = new JButton("8");
    private final JButton seat9 = new JButton("9");
    private final JButton seat10 = new JButton("10");

    public Rest(){
        this.setModal(true);
        this.setSize(450,200);
        this.setLocation(200, 200);
        this.setTitle("预约休息室");
        this.setLayout(null);

        this.add(tip);
        tip.setFont(kaiFont);

        this.add(seat1);
        seat1.setFont(kaiFont);
        this.add(seat2);
        seat2.setFont(kaiFont);
        this.add(seat3);
        seat3.setFont(kaiFont);
        this.add(seat4);
        seat4.setFont(kaiFont);
        this.add(seat5);
        seat5.setFont(kaiFont);
        this.add(seat6);
        seat6.setFont(kaiFont);
        this.add(seat7);
        seat7.setFont(kaiFont);
        this.add(seat8);
        seat8.setFont(kaiFont);
        this.add(seat9);
        seat9.setFont(kaiFont);
        this.add(seat10);
        seat10.setFont(kaiFont);

        tip.setBounds(5, 30, 300, 30);
        seat1.setBounds(25, 112, 60, 25);
        seat2.setBounds(110, 112, 60, 25);
        seat3.setBounds(195, 112, 60, 25);
        seat4.setBounds(280, 112, 60, 25);
        seat5.setBounds(365, 112, 60, 25);
        seat6.setBounds(25, 162, 60, 25);
        seat7.setBounds(110, 162, 60, 25);
        seat8.setBounds(195, 162, 60, 25);
        seat9.setBounds(280, 162, 60, 25);
        seat10.setBounds(365, 162, 60, 25);

        

        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小
        
    }
    
}