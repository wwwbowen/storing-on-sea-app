package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  

public class UpdateNumber extends JDialog{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private final JLabel l_name1 = new JLabel("请输入产品的名称:");
    private final JTextField t_name1 = new JTextField(12);
    private final JLabel l_name2 = new JLabel("请输入产品新数量:");
    private final JTextField t_name2 = new JTextField(12);

    private final JButton ok = new JButton("确定");
    private final JButton cancel = new JButton("取消");

    public UpdateNumber() {
        this.setModal(true);
        this.setSize(700, 170);
        this.setLocation(200, 200);
        this.setTitle("下架产品");
        this.setLayout(null);
        this.setFont(kaiFont);

        this.add(l_name1);
        l_name1.setFont(kaiFont);
        this.add(t_name1);
        t_name1.setFont(kaiFont);
        this.add(l_name2);
        l_name2.setFont(kaiFont);
        this.add(t_name2);
        t_name2.setFont(kaiFont);
        this.add(ok);
        ok.setFont(kaiFont);
        this.add(cancel);
        cancel.setFont(kaiFont);

        l_name1.setBounds(20, 20, 200, 30);
        t_name1.setBounds(220, 20, 460, 30);
        l_name2.setBounds(20, 60, 200, 30);
        t_name2.setBounds(220, 60, 460, 30);
        ok.setBounds(20, 110, 100, 40);
        cancel.setBounds(580, 110, 100, 40);

        
        ((JComponent) getContentPane()).setOpaque(false);
        final ImageIcon img = new ImageIcon("src/pic/back/2.jpg");
        final JLabel background = new JLabel(img);
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                UpdateNumber.this.dispose();

            }

        });

        ok.addActionListener(new ActionListener() {

            Connection con = null;
            PreparedStatement statement = null;

            @Override
            public void actionPerformed(final ActionEvent e) {

                String name1 = t_name1.getText();
                String name2 = t_name2.getText();

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","sa","nicai");
                    //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    statement = con.prepareStatement("update warehouse set number = ? where goods = ?");
                    statement.setString(1, name2);
                    statement.setString(2, name1);
                    int result = statement.executeUpdate();
                    if(result > 0){
                        JOptionPane.showMessageDialog(UpdateNumber.this, "数量修改成功！");
                        UpdateNumber.this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(UpdateNumber.this, "请重新确认产品原名称！");
                        }
                    if(statement != null) {
                        statement.close();
                    }
                    if(con != null) {
                        con.close();
                    }
                } catch (ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(UpdateNumber.this, "驱动加载失败");
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(UpdateNumber.this, "修改失败");
                    e1.printStackTrace();
                }

            }
            
        });

    }







    
}