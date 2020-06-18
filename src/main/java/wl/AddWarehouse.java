package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddWarehouse extends JDialog {

    private static final long serialVersionUID = -5116968700267175491L;

    private Font kaiFont1 = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private JLabel ID = new JLabel("仓库ID:");
    private JTextField t_name = new JTextField(12);

    private JLabel l_pass = new JLabel("类型:");
    private JTextField t_pass = new JTextField(12);

    private JLabel l_sex = new JLabel("数 量:");
    private JTextField t_sex = new JTextField(12);

    private JLabel l_age = new JLabel("价 值:");
    private JTextField t_age = new JTextField(12);


    private JLabel l_address = new JLabel("地 址:");
    private JTextField t_address = new JTextField(12);

    private JButton ok = new JButton("确定");
    private JButton cancel = new JButton("取消");

    public AddWarehouse() {
        this.setModal(true);
        this.setSize(400,400);
        this.setLocation(575,280);
        this.setTitle("添加仓库存储信息");
        this.setLayout(null);

        this.add(ID);
        this.add(t_name);
        this.add(l_pass);
        this.add(t_pass);
        this.add(l_sex);
        this.add(t_sex);
        this.add(l_age);
        this.add(t_age);
        this.add(l_address);
        this.add(t_address);
        this.add(ok);
        this.add(cancel);
        
        ID.setBounds(60,30, 80, 30);
        ID.setFont(kaiFont1);
        t_name.setBounds(150, 30, 160, 30);

        l_pass.setBounds(60, 80, 90, 30);
        l_pass.setFont(kaiFont1);
        t_pass.setBounds(150, 80, 160, 30);

        l_sex.setBounds(60, 130, 80, 30);
        l_sex.setFont(kaiFont1);
        t_sex.setBounds(150, 130, 160, 30);

        l_age.setBounds(60, 180, 80, 30);
        l_age.setFont(kaiFont1);
        t_age.setBounds(150, 180, 160, 30);

        l_address.setBounds(60, 230, 80, 30);
        l_address.setFont(kaiFont1);
        t_address.setBounds(150, 230, 160, 30);


        ok.setBounds(100, 330, 80, 40);
        cancel.setBounds(240, 330, 80, 40);
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
                AddWarehouse.this.dispose();
            }

        });

        ok.addActionListener(new ActionListener(){

            Connection con = null;
            PreparedStatement statement = null;

            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = t_name.getText();
                String usex = t_sex.getText();
                String uage = t_age.getText();
                String uaddress = t_address.getText();
                String upass = t_pass.getText();
                if(uname.length() < 1) {
                    JOptionPane.showMessageDialog(AddWarehouse.this, "ID不能为空！");
                    return;
                }
                if(upass.length() < 1) {
                    JOptionPane.showMessageDialog(AddWarehouse.this, "仓库储存类型不能为空");
                    return;
                }
                
                if(uage.length() < 1) {
                    JOptionPane.showMessageDialog(AddWarehouse.this, "价格栏不能为空！");
                    return;
                }
                if(uaddress.length() < 1 ) {
                    JOptionPane.showMessageDialog(AddWarehouse.this, "地址栏不能为空！");
                    return;
                }
                //后面连接数据库
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","bwwu","292504");
                    //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    statement = con.prepareStatement("insert into users values(?, ?, ?, ?, ?)");
                    statement.setString(1, uname);
                    statement.setString(5, uage);
                    statement.setString(4, usex);
                    statement.setString(3, upass);
                    statement.setString(2, uaddress);
                    int result = statement.executeUpdate();
                    if(result > 0){
                        JOptionPane.showMessageDialog(AddWarehouse.this, "添加仓库信息成功！");
                        AddWarehouse.this.dispose();
                    } else {
                            JOptionPane.showMessageDialog(AddWarehouse.this, "添加失败");
                    }
                    if(statement != null) {
                        statement.close();
                    }
                    if(con != null) {
                        con.close();
                    }
                } catch (ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(AddWarehouse.this, "驱动加载失败");
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(AddWarehouse.this, "添加失败");
                    e1.printStackTrace();
                }

            }

        });

    }
}
