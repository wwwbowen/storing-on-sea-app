package wl;

import javax.swing.ImageIcon;
import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;


/**
 * Login
 */

public class Login extends JFrame {


   
    /**
     * 这是一个登录窗口
     */
    private static final long serialVersionUID = 1L;

    private final JLabel Login_title = new JLabel("欢迎使用海淘微客");
    
    private final JLabel l_name = new JLabel("用户名:");
    private final JTextField t_name = new JTextField(15);

    private final JLabel l_pass = new JLabel("密  码:");
    private final JPasswordField t_pass = new JPasswordField(15);

    private final JButton signButton = new JButton("登录");
    private final JButton logButton = new JButton("注册");
    private final JButton cancel = new JButton("取消");

    private final Font kaiFont_1 = new Font("AR PL UKai CN", Font.PLAIN, 20);
    private final Font kaiFont_2 = new Font("AR PL UKai TW MBE", Font.PLAIN, 30);
    private final String[] boxOptions = {"客 户","管理员","职 员"};
    private final JComboBox<String> box = new JComboBox<>(boxOptions);
    public static String name;
   



    
    public Login() {

        
       
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 270);
        this.setLocation(575, 300);
        this.setTitle("海淘微客");
        this.setResizable(false);
        this.setLayout(null);
    
        this.add(Login_title);
        Login_title.setFont(kaiFont_2);

        this.add(l_name);
        l_name.setFont(kaiFont_1);

        this.add(t_name);
        t_name.setFont(kaiFont_1);

        this.add(l_pass);
        l_pass.setFont(kaiFont_1);

        this.add(t_pass);
        t_pass.setFont(kaiFont_1);

        this.add(signButton);
        signButton.setFont(kaiFont_1);
        signButton.setBounds( 0, 0, 80, 40);

        this.add(cancel);
        cancel.setFont(kaiFont_1);

        this.add(box);
        box.setFont(kaiFont_1);

        this.add(logButton);
        logButton.setFont(kaiFont_1);

        Login_title.setBounds(75, 20, 300, 40);
        l_name.setBounds(80, 80, 100, 30);
        t_name.setBounds(150, 80, 170, 30);
        l_pass.setBounds(80, 120, 100, 30);
        t_pass.setBounds(150, 120, 170, 30);
        box.setBounds(150, 160, 100, 30);
        signButton.setBounds(40, 200, 80, 30);
        logButton.setBounds(160, 200, 80, 30);
        cancel.setBounds(280, 200, 80, 30);



        setVisible(true);
        ((JComponent) getContentPane()).setOpaque(false); //将框架强转为容器          
        final ImageIcon img = new ImageIcon("src/main/images/登录背景_1.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }

        });

        signButton.addActionListener(new ActionListener() {

            Connection con = null;
            PreparedStatement statement = null;
            ResultSet rs = null;

            @Override
            public void actionPerformed(final ActionEvent e) {
                final String uname = t_name.getText();
                final String upass = new String(t_pass.getPassword());
                final String state;
                if (box.getSelectedItem().equals("管理员")) {
                    // 设置标志量的值
                       state = "2";
                }
                else if (box.getSelectedItem().equals("职 员")) {
                      state = "3";
                }  
                else{
                       state = "1";

                }
                         
        
                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC", "bwwu", "292504");
                    // JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    statement = con.prepareStatement("select count(*) from users where user_name= ? and user_pass= ? and rid= ?");
                    statement.setString(1, uname);
                    statement.setString(2, upass);
                    statement.setString(3, state);
                    rs = statement.executeQuery();
                    if (rs.next()) {
                        final int result = rs.getInt(1);
                        if (result == 1) {
                            if(state == "2") {
                                JOptionPane.showMessageDialog(Login.this, "登录成功！");
                                name = uname;
                            final Administrator mainFrame = new Administrator();
                            mainFrame.setVisible(true);
                            Login.this.dispose();
                            }
                            if(state == "1"){
                                JOptionPane.showMessageDialog(Login.this, "登录成功！");
                                name = uname;
                                final CustomerFrame mainFrame3 = new CustomerFrame();
                                mainFrame3.setVisible(true);
                                Login.this.dispose();

                            }
                            if(state == "3"){
                                JOptionPane.showMessageDialog(Login.this, "登录成功！");
                                name = uname;
                                final StaffFrame mainFrame2 = new StaffFrame();
                                mainFrame2.setVisible(true);
                                Login.this.dispose();
                            }

                        } else {
                            JOptionPane.showMessageDialog(Login.this, "用户名密码错误");
                            t_name.setText("");
                            t_pass.setText("");
                        }
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (final ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(Login.this, "驱动加载失败");
                } catch (final SQLException e1) {
                    JOptionPane.showMessageDialog(Login.this, "数据库连接失败");
                    e1.printStackTrace();
                }
                
            }
            
        });
       
        logButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final Signin mainFrame = new Signin();
                mainFrame.setVisible(true);
                Login.this.dispose();
            }


            
            
        });
    }

 
}