package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  

public class Search extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = -5116968700267175491L;

    private final Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 30);

    private final JLabel l_name = new JLabel("请输入商品名称:");
    private final JTextField t_name = new JTextField(30);

    private final JButton ok = new JButton("搜索");
    private final JButton cancel = new JButton("取消");

    public static String b;
    public static String c;


    public Search() {
        this.setModal(true);
        this.setSize(400, 160);
        this.setLocation(300, 300);
        this.setTitle("欢迎光临—商品搜索");
        this.setLayout(null);

        this.add(l_name);
        l_name.setFont(kaiFont);
        this.add(t_name);
        t_name.setFont(kaiFont);
        this.add(ok);
        ok.setFont(kaiFont);
        this.add(cancel);
        cancel.setFont(kaiFont);

        l_name.setBounds(20, 5, 380, 35);
        t_name.setBounds(20, 40, 320, 30);
        ok.setBounds(20, 100, 105, 40);
        cancel.setBounds(235, 100, 105, 40);


        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                Search.this.dispose();

            }

        });

        ok.addActionListener(new ActionListener() {

            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = null;

            @Override
            public void actionPerformed(ActionEvent e) {

                String l1 = t_name.getText();

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","sa","nicai");
                    //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    
                    ps = con.prepareStatement("select id from warehouse where goods= ?");
                    ps.setString(1, l1);
                    
                    rs = ps.executeQuery();// 执行语句
                    if(rs.next()){
                       b = rs.getString(1);
                   
                        
                        rs.close();
                        ps.close();
                    }
                } catch (final ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(Search.this, "驱动加载失败");
                } catch (final SQLException e1) {
                   JOptionPane.showMessageDialog(Search.this, "错误！");
                   e1.printStackTrace();
               }

               try {
                Class.forName("com.mysql.jdbc.Driver");
                // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","sa","nicai");
                //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                
                ps = con.prepareStatement("select number from warehouse where goods= ?");
                ps.setString(1, l1);
                
                rs = ps.executeQuery();// 执行语句
                if(rs.next()){
                   c = rs.getString(1);
               
                    
                    rs.close();
                    ps.close();
                }
            } catch (final ClassNotFoundException e1) {
                JOptionPane.showMessageDialog(Search.this, "驱动加载失败");
            } catch (final SQLException e1) {
               JOptionPane.showMessageDialog(Search.this, "错误！");
               e1.printStackTrace();
           }





                new SearchResult().setVisible(true);
            }


        });






    }

}