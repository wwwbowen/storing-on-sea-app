package wl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteAdmin extends JDialog {

    private static final long serialVersionUID = -5116968700267175491L;

    private final Font kaiFont1 = new Font("AR PL UKai CN", Font.PLAIN, 20);

	private final JLabel l_name = new JLabel("用户名:");
	private final JTextField t_name = new JTextField(12);
	private final String[] boxOptions = { "客 户", "管理员", "职 员" };
	private final JComboBox<String> box = new JComboBox<>(boxOptions);

	private final JButton ok = new JButton("确定");
	private final JButton cancel = new JButton("取消");

	public DeleteAdmin() {
		this.setModal(true);
		this.setSize(400, 300);
		this.setLocation(575, 300);
		this.setTitle("删除管理员");
		this.setLayout(null);

		this.add(l_name);
		this.add(t_name);

		this.add(ok);
		this.add(cancel);

		this.add(box);
		box.setFont(kaiFont1);
		box.setBounds(150, 140, 100, 30);
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
				DeleteAdmin.this.dispose();
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
				final String state;
				if (box.getSelectedItem().equals("管理员")) {
					// 设置标志量的值
					state = "2";
				} else if (box.getSelectedItem().equals("职 员")) {
					state = "3";
				} else {
					state = "1";
				}

				// 后面连接数据库
				try {
					Class.forName("com.mysql.jdbc.Driver");
					// JOptionPane.showMessageDialog(DeleteAdmin.this, "驱动加载成功");
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC", "bwwu", "292504");
					// JOptionPane.showMessageDialog(DeleteAdmin.this, "数据库连接成功");

					statement1 = con.prepareStatement("select count(*) from users where user_name= ? and rid= ?");
					statement1.setString(1, uname);
					statement1.setString(2, state);
					rs = statement1.executeQuery();
					if (rs.next()) {
						final int result = rs.getInt(1);
						if (result == 1) {
							statement = con.prepareStatement("delete from users where user_name = ? and rid= ?;");
							statement.setString(1, uname);
							statement.setString(2, state);
							final int res = statement.executeUpdate();
							if (res > 0) {
								JOptionPane.showMessageDialog(DeleteAdmin.this, "删除成功！");
								DeleteAdmin.this.dispose();
							} else {
								JOptionPane.showMessageDialog(DeleteAdmin.this, "删除失败");
							}
							if (statement != null) {
								statement.close();
							}
							if (con != null) {
								con.close();
							}

						} else {
							JOptionPane.showMessageDialog(DeleteAdmin.this, "没有此用户");
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
					JOptionPane.showMessageDialog(DeleteAdmin.this, "驱动加载失败");
				} catch (final SQLException e1) {
                    JOptionPane.showMessageDialog(DeleteAdmin.this, "添加失败");
                    e1.printStackTrace();
                }

            }

        });

    }

}