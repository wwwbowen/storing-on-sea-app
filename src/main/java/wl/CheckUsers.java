package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;





public class CheckUsers extends JDialog {

    private static final long serialVersionUID = -5116968700267175491L;
    final String[] title = { "ID", "姓名", "密码", "职位", "性别", "年龄", "电话", "地址" };

    //定义组件
    JTable jTable = null;
    JScrollPane jScrollPane = null;

    //定义JTable的对象

    // 创建JTable

    private JScrollPane scpDemo;
    private JTable tabDemo;


    private final Font kaiFont1 = new Font("AR PL UKai CN", Font.PLAIN, 20);
    private final Font kaiFont2 = new Font("AR PL UKai CN", Font.PLAIN, 15);

    private final JLabel l_name = new JLabel("用户名:");
    private final JTextField t_name = new JTextField(12);

    private final JButton ok = new JButton("确定");
    private final JButton cancel = new JButton("取消");

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final int DEFAULE_WIDTH = 1000;
    private final int DEFAULE_HEIGH = 600;

    int Location_x = (int) (toolkit.getScreenSize().getWidth() - DEFAULE_WIDTH) / 2;
    int Location_y = (int) (toolkit.getScreenSize().getHeight() - DEFAULE_HEIGH) / 2;



    public CheckUsers() {
        this.setModal(true);
        this.setSize(400, 300);
        this.setLocation(300, 300);
        this.setTitle("查看用户信息");
        this.setLayout(null);

        this.add(scpDemo);
        this.add(l_name);
        this.add(t_name);
        this.add(ok);
        this.add(cancel);
       

        this.scpDemo.getViewport().add(tabDemo);

        l_name.setBounds(60, 20, 80, 40);
        l_name.setFont(kaiFont1);
        t_name.setBounds(150, 20, 160, 40);

        ok.setBounds(100, 200, 30, 20);
        cancel.setBounds(240, 200, 30, 20);
        ok.setFont(kaiFont2);
        cancel.setFont(kaiFont2);


        
        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                CheckUsers.this.dispose();
            }

        });

        ok.addActionListener(new ActionListener() {

            Connection con = null;
            PreparedStatement statement = null;
            ResultSet rs = null;

            @Override
            public void actionPerformed(final ActionEvent e) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC", "bwwu", "292504");
                    // JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    statement = con.prepareStatement("select * from users");
                    rs = statement.executeQuery();
                    // 计算有多少条记录
                    int count = 0;
                    while (rs.next()) {
                        count++;
                    }
                    rs = statement.executeQuery();
                    // 将查询获得的记录数据，转换成适合生成JTable的数据形式
                    final Object[][] info = new Object[count][8];
                    count = 0;
                    while (rs.next()) {
                        info[count][0] = Integer.valueOf(rs.getInt("id"));
                        info[count][1] = rs.getString("user_name");
                        info[count][2] = rs.getString("user_pass");
                        info[count][3] = Integer.valueOf(rs.getInt("rid"));
                        info[count][4] = rs.getString("sex");
                        info[count][5] = rs.getString("age");
                        info[count][6] = rs.getString("telephone");
                        info[count][7] = rs.getString("address");
                        count++;
                    }



                } catch (final ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(CheckUsers.this, "驱动加载失败");
                } catch (final SQLException e1) {
                    JOptionPane.showMessageDialog(CheckUsers.this, "添加失败");
                    e1.printStackTrace();
                }



            }

        });

    }

}