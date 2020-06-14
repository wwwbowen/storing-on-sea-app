package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  

public class Insert extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private JLabel l_name1 = new JLabel("产品名称:");
    private JTextField t_name1 = new JTextField(12);

    private JLabel l_name2 = new JLabel("产品数量:");
    private JTextField t_name2 = new JTextField(12);

    private JButton ok = new JButton("确定");
    private JButton cancel = new JButton("取消");

    public Insert() {
        this.setModal(true);
        this.setSize(400,300);
        this.setLocation(200, 200);
        this.setTitle("添加产品");
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

        l_name1.setBounds(60, 30, 150, 30);
        t_name1.setBounds(170, 30, 170, 30);
        l_name2.setBounds(60, 90, 150, 30);
        t_name2.setBounds(170, 90, 170, 30);
        ok.setBounds(60, 190, 105, 40);
        cancel.setBounds(235, 190, 105, 40);

        

        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小

        cancel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Insert.this.dispose();

            }

        });

        ok.addActionListener(new ActionListener(){

            Connection con = null;
            PreparedStatement statement = null;

            @Override
            public void actionPerformed(ActionEvent e) {
                String name1 = t_name1.getText();
                String name2 = t_name2.getText();
               
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","bwwu","292504");
                    //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    statement = con.prepareStatement("insert into warehouse values(null,?,?)");
                    statement.setString(1, name1);
                    statement.setString(2, name2);
                    int result = statement.executeUpdate();
                    if(result > 0){
                        JOptionPane.showMessageDialog(Insert.this, "添加成功！");
                        Insert.this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(Insert.this, "添加失败");
                        }
                    if(statement != null) {
                        statement.close();
                    }
                    if(con != null) {
                        con.close();
                    }
                } catch (ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(Insert.this, "驱动加载失败");
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(Insert.this, "添加失败");
                    e1.printStackTrace();
                }

            }
            
        });


    }
    
};