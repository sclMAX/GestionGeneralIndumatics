package max.servidor.guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;

public class frmServidor_Opciones extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmServidor_Opciones dialog = new frmServidor_Opciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmServidor_Opciones() {
		setTitle("Servidor - Opciones");
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmServidor_Opciones.class.getResource("/max/recursos/iconos/logoServidor_on_16x16.gif")));
		setBounds(100, 100, 422, 413);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(100, 149, 237));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(null, "Base de Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(null, "Puerto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setOpaque(false);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
		);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(8080), null, null, new Integer(1)));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(246, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(frmServidor_Opciones.class.getResource("/max/recursos/iconos/options_24x24.gif")));
		btnNewButton.setBorder(null);
		btnNewButton.setFocusPainted(false);
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
				.addComponent(textField, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(70, 130, 180));
			buttonPane.setBorder(null);
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.RIGHT);
			fl_buttonPane.setVgap(0);
			fl_buttonPane.setHgap(0);
			buttonPane.setLayout(fl_buttonPane);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JToolBar toolBar = new JToolBar();
				toolBar.setBorderPainted(false);
				toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
				toolBar.setOpaque(false);
				toolBar.setRollover(true);
				toolBar.setFloatable(false);
				buttonPane.add(toolBar);
				{
					JButton okButton = new JButton("");
					okButton.setIcon(new ImageIcon(frmServidor_Opciones.class.getResource("/max/recursos/iconos/btn_ok_32x32.gif")));
					okButton.setOpaque(false);
					okButton.setBackground(Color.LIGHT_GRAY);
					toolBar.add(okButton);
					okButton.setActionCommand("OK");
					getRootPane().setDefaultButton(okButton);
				}
				{
					JPanel panel = new JPanel();
					panel.setBorder(null);
					panel.setOpaque(false);
					toolBar.add(panel);
				}
				{
					JSeparator separator = new JSeparator();
					separator.setPreferredSize(new Dimension(0, 10));
					separator.setSize(new Dimension(0, 5));
					toolBar.add(separator);
				}
				{
					JButton cancelButton = new JButton("");
					cancelButton.setIcon(new ImageIcon(frmServidor_Opciones.class.getResource("/max/recursos/iconos/btn_cancel_32x32.gif")));
					cancelButton.setOpaque(false);
					toolBar.add(cancelButton);
					cancelButton.setActionCommand("");
				}
			}
		}
	}
}
