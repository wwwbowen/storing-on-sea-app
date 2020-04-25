package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Newusers extends JDialog {

    private static final long serialVersionUID = -5116968700267175491L;

    private Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private JLabel l_name = new JLabel("用户名:");
    private JTextField t_name = new JTextField(12);

    private JLabel l_pass = new JLabel("密  码:");
    private JPasswordField t_pass = new JPasswordField(12);

    private JLabel l_repass = new JLabel("确认密码");
    private JPasswordField t_repass = new JPasswordField(12);

    private JButton ok = new JButton("确定");
    private JButton cancel = new JButton("取消");

    public Newusers() {
        this.setModal(true);
        this.setSize(400,300);
        this.setLocation(300,300);
        this.setTitle("添加新用户");
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
        l_name.setFont(kaiFont);
        t_name.setBounds(150, 20, 160, 40);

        l_pass.setBounds(60, 80, 80, 40);
        l_pass.setFont(kaiFont);
        t_pass.setBounds(150, 80, 160, 40);

        l_repass.setBounds(60, 140, 80, 40);
        l_repass.setFont(kaiFont);
        t_repass.setBounds(150, 140, 160, 40);

        ok.setBounds(100, 200, 80, 40);
        cancel.setBounds(240, 200, 80, 40);
        ok.setFont(kaiFont);
        cancel.setFont(kaiFont);

        cancel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Newusers.this.dispose();
            }

        });

        
        ok.addActionListener(new ActionListener() {

            Connection con = null;
            PreparedStatement statement = null;
            PreparedStatement statement1 = null;
            ResultSet rs = null;

            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = t_name.getText();
                String upass = new String(t_pass.getPassword());
                String repass = new String(t_repass.getPassword());
                if(uname.length() < 2) {
                    JOptionPane.showMessageDialog(Newusers.this, "用户名长度需大于两字符！");
                    return;
                }
                if(upass.length() < 2) {
                    JOptionPane.showMessageDialog(Newusers.this, "密码长度必须大于两字符！");
                    return;
                }
                if( !upass.equals(repass) ) {
                    JOptionPane.showMessageDialog(Newusers.this, "password and confirm password should be the same");
                    return;
                }
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","bwwu","292504");
                    //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    statement = con.prepareStatement("select count(*) from users where user_name= ? and use_pass = ? ");
                    statement.setString(1, uname);
                    statement.setString(2, upass);
                    rs = statement.executeQuery();
                    if(rs.next()){
                        int result = rs.getInt(1);
                        if (result == 1) {
                            JOptionPane.showMessageDialog(Newusers.this, "注册失败！用户名已经被注册！");

                            Newusers.this.dispose();
                        } else {
                            
                            statement1 = con.prepareStatement("insert into users values(null,?,?) ");
                            statement1.setString(1, uname);
                            statement1.setString(2, upass);
                            int result1 = statement1.executeUpdate();
                            if(result1 > 0){
                                JOptionPane.showMessageDialog(Newusers.this, "添加成功！");
                                Newusers.this.dispose();
                            } else {
                                    JOptionPane.showMessageDialog(Newusers.this, "添加失败");
                            }
                            if(statement != null) {
                                statement.close();
                            }
                            if(con != null) {
                                con.close();
                            }

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
                    JOptionPane.showMessageDialog(Newusers.this, "失败!!!");
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(Newusers.this, "失败!!");
                    e1.printStackTrace();
                }
            }
        });
    

    }
}