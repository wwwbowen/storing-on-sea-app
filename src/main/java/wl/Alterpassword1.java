package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Alterpassword1 extends JDialog {

    private static final long serialVersionUID = -5116968700267175491L;

    private Font kaiFont1 = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private JLabel l_name = new JLabel("原密码:");
    private JTextField t_name = new JTextField(12);

    private JLabel l_pass = new JLabel("新密码:");
    private JPasswordField t_pass = new JPasswordField(12);

    private JLabel l_repass = new JLabel("确认密码:");
    private JPasswordField t_repass = new JPasswordField(12);

    private JButton ok = new JButton("确定");
    private JButton cancel = new JButton("取消");



    public Alterpassword1() {
       
        this.setModal(true);
        this.setSize(400,300);
        this.setLocation(575,300);
        this.setTitle("更改密码");
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

        l_repass.setBounds(40, 140,100, 40);
        l_repass.setFont(kaiFont1);
        t_repass.setBounds(150, 140, 160, 40);

        ok.setBounds(100, 200, 80, 40);
        cancel.setBounds(240, 200, 80, 40);
        ok.setFont(kaiFont1);
        cancel.setFont(kaiFont1);

        ((JComponent) getContentPane()).setOpaque(false);
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); 
        final JLabel background = new JLabel(img);
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        cancel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Alterpassword1.this.dispose();
            }

        });

        ok.addActionListener(new ActionListener(){

            Connection con = null;
            PreparedStatement statement1 = null;
            PreparedStatement statement2 = null;
            ResultSet rs = null;


    
            @Override
            public void actionPerformed(ActionEvent e) {
                final String uname = t_name.getText();
                final String upass = new String(t_pass.getPassword());
                final String repass = new String(t_repass.getPassword());
              
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC", "bwwu", "292504");
                    statement1 = con.prepareStatement("select count(*) from users where user_name= ? and rid = 3 and user_pass = ?");
                    statement1.setString(1, Login.name);
                    statement1.setString(2, uname);

                   rs = statement1.executeQuery();
                   if (rs.next()) {
                    final int result = rs.getInt(1);
                    if (result == 1) {
                        
                            if(!upass.equals(repass)){JOptionPane.showMessageDialog(Alterpassword1.this, "请保证两次输入的密码相同！");}
                            else {
                            statement2 = con.prepareStatement("update users set user_pass = ? where user_name = ?  ");
                            statement2.setString(1, upass);
                            statement2.setString(2, Login.name);
                            int rss =statement2.executeUpdate();
                            if(rss >0){JOptionPane.showMessageDialog(Alterpassword1.this, "修改成功！");
                            t_name.setText("");
                            t_pass.setText("");
                            t_repass.setText("");
                            }
                            
                        }

                            
                    } else {
                        JOptionPane.showMessageDialog(Alterpassword1.this, "原密码错误！");
                        t_name.setText("");
                        t_pass.setText("");
                        t_repass.setText("");
                    }
                }
                if (rs != null) {
                    rs.close();
                }

                    if (statement1 != null) {
                        statement1.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                    statement2.close();


                } catch (ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(Alterpassword1.this, "驱动加载失败");
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(Alterpassword1.this, "添加失败");
                    e1.printStackTrace();
                }
            
            }

               
        });

    }

}