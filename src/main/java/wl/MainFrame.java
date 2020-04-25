package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * MainFrame
 */
public class MainFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JMenuBar bar = new JMenuBar();

    JMenu menu_file = new JMenu("文件");
    JMenuItem menu_file_new  = new JMenuItem("新建");

    JMenu menu_user = new JMenu("用户管理");
    JMenuItem menu_user_new = new JMenuItem("添加用户");

    private Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    public MainFrame() {
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(50, 50);
        this.setJMenuBar(bar);

        menu_file.setFont(kaiFont);
        bar.add(menu_file);

        menu_file_new.setFont(kaiFont);
        menu_file.add(menu_file_new);

        menu_user.setFont(kaiFont);
        menu_user_new.setFont(kaiFont);
        bar.add(menu_user);
        menu_user.add(menu_user_new);

        menu_user_new.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Newusers().setVisible(true);
            }

        });
    
    }
    
}