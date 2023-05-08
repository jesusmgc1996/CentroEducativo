package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MateriaController;
import controller.ProfesorController;
import model.Materia;
import model.Profesor;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JListPanel jl = new JListPanel();
	private JComboBox<Materia> jcbSubject;
	private JComboBox<Profesor> jcbProfessor;
	private JComboBox jcbNote;
	private JButton btnUpdate;
	private JButton btnSave;
	private JLabel lblNewLabel_2;

	/**
	 * Carga la aplicación
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0};
//		gbl_contentPane.rowWeights = new double[]{0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		jcbSubject = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbSubject = new GridBagConstraints();
		gbc_jcbSubject.weightx = 1.0;
		gbc_jcbSubject.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSubject.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSubject.gridx = 1;
		gbc_jcbSubject.gridy = 0;
		contentPane.add(jcbSubject, gbc_jcbSubject);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfessor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfessor = new GridBagConstraints();
		gbc_jcbProfessor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfessor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfessor.gridx = 1;
		gbc_jcbProfessor.gridy = 1;
		contentPane.add(jcbProfessor, gbc_jcbProfessor);
		
		lblNewLabel_2 = new JLabel("Nota:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbNote = new JComboBox();
		jcbNote.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		GridBagConstraints gbc_jcbNote = new GridBagConstraints();
		gbc_jcbNote.insets = new Insets(0, 0, 5, 5);
		gbc_jcbNote.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNote.gridx = 1;
		gbc_jcbNote.gridy = 2;
		contentPane.add(jcbNote, gbc_jcbNote);
		
		btnUpdate = new JButton("Actualizar alumnado");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jl.deleteAll();
			}
		});
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.anchor = GridBagConstraints.EAST;
		gbc_btnUpdate.gridwidth = 2;
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.gridx = 0;
		gbc_btnUpdate.gridy = 3;
		contentPane.add(btnUpdate, gbc_btnUpdate);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(jl);
		panel.repaint();
		panel.revalidate();
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 1.0;
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 5;
		contentPane.add(panel_1, gbc_panel_1);
		
		btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jl.save((Profesor) jcbProfessor.getSelectedItem(), (Materia) jcbSubject.getSelectedItem(),
						Integer.parseInt((String) jcbNote.getSelectedItem()));
			}
		});
		panel_1.add(btnSave);
		
		getMaterias();
		getProfesores();
	}
	
	/**
	 * Método para obtener las materias
	 */
	private void getMaterias() {
		jcbSubject.removeAllItems();
		List<Materia> l = MateriaController.findAll();
		for (Materia o : l) {
			jcbSubject.addItem(o);
		}
	}
	
	/**
	 * Método para obtener los profesores
	 */
	private void getProfesores() {
		jcbProfessor.removeAllItems();
		List<Profesor> l = ProfesorController.findAll();
		for (Profesor o : l) {
			jcbProfessor.addItem(o);
		}
	}
	
}
