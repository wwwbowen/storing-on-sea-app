package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteWarehouse extends JDialog {

    private static final long serialVersionUID = -5116968700267175491L;

    private final Font kaiFont1 = new Font("AR PL UKai CN", Font.PLAIN, 20);

	private final JLabel l_name = new JLabel("仓库ID:");
	private final JTextField t_name = new JTextField(12);

	private final JButton ok = new JButton("删除");
	private final JButton cancel = new JButton("取消");

	public DeleteWarehouse() {
		this.setModal(true);
		this.setSize(400, 300);
		this.setLocation(575, 300);
		this.setTitle("删除仓库");
		this.setLayout(null);

		this.add(l_name);
		this.add(t_name);

		this.add(ok);
		this.add(cancel);


		l_name.setBounds(60, 60, 80, 40);
		l_name.setFont(kaiFont1);
		t_name.setBounds(150, 60, 160, 40);

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
				DeleteWarehouse.this.dispose();
			}

		});

		ok.addActionListener(new ActionListener() {

			Connection con = null;
			PreparedStatement statement = null;
			PreparedStatement statement1 = null;
			ResultSet rs = null;

			@Override
			public void actionPerformed(final ActionEvent e) {
				final String uname = t_name.getText();
				// 后面连接数据库
				try {
					Class.forName("com.mysql.jdbc.Driver");
					// JOptionPane.showMessageDialog(DeleteWarehouse.this, "驱动加载成功");
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC", "bwwu", "292504");
					// JOptionPane.showMessageDialog(DeleteWarehouse.this, "数据库连接成功");

					statement1 = con.prepareStatement("select count(*) from warehouse where id = ? ");
					statement1.setString(1, uname);
					rs = statement1.executeQuery();
					if (rs.next()) {
						final int result = rs.getInt(1);
						if (result == 1) {
							statement = con.prepareStatement("delete from warehouse where id = ? ");
							statement.setString(1, uname);
							final int res = statement.executeUpdate();
							if (res > 0) {
								JOptionPane.showMessageDialog(DeleteWarehouse.this, "删除成功！");
								DeleteWarehouse.this.dispose();
							} else {
								JOptionPane.showMessageDialog(DeleteWarehouse.this, "删除失败");
							}
							if (statement != null) {
								statement.close();
							}
							if (con != null) {
								con.close();
							}

						} else {
							JOptionPane.showMessageDialog(DeleteWarehouse.this, "没有此仓库");
							t_name.setText("");
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
					JOptionPane.showMessageDialog(DeleteWarehouse.this, "驱动加载失败");
				} catch (final SQLException e1) {
                    JOptionPane.showMessageDialog(DeleteWarehouse.this, "添加失败");
                    e1.printStackTrace();
                }

            }

        });

    }

}