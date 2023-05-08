package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import controller.EstudianteController;
import controller.ValoracionMateriaController;
import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JListPanel extends JPanel {
	
	private JList jl;
	private JList jl2;
	private DefaultListModel<Estudiante> dlm = new DefaultListModel<Estudiante>();
	private DefaultListModel<Estudiante> dlm2 = new DefaultListModel<Estudiante>();
	private List<Estudiante> l = EstudianteController.findAll();

	/**
	 * Crea el panel
	 */
	public JListPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0};
//		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Alumnado no seleccionado:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alumnado seleccionado:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jl = new JList(dlm);
		
		JScrollPane scrollPane = new JScrollPane(jl);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		JButton btnRemoveAll = new JButton("<<");
		btnRemoveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAll();
			}
		});
		GridBagConstraints gbc_btnRemoveAll = new GridBagConstraints();
		gbc_btnRemoveAll.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemoveAll.gridx = 1;
		gbc_btnRemoveAll.gridy = 1;
		add(btnRemoveAll, gbc_btnRemoveAll);
		
		jl2 = new JList(dlm2);
		
		JScrollPane scrollPane_1 = new JScrollPane(jl2);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.weightx = 1.0;
		gbc_scrollPane_1.gridheight = 4;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 1;
		add(scrollPane_1, gbc_scrollPane_1);
		
		JButton btnRemoveSelected = new JButton("<");
		btnRemoveSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteSelected();
			}
		});
		GridBagConstraints gbc_btnRemoveSelected = new GridBagConstraints();
		gbc_btnRemoveSelected.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemoveSelected.gridx = 1;
		gbc_btnRemoveSelected.gridy = 2;
		add(btnRemoveSelected, gbc_btnRemoveSelected);
		
		JButton btnAddSelected = new JButton(">");
		btnAddSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSelected();
			}
		});
		GridBagConstraints gbc_btnAddSelected = new GridBagConstraints();
		gbc_btnAddSelected.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddSelected.gridx = 1;
		gbc_btnAddSelected.gridy = 3;
		add(btnAddSelected, gbc_btnAddSelected);
		
		JButton btnAddAll = new JButton(">>");
		btnAddAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAll();
			}
		});
		GridBagConstraints gbc_btnAddAll = new GridBagConstraints();
		gbc_btnAddAll.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddAll.gridx = 1;
		gbc_btnAddAll.gridy = 4;
		add(btnAddAll, gbc_btnAddAll);
	}

	/**
	 * Método para añadir los elementos seleccionados
	 */
	private void addSelected() {
		dlm2.addAll(jl.getSelectedValuesList());
		for (int i = jl.getSelectedIndices().length - 1; i >= 0; i--) {
			dlm.removeElementAt(jl.getSelectedIndices()[i]);
		}
	}
	
	/**
	 * Método para añadir todos los elementos
	 */
	private void addAll() {
		dlm.removeAllElements();
		dlm2.removeAllElements();
		dlm2.addAll(l);
	}
	
	/**
	 * Método para eliminar los elementos seleccionados
	 */
	private void deleteSelected() {
		dlm.addAll(jl2.getSelectedValuesList());
		for (int i = jl2.getSelectedIndices().length - 1; i >= 0; i--) {
			dlm2.removeElementAt(jl2.getSelectedIndices()[i]);
		}
	}
	
	/**
	 * Método para eliminar todos los elementos
	 */
	public void deleteAll() {
		dlm.removeAllElements();
		dlm2.removeAllElements();
		dlm.addAll(l);
	}
	
	/**
	 * Método para guardar los datos
	 * @param e
	 * @param p
	 * @param m
	 */
	public void save(Profesor p, Materia m, int n) {
		List<Estudiante> l = new ArrayList<Estudiante>();
		for (int i = 0; i < dlm2.size(); i++) {
			l.add(dlm2.getElementAt(i));
		}
		for (Estudiante e : l) {
			Valoracionmateria o = ValoracionMateriaController.findByMultipleId(p.getId(), e.getId(), m.getId());
			if (o == null) {
				o = new Valoracionmateria();
				o.setProfesor(p);
				o.setEstudiante(e);
				o.setMateria(m);
			}
			o.setValoracion(n);
			ValoracionMateriaController.save(o);
		}
	}

}
