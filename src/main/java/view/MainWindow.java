package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EstudianteController;
import controller.MateriaController;
import controller.ProfesorController;
import model.Estudiante;
import model.Materia;
import model.Profesor;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	private JButton btnActualizar;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnGuardar;
	private List<EstudiantePanel> p = new ArrayList<EstudiantePanel>();

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
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
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.weightx = 1.0;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		contentPane.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		contentPane.add(jcbProfesor, gbc_jcbProfesor);
		
		btnActualizar = new JButton("Actualizar alumnado");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createEstudiantePanels();
			}
		});
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.insets = new Insets(0, 0, 5, 0);
		gbc_btnActualizar.gridx = 2;
		gbc_btnActualizar.gridy = 1;
		contentPane.add(btnActualizar, gbc_btnActualizar);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 1.0;
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		panel_1.add(btnGuardar);
		
		getMaterias();
		getProfesores();
	}
	
	/**
	 * Método para obtener las materias
	 */
	private void getMaterias() {
		jcbMateria.removeAllItems();
		List<Materia> l = MateriaController.findAll();
		for (Materia o : l) {
			jcbMateria.addItem(o);
		}
	}
	
	/**
	 * Método para obtener los profesores
	 */
	private void getProfesores() {
		jcbProfesor.removeAllItems();
		List<Profesor> l = ProfesorController.findAll();
		for (Profesor o : l) {
			jcbProfesor.addItem(o);
		}
	}
	
	/**
	 * Método para crear los paneles de estudiante
	 */
	private void createEstudiantePanels() {
		p.clear();
		panel.removeAll();
		List<Estudiante> l = EstudianteController.findAll();
		for (Estudiante o : l) {
			EstudiantePanel e = new EstudiantePanel(o, (Profesor) jcbProfesor.getSelectedItem(), (Materia) jcbMateria.getSelectedItem());
			p.add(e);
			panel.add(e);
		}
		panel.repaint();
		panel.revalidate();
	}
	
	/**
	 * Método para guardar los datos
	 */
	private void save() {
		for (EstudiantePanel e : p) {
			e.save();
		}
	}
	
}
