package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;




public class AddAnnoucement extends JDialog {

    
    public String annn ;
    private static final long serialVersionUID = -5116968700267175491L;

    private final Font kaiFont1 = new Font("AR PL UKai CN", Font.PLAIN, 20);
    private final JLabel Annoucement_title = new JLabel("公告栏");
    private final JLabel l_name = new JLabel("已发布公告：");
    private final JLabel l_pass = new JLabel("发布新公告：");
    private final JTextField t_name = new JTextField(20);
   
    private final JTextField t_pass = new JTextField(20);

    private final JButton ok = new JButton("发布");
    private final JButton cancel = new JButton("取消");

    
    public AddAnnoucement() {
 
            t_name.setText( Administrator.a);
            System.out.println( Administrator.a);
    
           
    
    
        this.setModal(true);
        this.setSize(400, 270);
        this.setLocation(575, 300);
        this.setTitle("公告栏");
        this.setLayout(null);
        this.add(Annoucement_title);
        this.add(l_name);
        this.add(t_name);
        this.add(ok);
        this.add(cancel);
        this.add(t_pass);
        this.add(l_pass);

        Annoucement_title.setBounds(170, 20, 200, 40);
        Annoucement_title.setFont(kaiFont1);
        l_name.setBounds(60, 80, 150, 40);
        l_name.setFont(kaiFont1);
        t_name.setBounds(180, 80, 170, 40);
        t_name.setEditable(false);
        t_name.setFont(kaiFont1);
        l_pass.setBounds(60, 140, 150, 40);
        l_pass.setFont(kaiFont1);
        t_pass.setBounds(180, 140, 170, 40);
        l_pass.setFont(kaiFont1);  
        t_pass.setFont(kaiFont1);     
        Annoucement_title.setFont(kaiFont1);
        ok.setBounds(80, 200, 80, 40);
        cancel.setBounds(240, 200, 80, 40);
        ok.setFont(kaiFont1);
        cancel.setFont(kaiFont1);

        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小
      

    
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                AddAnnoucement.this.dispose();
            }

        });

        ok.addActionListener(new ActionListener() {

            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = null;
            PreparedStatement statement = null;

            @Override
            public void actionPerformed(final ActionEvent e) {
                final String uname = t_pass.getText();



                // 后面连接数据库

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    //JOptionPane.showMessageDialog(AddAnnoucement.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC", "bwwu", "292504");
                     //JOptionPane.showMessageDialog(AddAnnoucement.this, "数据库连接成功");

                     ps = con.prepareStatement("select * from Ann");
                     rs = ps.executeQuery();// 执行语句
                     if(rs.next()){
                        
                        rs.getString(1);                    
                         System.out.println( rs.getString(1));
                         statement = con.prepareStatement("update Ann set ann = ? where ann = ? ");
                         statement.setString(1, uname);
                         statement.setString(2,  rs.getString(1));

                         final int result = statement.executeUpdate();

                         if (result > 0) {
                             JOptionPane.showMessageDialog(AddAnnoucement.this, "发布成功！");
                             t_name.setText(uname);
                             t_pass.setText("");
                         } else {
                             JOptionPane.showMessageDialog(AddAnnoucement.this, "发布失败!");
                         }
                         if (statement != null) {
                             statement.close();
                         }
                         if (con != null) {
                             con.close();
                         }
                         rs.close();
                         ps.close();
                     }
                 } catch (final ClassNotFoundException e1) {
                     JOptionPane.showMessageDialog(AddAnnoucement.this, "驱动加载失败");
                 } catch (final SQLException e1) {
                    JOptionPane.showMessageDialog(AddAnnoucement.this, "添加失败");
                    e1.printStackTrace();
                }
            
                
            }
                     
                    
                            
                        
                        
                       
                        
                   

            
            
            
        });

    }

}