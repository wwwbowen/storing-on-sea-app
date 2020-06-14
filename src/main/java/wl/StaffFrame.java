package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * MainFrame
 */
public class StaffFrame extends JFrame {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JMenuBar bar = new JMenuBar();

    JMenu menu_user = new JMenu("用户      ");
    JMenuItem menu_user_exit = new JMenuItem("注销登录");
    JMenuItem menu_user_quit = new JMenuItem("退出登录");
    JMenuItem menu_user_passchange = new JMenuItem("修改密码");


    JMenu menu_attendance = new JMenu("考勤      ");
    JMenuItem menu_attendance_in = new JMenuItem("签到");
    JMenuItem menu_attendance_off = new JMenuItem("签退");

    JMenu menu_notice = new JMenu("公告      ");
    JMenuItem menu_notice_see = new JMenuItem("查看公告");

    JMenu menu_warehouse = new JMenu("仓库      ");
    JMenuItem menu_warehouse_select = new JMenuItem("查看仓库");
    JMenuItem menu_warehouse_insert = new JMenuItem("添加产品");
    JMenuItem menu_warehouse_update = new JMenuItem("修改产品");
    JMenuItem menu_warehouse_delete = new JMenuItem("下架产品");

    JMenu menu_rest = new JMenu("休息      ");
    JMenuItem menu_rest_appointment = new JMenuItem("预约休息室");

    private final Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    public static String a;

    public StaffFrame() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(375, 100);
        this.setJMenuBar(bar);
        this.setTitle("职员系统");

        menu_user.setFont(kaiFont);
        bar.add(menu_user);

        menu_user_exit.setFont(kaiFont);
        menu_user.add(menu_user_exit);

        menu_user_quit.setFont(kaiFont);
        menu_user.add(menu_user_quit);

        menu_user_passchange.setFont(kaiFont);
        menu_user.add(menu_user_passchange);

        menu_attendance.setFont(kaiFont);
        bar.add(menu_attendance);

        menu_attendance_in.setFont(kaiFont);
        menu_attendance.add(menu_attendance_in);

        menu_attendance_off.setFont(kaiFont);
        menu_attendance.add(menu_attendance_off);

        menu_notice.setFont(kaiFont);
        bar.add(menu_notice);

        menu_notice_see.setFont(kaiFont);
        menu_notice.add(menu_notice_see);

        menu_warehouse.setFont(kaiFont);
        bar.add(menu_warehouse);

        menu_warehouse_select.setFont(kaiFont);
        menu_warehouse.add(menu_warehouse_select);

        menu_warehouse_insert.setFont(kaiFont);
        menu_warehouse.add(menu_warehouse_insert);

        menu_warehouse_update.setFont(kaiFont);
        menu_warehouse.add(menu_warehouse_update);

        menu_warehouse_delete.setFont(kaiFont);
        menu_warehouse.add(menu_warehouse_delete);

        menu_rest.setFont(kaiFont);
        bar.add(menu_rest);

        menu_rest_appointment.setFont(kaiFont);
        menu_rest.add(menu_rest_appointment);

        
        ((JComponent) getContentPane()).setOpaque(false);
        final ImageIcon img = new ImageIcon("src/pic/back/2.jpg");
        final JLabel background = new JLabel(img);
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        menu_user_exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final Login login = new Login();
                login.setVisible(true);
                StaffFrame.this.dispose();
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

        menu_attendance_in.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(StaffFrame.this, "签到成功！");

            }

        });

        menu_attendance_off.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(StaffFrame.this, "签退成功！");

            }

        });

        menu_notice_see.addActionListener(new ActionListener() {

            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = null;

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","sa","nicai");
                    //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    
                    ps = con.prepareStatement("select * from ann");
                    rs = ps.executeQuery();// 执行语句
                    if(rs.next()){
                       
                       a = rs.getString(1);
                   
                        
                        rs.close();
                        ps.close();
                    }
                } catch (final ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(StaffFrame.this, "驱动加载失败");
                } catch (final SQLException e1) {
                   JOptionPane.showMessageDialog(StaffFrame.this, "错误！");
                   e1.printStackTrace();
               }

                new Notice().setVisible(true);
            }

        });

        menu_warehouse_select.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

                new Select().setVisible(true); 

			}

        });

        menu_warehouse_insert.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new Insert().setVisible(true);
			}

        });

        menu_warehouse_update.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new Update().setVisible(true);
			}

        });

        menu_warehouse_delete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new Delete().setVisible(true);
			}

        });

        menu_rest_appointment.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new Rest().setVisible(true);
            }

        });
    }
    
}