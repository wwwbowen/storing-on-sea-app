package wl;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;





public class CheckWarehouse extends JDialog {

    private static final long serialVersionUID = -5116968700267175491L;
    JTextArea textArea = new JTextArea();
    //定义组件
    JTable jTable = null;
    JScrollPane jScrollPane = null;

    //定义JTable的对象

    // 创建JTable

    private final Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    public CheckWarehouse() {
        this.setModal(true);
        this.setSize(500,400);
        this.setLocation(200, 200);
        this.setTitle("查看仓库信息");
        this.setLayout(null);
        this.setFont(kaiFont);

        this.add(textArea);
        textArea.setFont(kaiFont);
        textArea.setBounds(20, 20, 460, 360);
        textArea.setEditable(false);


        
        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/主背景.jpg"); // 传入背景图片路径
        final JLabel background = new JLabel(img);// 将图片放进标签里
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 将标签放进容器里
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 设置标签的大小




                

        Connection con = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","bwwu","292504");
            //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");

            String sql = "select * from warehouse";     // 根据页面的数据，生成查询学生的sql语句  ******
            Statement stmt = con.createStatement();// 创建statement
            ResultSet rs = stmt.executeQuery(sql); 
            while(rs.next()){
                int Id =  rs.getInt("id");
                int Number = rs.getInt("number");
                String Cargotype = rs.getString("cargotype");
                String Price = rs.getString("price");
                String Address = rs.getString("address");
                textArea.append("仓库代号："+Id+"|"+"货物数量："+Number+"|"+"货物价值："+Price);
                textArea.append("\n");
                textArea.append("仓库位置："+Address+"|"+"仓储类型："+Cargotype);
                textArea.append("\n");
            }



        }catch(Exception e2){
            e2.printStackTrace();
        }



            

       

    }

}