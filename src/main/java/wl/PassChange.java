package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  

public class PassChange extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    

    private Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);


    private JLabel l_name = new JLabel("用 户 名:");
    private JTextField t_name = new JTextField(12);

    private JLabel l_pass1 = new JLabel("原 密 码:");
    private JTextField t_pass1 = new JTextField(12);

    private JLabel l_pass2 = new JLabel("新 密 码:");
    private JTextField t_pass2 = new JPasswordField(12);

    private JLabel l_pass3 =new JLabel("确认密码:");
    private JTextField t_pass3 = new JPasswordField(12);

    private JButton ok = new JButton("确定");
    private JButton cancel = new JButton("取消");


    public static String a;

    public PassChange() {
        this.setModal(true);
        this.setSize(400,260);
        this.setLocation(300, 300);
        this.setTitle("修改密码");
        this.setLayout(null);


        this.add(l_name);
        l_name.setFont(kaiFont);
        this.add(t_name);
        t_name.setFont(kaiFont);
        this.add(l_pass1);
        l_pass1.setFont(kaiFont);
        this.add(t_pass1);
        t_pass1.setFont(kaiFont);
        this.add(l_pass2);
        l_pass2.setFont(kaiFont);
        this.add(t_pass2);
        t_pass2.setFont(kaiFont);
        this.add(l_pass3);
        l_pass3.setFont(kaiFont);
        this.add(t_pass3);
        t_pass3.setFont(kaiFont);
        this.add(ok);
        ok.setFont(kaiFont);
        this.add(cancel);
        cancel.setFont(kaiFont);

        l_name.setBounds(60, 5, 150, 30);
        t_name.setBounds(170, 5, 170, 30);
        l_pass1.setBounds(60, 50, 150, 30);
        t_pass1.setBounds(170, 50, 170, 30);
        l_pass2.setBounds(60, 90, 150, 30);
        t_pass2.setBounds(170, 90, 170, 30);
        l_pass3.setBounds(60, 130, 150, 30);
        t_pass3.setBounds(170, 130, 170, 30);
        ok.setBounds(60, 190, 105, 40);
        cancel.setBounds(235, 190, 105, 40);


        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                PassChange.this.dispose();

            }

        });

        ok.addActionListener(new ActionListener(){

            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = null;


            @Override
            public void actionPerformed(ActionEvent e) {
                String n = t_name.getText();
                String p1 = t_pass1.getText();
                String p2 = t_pass2.getText();
                String p3 = t_pass3.getText();

                if(!p2.equals(p3)){
                    JOptionPane.showMessageDialog(PassChange.this, "密码不一致！");
                    return;
                }

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","bwwu","292504");
                    //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    
                    ps = con.prepareStatement("select user_pass from users where user_name = ?");
                    ps.setString(1, n);
                    rs = ps.executeQuery();// 执行语句
                    if(rs.next()){
                       a = rs.getString(1);

                        rs.close();
                        ps.close();
                    }
                }               
                  catch (final ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(PassChange.this, "驱动加载失败");
                } catch (final SQLException e1) {
                   JOptionPane.showMessageDialog(PassChange.this, "错误！");
                   e1.printStackTrace();
                }

                if(!a.equals(p1)){
                    JOptionPane.showMessageDialog(PassChange.this, "原密码不正确！");
                    return;} 
                
                    
            Connection con = null;
            PreparedStatement statement = null;
               
                 try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","sa","nicai");
                    //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    statement = con.prepareStatement("update users set user_pass = ? where user_name = ?");
                    statement.setString(1, p3);
                    statement.setString(2, n);
                    int result = statement.executeUpdate();
                    if(result > 0){
                        JOptionPane.showMessageDialog(PassChange.this, "修改成功！");
                        PassChange.this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(PassChange.this, "修改失败");
                        }
                    if(statement != null) {
                        statement.close();
                    }
                    if(con != null) {
                        con.close();
                    }
                } catch (ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(PassChange.this, "驱动加载失败");
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(PassChange.this, "错误！");
                    e1.printStackTrace();
                }
            }

            
        });

    }







    
}