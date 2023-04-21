package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;

import controller.ValoracionMateriaController;
import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class EstudiantePanel extends JPanel {

	private static JLabel lblEstudiante;
	private JSpinner jspValoracion;
	private Estudiante e;
	private Profesor p;
	private Materia m;

	/**
	 * Crea el panel
	 */
	public EstudiantePanel(Estudiante e, Profesor p, Materia m) {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblEstudiante = new JLabel("New label");
		lblEstudiante.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblEstudiante = new GridBagConstraints();
		gbc_lblEstudiante.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEstudiante.anchor = GridBagConstraints.EAST;
		gbc_lblEstudiante.insets = new Insets(0, 0, 10, 10);
		gbc_lblEstudiante.gridx = 0;
		gbc_lblEstudiante.gridy = 0;
		add(lblEstudiante, gbc_lblEstudiante);
		
		jspValoracion = new JSpinner();
		jspValoracion.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		GridBagConstraints gbc_jspValoracion = new GridBagConstraints();
		gbc_jspValoracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jspValoracion.insets = new Insets(0, 0, 10, 0);
		gbc_jspValoracion.weightx = 1.0;
		gbc_jspValoracion.gridx = 1;
		gbc_jspValoracion.gridy = 0;
		add(jspValoracion, gbc_jspValoracion);
		
		this.e = e;
		this.p = p;
		this.m = m;
		load();
	}
	
	/**
	 * Método para cargar los datos
	 * @param e
	 * @param p
	 * @param m
	 */
	public void load() {
		Valoracionmateria o = ValoracionMateriaController.findByMultipleId(p.getId(), e.getId(), m.getId());
		lblEstudiante.setText(e.toString() + ":");
		if (o != null) {
			jspValoracion.setValue(o.getValoracion());
		}
	}
	
	/**
	 * Método para guardar los datos
	 * @param e
	 * @param p
	 * @param m
	 */
	public void save() {
		Valoracionmateria o = ValoracionMateriaController.findByMultipleId(p.getId(), e.getId(), m.getId());
		if (o == null) {
			o = new Valoracionmateria();
			o.setProfesor(p);
			o.setEstudiante(e);
			o.setMateria(m);
		}
		o.setValoracion((Integer) jspValoracion.getValue());
		ValoracionMateriaController.save(o);
	}

}
