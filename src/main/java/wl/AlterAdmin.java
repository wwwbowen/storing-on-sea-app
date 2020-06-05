package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AlterAdmin extends JDialog {

    private static final long serialVersionUID = -5116968700267175491L;

    private Font kaiFont1 = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private JLabel l_name = new JLabel("用户名:");
    private JTextField t_name = new JTextField(12);

    private JLabel l_pass = new JLabel("密  码:");
    private JPasswordField t_pass = new JPasswordField(12);

    private JLabel l_sex = new JLabel("性 别:");
    private JPasswordField t_sex = new JPasswordField(12);

    private JLabel l_age = new JLabel("年 龄:");
    private JPasswordField t_age = new JPasswordField(12);

    private JLabel l_telephone = new JLabel("电 话:");
    private JPasswordField t_telephone = new JPasswordField(12);

    private JLabel l_address = new JLabel("地 址:");
    private JPasswordField t_address = new JPasswordField(12);

    private JButton ok = new JButton("确定");
    private JButton cancel = new JButton("取消");

    public AlterAdmin() {
        this.setModal(true);
        this.setSize(400,400);
        this.setLocation(575,300);
        this.setTitle("更改管理员信息");
        this.setLayout(null);

        this.add(l_name);
        this.add(t_name);
        this.add(l_pass);
        this.add(t_pass);
        this.add(l_sex);
        this.add(t_sex);
        this.add(l_age);
        this.add(t_age);
        this.add(l_telephone);
        this.add(t_telephone);
        this.add(l_address);
        this.add(t_address);
        this.add(ok);
        this.add(cancel);

        l_name.setBounds(60, 20, 80, 30);
        l_name.setFont(kaiFont1);
        t_name.setBounds(150, 20, 160, 30);

        l_pass.setBounds(60, 80, 80, 30);
        l_pass.setFont(kaiFont1);
        t_pass.setBounds(150, 80, 160, 30);

        l_sex.setBounds(0, 50, 5, 30);
        l_sex.setFont(kaiFont1);
        t_sex.setBounds(150, 50, 160, 30);

        l_sex.setBounds(60, 180, 80, 30);
        l_sex.setFont(kaiFont1);
        t_sex.setBounds(150, 180, 160, 30);

        l_age.setBounds(60, 230, 80, 30);
        l_age.setFont(kaiFont1);
        t_age.setBounds(150, 230, 160, 30);

        l_telephone.setBounds(60, 280, 80, 30);
        l_telephone.setFont(kaiFont1);
        t_telephone.setBounds(150, 280, 160, 30);

        l_address.setBounds(60, 330, 80, 30);
        l_address.setFont(kaiFont1);
        t_address.setBounds(150, 330, 160, 30);


        ok.setBounds(100, 380, 80, 40);
        cancel.setBounds(240, 380, 80, 40);
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
                AlterAdmin.this.dispose();
            }

        });

        ok.addActionListener(new ActionListener(){

            Connection con = null;
            PreparedStatement statement = null;

            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = t_name.getText();
                String upass = new String(t_pass.getPassword());
                String sex = new String(t_sex.getPassword());
                if(uname.length() < 2) {
                    JOptionPane.showMessageDialog(AlterAdmin.this, "用户名太短！");
                    return;
                }
                if(upass.length() < 2) {
                    JOptionPane.showMessageDialog(AlterAdmin.this, "too short");
                    return;
                }
                if( !upass.equals(sex) ) {
                    JOptionPane.showMessageDialog(AlterAdmin.this, "password and confirm password should be the same");
                    return;
                }
                //后面连接数据库
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","bwwu","292504");
                    //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    statement = con.prepareStatement("insert into users values(null, ?,?, 1)");
                    statement.setString(1, uname);
                    statement.setString(2, upass);
                    int result = statement.executeUpdate();
                    if(result > 0){
                        JOptionPane.showMessageDialog(AlterAdmin.this, "添加成功！");
                        AlterAdmin.this.dispose();
                    } else {
                            JOptionPane.showMessageDialog(AlterAdmin.this, "添加失败");
                    }
                    if(statement != null) {
                        statement.close();
                    }
                    if(con != null) {
                        con.close();
                    }
                } catch (ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(AlterAdmin.this, "驱动加载失败");
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(AlterAdmin.this, "添加失败");
                    e1.printStackTrace();
                }

            }

        });

    }

}