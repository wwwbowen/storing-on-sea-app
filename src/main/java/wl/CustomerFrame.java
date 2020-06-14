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
        this.setTitle("欢迎光临");

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
        final ImageIcon img = new ImageIcon("src/main/images/海洋动图.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小

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