package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainFrame
 */
public class CustomerFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JMenuBar bar = new JMenuBar();

    JMenu menu_user = new JMenu("用户      ");
    JMenuItem menu_user_exit = new JMenuItem("注销登录");
    JMenuItem menu_user_quit = new JMenuItem("退出登录");
    JMenuItem menu_user_passchange = new JMenuItem("修改密码");


    JMenu menu_goods = new JMenu("商品      ");
    JMenuItem menu_goods_search = new JMenuItem("搜索商品");


    private final Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    public CustomerFrame() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(375, 100);
        this.setJMenuBar(bar);
        this.setTitle("欢迎使用海淘微客APP");

        menu_user.setFont(kaiFont);
        bar.add(menu_user);

        menu_user_exit.setFont(kaiFont);
        menu_user.add(menu_user_exit);

        menu_user_quit.setFont(kaiFont);
        menu_user.add(menu_user_quit);
        
        menu_user_passchange.setFont(kaiFont);
        menu_user.add(menu_user_passchange);

        menu_goods.setFont(kaiFont);
        bar.add(menu_goods);

        menu_goods_search.setFont(kaiFont);
        menu_goods.add(menu_goods_search);
        
        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/施华洛世奇商品.jpg"); // 传入背景图片路径
        JLabel label1 = new JLabel(img);
        getContentPane().add(label1);
        label1.setBounds(20,20,370,270);

        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img1 = new ImageIcon("src/main/images/LV商品.jpg"); // 传入背景图片路径 
        JLabel label2 = new JLabel(img1);
        getContentPane().add(label2);
        label2.setBounds(410,20,370,270);

        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img2 = new ImageIcon("src/main/images/AJ商品.jpg"); // 传入背景图片路径 
        JLabel label3 = new JLabel(img2);
        getContentPane().add(label3);
        label3.setBounds(410,310,370,270);

        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img3 = new ImageIcon("src/main/images/222.png"); // 传入背景图片路径 
        JLabel label4 = new JLabel(img3);
        getContentPane().add(label4);
        label4.setBounds(20,310,370,270);

        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img5 = new ImageIcon("src/main/images/333.png"); // 传入背景图片路径 
        JLabel label5 = new JLabel(img5);
        getContentPane().add(label5);
        label5.setBounds(0,0,0,0);


     
    
        menu_user_exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final Login login = new Login();
                login.setVisible(true);
                CustomerFrame.this.dispose();

            }

        });

        menu_user_quit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new QuitSure().setVisible(true);
            }

        });

        menu_user_passchange.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new PassChange().setVisible(true);

            }

        });

        menu_goods_search.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new Search().setVisible(true);
			}

        });
    }
    
}