package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signin extends JDialog {

    private static final long serialVersionUID = -5116968700267175491L;

    private Font kaiFont1 = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private JLabel l_name = new JLabel("用户名:");
    private JTextField t_name = new JTextField(12);

    private JLabel l_pass = new JLabel("密  码:");
    private JPasswordField t_pass = new JPasswordField(12);

    private JLabel l_repass = new JLabel("确认密码");
    private JPasswordField t_repass = new JPasswordField(12);

    private JButton ok = new JButton("确定");
    private JButton cancel = new JButton("取消");

    public Signin() {
        this.setModal(true);
        this.setSize(400,300);
        this.setLocation(575, 300);
        this.setTitle("尊敬的客户，欢迎您使用海淘微客APP");
        this.setLayout(null);

        this.add(l_name);
        this.add(t_name);
        this.add(l_pass);
        this.add(t_pass);
        this.add(l_repass);
        this.add(t_repass);
        this.add(ok);
        this.add(cancel);

        l_name.setBounds(60, 20, 80, 40);
        l_name.setFont(kaiFont1);
        t_name.setBounds(150, 20, 160, 40);

        l_pass.setBounds(60, 80, 80, 40);
        l_pass.setFont(kaiFont1);
        t_pass.setBounds(150, 80, 160, 40);

        l_repass.setBounds(60, 140, 80, 40);
        l_repass.setFont(kaiFont1);
        t_repass.setBounds(150, 140, 160, 40);

        ok.setBounds(100, 200, 80, 40);
        cancel.setBounds(240, 200, 80, 40);
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
                Signin.this.dispose();
            }

        });

        ok.addActionListener(new ActionListener(){

            Connection con = null;
            PreparedStatement statement = null;

            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = t_name.getText();
                String upass = new String(t_pass.getPassword());
                String repass = new String(t_repass.getPassword());
                if(uname.length() < 1) {
                    JOptionPane.showMessageDialog(Signin.this, "用户名名称需大于两字符！");
                    return;
                }
                if(upass.length() < 1) {
                    JOptionPane.showMessageDialog(Signin.this, "密码长度需大于两字符！");
                    return;
                }
                if( !upass.equals(repass) ) {
                    JOptionPane.showMessageDialog(Signin.this, "password and confirm password should be the same");
                    return;
                }
                //后面连接数据库
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","bwwu","292504");
                    //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    statement = con.prepareStatement("insert into users values(null, ?, ?, 1, 11111, 11111 ,11111 ,11111)");
                    statement.setString(1, uname);
                    statement.setString(2, upass);
                    int result = statement.executeUpdate();
                    if(result > 0){
                        JOptionPane.showMessageDialog(Signin.this, "注册成功！");
                        Signin.this.dispose();
                    } else {
                            JOptionPane.showMessageDialog(Signin.this, "注册失败");
                    }
                    if(statement != null) {
                        statement.close();
                    }
                    if(con != null) {
                        con.close();
                    }
                } catch (ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(Signin.this, "驱动加载失败");
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(Signin.this, "添加失败!");
                    e1.printStackTrace();
                }

            }

        });

    }

}