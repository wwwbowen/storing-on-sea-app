package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * MainFrame
 */
public class Administrator extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JMenuBar bar = new JMenuBar();

    JMenu menu_file = new JMenu("仓储管理");
    JMenuItem menu_file_1  = new JMenuItem("查看仓库信息");
    JMenuItem menu_file_2  = new JMenuItem("更改仓库信息");
    JMenuItem menu_file_3  = new JMenuItem("添加仓库信息");
    JMenuItem menu_file_4  = new JMenuItem("删除仓库信息");

    JMenu menu_user = new JMenu("用户管理");
    JMenuItem menu_user_1 = new JMenuItem("添加职员");
    JMenuItem menu_user_2 = new JMenuItem("删除职员");
    JMenuItem menu_user_3 = new JMenuItem("添加管理员");
    JMenuItem menu_user_4 = new JMenuItem("删除管理员");
    JMenuItem menu_user_5 = new JMenuItem("查找用户");
    JMenuItem menu_user_6 = new JMenuItem("更改职员信息");
    JMenuItem menu_user_7 = new JMenuItem("更改管理员信息");
    JMenuItem menu_user_8 = new JMenuItem("密码修改");
    JMenuItem menu_user_9 = new JMenuItem("更换用户");
    
    JMenu menu_Announcement = new JMenu("公告栏");
    JMenuItem menu_Announcement_1  = new JMenuItem("更改公告栏信息");

    private Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    public Administrator() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("综合管理");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(375, 100);
        this.setJMenuBar(bar);

        menu_file.setFont(kaiFont);
        bar.add(menu_file);

        menu_file_1.setFont(kaiFont);
        menu_file.add(menu_file_1);

        menu_file_2.setFont(kaiFont);
        menu_file.add(menu_file_2);

        menu_file_3.setFont(kaiFont);
        menu_file.add(menu_file_3);

        menu_file_4.setFont(kaiFont);
        menu_file.add(menu_file_4);

        menu_user.setFont(kaiFont);
        menu_user_1.setFont(kaiFont);
        menu_user_2.setFont(kaiFont);
        menu_user_3.setFont(kaiFont);
        menu_user_4.setFont(kaiFont);
        menu_user_5.setFont(kaiFont);
        menu_user_6.setFont(kaiFont);
        menu_user_7.setFont(kaiFont);
        menu_user_8.setFont(kaiFont);
        menu_user_9.setFont(kaiFont);

        bar.add(menu_user);
        menu_user.add(menu_user_1);
        menu_user.add(menu_user_2);
        menu_user.add(menu_user_3);
        menu_user.add(menu_user_4);
        menu_user.add(menu_user_5);
        menu_user.add(menu_user_6);
        menu_user.add(menu_user_7);
        menu_user.add(menu_user_8);
        menu_user.add(menu_user_9);

        menu_Announcement.setFont(kaiFont);
        bar.add(menu_Announcement);
        menu_Announcement_1.setFont(kaiFont);
        menu_Announcement.add(menu_Announcement_1);


        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });

        menu_user_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUser().setVisible(true);
            }

        });
    
    }
    
}