package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 

public class Delete extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private final JLabel l_name1 = new JLabel("请输入要下架产品的名称:");
    private final JTextField t_name1 = new JTextField(12);

    private final JButton ok = new JButton("确定");
    private final JButton cancel = new JButton("取消");

    public Delete() {
        this.setModal(true);
        this.setSize(500, 200);
        this.setLocation(200, 200);
        this.setTitle("下架产品");
        this.setLayout(null);
        this.setFont(kaiFont);

        this.add(l_name1);
        l_name1.setFont(kaiFont);
        this.add(t_name1);
        t_name1.setFont(kaiFont);
        this.add(ok);
        ok.setFont(kaiFont);
        this.add(cancel);
        cancel.setFont(kaiFont);

        l_name1.setBounds(60, 30, 440, 30);
        t_name1.setBounds(80, 65, 380, 30);
        ok.setBounds(60, 110, 100, 40);
        cancel.setBounds(360, 110, 100, 40);


        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                Delete.this.dispose();

            }

        });

        ok.addActionListener(new ActionListener() {

            Connection con = null;
            PreparedStatement statement = null;

            @Override
            public void actionPerformed(final ActionEvent e) {

                String name = t_name1.getText();
               
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","bwwu","292504");
                    //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    statement = con.prepareStatement("delete from warehouse where goods = ?");
                    statement.setString(1, name);
                    int result = statement.executeUpdate();
                    if(result > 0){
                        JOptionPane.showMessageDialog(Delete.this, "下架成功！");
                        Delete.this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(Delete.this, "请重新确认产品名称！");
                        }
                    if(statement != null) {
                        statement.close();
                    }
                    if(con != null) {
                        con.close();
                    }
                } catch (ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(Delete.this, "驱动加载失败");
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(Delete.this, "下架失败");
                    e1.printStackTrace();
                }

            }
            
        });

    }
    
};