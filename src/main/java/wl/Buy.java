package wl;


import javax.swing.*;


/**
 * MainFrame
 */
public class Buy extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Buy() {
        this.setSize(400,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(375, 100);
        this.setTitle("请支付");
        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img = new ImageIcon("src/main/images/图片1.png"); // 传入背景图片路径
        final JLabel label1 = new JLabel(img);
        getContentPane().add(label1);
        label1.setBounds(20, 20, 360, 560);

        ((JComponent) getContentPane()).setOpaque(false); // 将框架强转为容器
        final ImageIcon img5 = new ImageIcon("src/main/images/333.png"); // 传入背景图片路径
        final JLabel label5 = new JLabel(img5);
        getContentPane().add(label5);
        label5.setBounds(0, 0, 0, 0);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }
}
    
