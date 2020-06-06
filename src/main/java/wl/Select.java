package wl;

import javax.swing.*;
import java.awt.*;
import java.sql.*;  


public class Select extends JDialog {

    JTextArea textArea = new JTextArea();


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    public Select() {
        this.setModal(true);
        this.setSize(500,400);
        this.setLocation(200, 200);
        this.setTitle("仓库信息");
        this.setLayout(null);
        this.setFont(kaiFont);

        this.add(textArea);
        textArea.setFont(kaiFont);

        textArea.setBounds(20, 20, 460, 360);

        
        ((JComponent) getContentPane()).setOpaque(false);
        final ImageIcon img = new ImageIcon("src/pic/back/2.jpg");
        final JLabel background = new JLabel(img);
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());




        Connection con = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","sa","nicai");
            //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");

            String sql = "select * from warehouse";     // 根据页面的数据，生成查询学生的sql语句  ******
            Statement stmt = con.createStatement();// 创建statement
            ResultSet rs = stmt.executeQuery(sql); 
            while(rs.next()){
                int Id = rs.getInt("id");
                String Goods = rs.getString("goods");
                int Number = rs.getInt("number");
                textArea.append("产品序号："+Id+"||"+"产品名称："+Goods+"||"+"产品数量："+Number);
                textArea.append("\n");

            }



        }catch(Exception e2){
            e2.printStackTrace();
        }


    }
    
};