package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 * Login
 */

public class Login extends JFrame {


   
    /**
     * 这是一个登录窗口
     */
    private static final long serialVersionUID = 1L;
    

    private JLabel l_name = new JLabel("用户名:");
    private JTextField t_name = new JTextField(12);

    private JLabel l_pass = new JLabel("密  码:");
    private JPasswordField t_pass = new JPasswordField(12);

    private JButton ok = new JButton("确定");
    private JButton cancel = new JButton("取消");

    private Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    public Login() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(280, 200);
        this.setLocation(150, 150);
        this.setTitle("登录");
        this.setLayout(new FlowLayout());
        this.setResizable(false);

        this.add(l_name);
        l_name.setFont(kaiFont);
        this.add(t_name);
        t_name.setFont(kaiFont);
        this.add(l_pass);
        l_pass.setFont(kaiFont);
        this.add(t_pass);
        t_pass.setFont(kaiFont);

        this.add(ok);
        ok.setFont(kaiFont);
        this.add(cancel);
        cancel.setFont(kaiFont);

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });

        ok.addActionListener(new ActionListener() {

            Connection con = null;
            PreparedStatement statement = null;
            ResultSet rs = null;

            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = t_name.getText();
                String upass = new String(t_pass.getPassword());

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","bwwu","292504");
                    //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    statement = con.prepareStatement("select count(*) from users where user_name= ? and use_pass= ?");
                    statement.setString(1, uname);
                    statement.setString(2, upass);
                    rs = statement.executeQuery();
                    if(rs.next()){
                        int result = rs.getInt(1);
                        if (result == 1) {
                            JOptionPane.showMessageDialog(Login.this, "登录成功！");
                            MainFrame mainFrame = new MainFrame();
                            mainFrame.setVisible(true);
                            Login.this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(Login.this, "用户名密码错误");
                        }
                    }
                    if(rs != null) {
                        rs.close();
                    }
                    if(statement != null) {
                        statement.close();
                    }
                    if(con != null) {
                        con.close();
                    }
                } catch (ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(Login.this, "驱动加载失败");
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(Login.this, "数据库连接失败");
                    e1.printStackTrace();
                }


                // if(uname.equals("aa") && upass.equals("123")) {
                //     JOptionPane.showMessageDialog(Login.this, "登录成功");
                // } else {
                //     JOptionPane.showMessageDialog(Login.this, "用户名密码错误！");
                // }

            }
            
        });
    }

}