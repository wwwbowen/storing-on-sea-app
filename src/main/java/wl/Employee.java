package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

 
import javax.swing.JOptionPane;

/**
 * MainFrame
 */
public class Employee extends JFrame {
   
        public String ann;



        
  
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
    JMenuItem menu_user_3 = new JMenuItem("添加管理员");
    JMenuItem menu_user_4 = new JMenuItem("删除用户");
    JMenuItem menu_user_5 = new JMenuItem("查看用户信息");
    JMenuItem menu_user_6 = new JMenuItem("更改职员信息");
    JMenuItem menu_user_7 = new JMenuItem("更改管理员信息");
    JMenuItem menu_user_8 = new JMenuItem("密码修改");
    JMenuItem menu_user_9 = new JMenuItem("更换用户");
    
    JMenu menu_Announcement = new JMenu("公告栏");
    JMenuItem menu_Announcement_1  = new JMenuItem("更改公告栏信息");

    private final Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    public static String a;


 

    public Employee() {


        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("综合管理");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(375, 100);
        this.setJMenuBar(bar);

        setVisible(true);
        ((JComponent) getContentPane()).setOpaque(false); //将框架强转为容器          
        final ImageIcon img = new ImageIcon("src/main/images/注册栏背景.gif"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小

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
        menu_user_3.setFont(kaiFont);
        menu_user_4.setFont(kaiFont);
        menu_user_5.setFont(kaiFont);
        menu_user_6.setFont(kaiFont);
        menu_user_7.setFont(kaiFont);
        menu_user_8.setFont(kaiFont);
        menu_user_9.setFont(kaiFont);

        bar.add(menu_user);
        menu_user.add(menu_user_1);
  
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
            public void actionPerformed(final ActionEvent e) {
                new AddEmployee().setVisible(true);
            }

        });


        menu_user_3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                new AddAdmin().setVisible(true);
            }

        });

        menu_user_4.addActionListener(new ActionListener() {

            

            @Override
            public void actionPerformed(final ActionEvent e) {
                new DeleteAdmin().setVisible(true);
            }

        });

        menu_user_5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                new CheckUsers().setVisible(true);
                
            }

        });

        menu_user_6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                new AlterEmployee().setVisible(true);
            }

        });

        menu_user_7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                new AlterAdmin().setVisible(true);
            }

        });

        menu_user_8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                new Alterpassword().setVisible(true);
            }

        });

        menu_user_9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                new AlterUsers().setVisible(true);
                Employee.this.dispose();
            }

        });

        menu_file_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                new CheckWarehouse().setVisible(true);
            }

        });

        menu_file_2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                new AlterWarehouse().setVisible(true);
            }

        });

        menu_file_3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                new AddWarehouse().setVisible(true);
            }

        });

        menu_file_4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                new DeleteWarehouse().setVisible(true);
            }

        });

        menu_Announcement_1.addActionListener(new ActionListener() {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = null;

              
            @Override
            public void actionPerformed(final ActionEvent e) {

                // 后面连接数据库

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    //JOptionPane.showMessageDialog(AddAnnoucement.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC", "bwwu", "292504");
                     //JOptionPane.showMessageDialog(AddAnnoucement.this, "数据库连接成功");

                     ps = con.prepareStatement("select * from Ann");
                     rs = ps.executeQuery();// 执行语句
                     if(rs.next()){
                        
                        ann=rs.getString(1);
                        System.out.println(ann);
                        a = rs.getString(1);
                    
                         
                         rs.close();
                         ps.close();
                     }
                 } catch (final ClassNotFoundException e1) {
                     JOptionPane.showMessageDialog(Employee.this, "驱动加载失败");
                 } catch (final SQLException e1) {
                    JOptionPane.showMessageDialog(Employee.this, "添加失败");
                    e1.printStackTrace();
                }
                new AddAnnoucement().setVisible(true);
            }

        });
    
    }
    
}