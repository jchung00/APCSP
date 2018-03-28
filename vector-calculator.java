import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;

import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.util.*;


public class Frame1 extends JFrame {

	private JPanel contentPane;
	private JTextField vectorTF;
	private JTextField vectorTF_1;
	private JTextField vectorTF_2;
	private JTextField vectorTF_3;
	private JTextField vectorTF_4;
	private JTextField xTF;
	private JTextField xTF_1;
	private JTextField xTF_2;
	private JTextField xTF_3;
	private JTextField xTF_4;
	private JTextField yTF;
	private JTextField yTF_1;
	private JTextField yTF_2;
	private JTextField yTF_3;
	private JTextField yTF_4;
	private JTextField zTF;
	private JTextField zTF_1;
	private JTextField zTF_2;
	private JTextField zTF_3;
	private JTextField zTF_4;
	private JTextField solutionTF;
	private JTextField solutionTF_1;
	private JTextField solutionTF_2;
	private JTextField answerTF;
	private JTextField answerTF_1;
	private JTextField answerTF_2;

	//Launch the application. Following 12 lines were generated by Eclipse.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 frame = new Frame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static double findMagnitude(double x, double y, double z){
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
	}
	
	public static double findDotProduct(double x, double y, double z, double x_2, double y_2, double z_2){
		return x*x_2 + y*y_2 + z*z_2;
	}
	
	public static double findCrossProduct(double x, double y, double z, double x_2, double y_2, double z_2, int index){
		double[] list = new double[3];
		list[0] = y*z_2 - z*y_2;
		list[1] = -(x*z_2 - z*x_2);
		list[2] = x*y_2 - y*x_2;
		return list[index];
	}
	
	public static boolean checkInputs(JTextField a, JTextField b, JTextField c, JTextField d, JTextField e, JTextField f, JTextField sol){
		JTextField[] textFields = {a, b, c, d, e, f};
		for(JTextField x:textFields){
			try{
				Double.parseDouble(x.getText());
			}
			catch(NumberFormatException numberError){
				sol.setText("Invalid input. Please try again.");
				return false;
			}
		}
		return true;
	}

	public Frame1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 588, 566);
		contentPane.add(tabbedPane);
		
		JPanel magTab = new JPanel();
		magTab.setBackground(new Color(255, 250, 250));
		tabbedPane.addTab("Magnitude", null, magTab, null);
		magTab.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Number of dimensions:");
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(16, 76, 224, 35);
		magTab.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Magnitude of a Vector Calculator");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Britannic Bold", Font.PLAIN, 36));
		lblNewLabel_1.setBounds(6, 6, 555, 58);
		magTab.add(lblNewLabel_1);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spinner.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent arg0) {
				int dimensions = (Integer) spinner.getValue();
				if(dimensions==1){
					yTF.setEditable(false);
					zTF.setEditable(false);
					yTF.setText("0");
					zTF.setText("0");
				}
				else if(dimensions==2){
					yTF.setEditable(true);
					zTF.setEditable(false);
					zTF.setText("0");
				}
				else{
					yTF.setEditable(true);
					zTF.setEditable(true);
				}
			}
		});
		spinner.setBounds(232, 80, 37, 28);
		magTab.add(spinner);
		
		JLabel lblNewLabel_2 = new JLabel("Input Vector:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(26, 132, 125, 20);
		magTab.add(lblNewLabel_2);
		
		vectorTF = new JTextField();
		vectorTF.setHorizontalAlignment(SwingConstants.CENTER);
		vectorTF.setText("V");
		vectorTF.setBounds(36, 164, 80, 28);
		magTab.add(vectorTF);
		vectorTF.setColumns(10);
		
		xTF = new JTextField();
		xTF.setHorizontalAlignment(SwingConstants.CENTER);
		xTF.setText("0");
		xTF.setBounds(145, 164, 115, 28);
		magTab.add(xTF);
		xTF.setColumns(10);
		
		yTF = new JTextField();
		yTF.setEditable(false);
		yTF.setHorizontalAlignment(SwingConstants.CENTER);
		yTF.setText("0");
		yTF.setBounds(288, 164, 115, 28);
		magTab.add(yTF);
		yTF.setColumns(10);
		
		zTF = new JTextField();
		zTF.setEditable(false);
		zTF.setHorizontalAlignment(SwingConstants.CENTER);
		zTF.setText("0");
		zTF.setBounds(430, 164, 115, 28);
		magTab.add(zTF);
		zTF.setColumns(10);
		
		solutionTF = new JTextField();
		solutionTF.setEditable(false);
		solutionTF.setBounds(32, 320, 509, 43);
		magTab.add(solutionTF);
		solutionTF.setColumns(10);
		
		answerTF = new JTextField();
		answerTF.setEditable(false);
		answerTF.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		answerTF.setHorizontalAlignment(SwingConstants.CENTER);
		answerTF.setBounds(32, 390, 509, 43);
		magTab.add(answerTF);
		answerTF.setColumns(10);
		
		JLabel label = new JLabel("=");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(120, 170, 20, 16);
		magTab.add(label);
		
		JLabel lblX = new JLabel("x");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(264, 170, 20, 16);
		magTab.add(lblX);
		
		JLabel lblX_1 = new JLabel("x");
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setBounds(405, 170, 23, 16);
		magTab.add(lblX_1);
		
		JLabel lblNewLabel_3 = new JLabel("Solution:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(26, 268, 96, 20);
		magTab.add(lblNewLabel_3);
		
		JButton calculateBtn = new JButton("Calculate");
		calculateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkInputs(xTF, yTF, zTF, xTF, yTF, zTF, solutionTF)){
					double x = Double.parseDouble(xTF.getText());
					double y = Double.parseDouble(yTF.getText());
					double z = Double.parseDouble(zTF.getText());
					String xSq = Double.toString(Math.pow(x, 2));
					String ySq = Double.toString(Math.pow(y, 2));
					String zSq = Double.toString(Math.pow(z, 2));
					String vector = vectorTF.getText().toUpperCase();
					String answer = Double.toString(findMagnitude(x, y, z));
					String solution = "|" + vector + "|" + " = sqrt(" + vector + "x^2 + " + vector + "y^2 + " + vector + "z^2) = sqrt(" + x + "^2 + " + y + "^2 + " + z + "^2)"
										+ "sqrt(" + xSq + " + " + ySq + " + " + zSq + ") = " + "sqrt(" + Double.toString(Math.pow(x, 2) + Math.pow(y,2) + Math.pow(z,2)) + ") = "
										+ answer;
					solutionTF.setText(solution);
					answerTF.setText(answer);
				}
			}
		});
		calculateBtn.setBounds(220, 218, 117, 29);
		magTab.add(calculateBtn);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vectorTF.setText("");
				xTF.setText("0");
				yTF.setText("0");
				zTF.setText("0");
				solutionTF.setText("");
				answerTF.setText("");
			}
		});
		clearBtn.setBounds(220, 457, 117, 29);
		magTab.add(clearBtn);
		
		JLabel lblNewLabel_4 = new JLabel("\u2248");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(248, 368, 61, 16);
		magTab.add(lblNewLabel_4);
		
		//////////////////////////////////////////////////////////////////////////////////////////end of magTab code
		
		JPanel dpTab = new JPanel();
		dpTab.setBackground(new Color(255, 250, 250));
		tabbedPane.addTab("Dot Product", null, dpTab, null);
		dpTab.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Number of dimensions:");
		lblNewLabel_5.setBounds(16, 76, 224, 35);
		lblNewLabel_5.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		dpTab.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Dot Product Calculator");
		lblNewLabel_6.setBounds(6, 6, 555, 58);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Britannic Bold", Font.PLAIN, 36));
		dpTab.add(lblNewLabel_6);
		
		final JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(232, 80, 37, 28);
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spinner_2.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent arg0) {
				int dimensions = (Integer) spinner_2.getValue();
				if(dimensions==1){
					yTF_1.setEditable(false);
					zTF_1.setEditable(false);
					yTF_1.setText("0");
					zTF_1.setText("0");
					yTF_2.setEditable(false);
					zTF_2.setEditable(false);
					yTF_2.setText("0");
					zTF_2.setText("0");
				}
				else if(dimensions==2){
					yTF_1.setEditable(true);
					zTF_1.setEditable(false);
					zTF_1.setText("0");
					yTF_2.setEditable(true);
					zTF_2.setEditable(false);
					zTF_2.setText("0");
				}
				else{
					yTF_1.setEditable(true);
					zTF_1.setEditable(true);
					yTF_2.setEditable(true);
					zTF_2.setEditable(true);
				}
			}
		});
		dpTab.add(spinner_2);
		
		JLabel lblNewLabel_7 = new JLabel("Input Vectors:");
		lblNewLabel_7.setBounds(30, 123, 125, 20);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 16));
		dpTab.add(lblNewLabel_7);
		
		vectorTF_1 = new JTextField();
		vectorTF_1.setBounds(36, 160, 80, 28);
		vectorTF_1.setHorizontalAlignment(SwingConstants.CENTER);
		vectorTF_1.setText("V1");
		dpTab.add(vectorTF_1);
		vectorTF_1.setColumns(10);
		
		vectorTF_2 = new JTextField();
		vectorTF_2.setBounds(36, 205, 80, 28);
		vectorTF_2.setHorizontalAlignment(SwingConstants.CENTER);
		vectorTF_2.setText("V2");
		dpTab.add(vectorTF_2);
		vectorTF_2.setColumns(10);
		
		xTF_1 = new JTextField();
		xTF_1.setBounds(145, 160, 115, 28);
		xTF_1.setHorizontalAlignment(SwingConstants.CENTER);
		xTF_1.setText("0");
		dpTab.add(xTF_1);
		xTF_1.setColumns(10);
		
		xTF_2 = new JTextField();
		xTF_2.setBounds(145, 205, 115, 28);
		xTF_2.setHorizontalAlignment(SwingConstants.CENTER);
		xTF_2.setText("0");
		dpTab.add(xTF_2);
		xTF_2.setColumns(10);
		
		yTF_1 = new JTextField();
		yTF_1.setBounds(288, 160, 115, 28);
		yTF_1.setEditable(false);
		yTF_1.setHorizontalAlignment(SwingConstants.CENTER);
		yTF_1.setText("0");
		dpTab.add(yTF_1);
		yTF_1.setColumns(10);
		
		yTF_2 = new JTextField();
		yTF_2.setBounds(288, 205, 115, 28);
		yTF_2.setEditable(false);
		yTF_2.setHorizontalAlignment(SwingConstants.CENTER);
		yTF_2.setText("0");
		dpTab.add(yTF_2);
		yTF_2.setColumns(10);
		
		zTF_1 = new JTextField();
		zTF_1.setBounds(430, 160, 115, 28);
		zTF_1.setEditable(false);
		zTF_1.setHorizontalAlignment(SwingConstants.CENTER);
		zTF_1.setText("0");
		dpTab.add(zTF_1);
		zTF_1.setColumns(10);
		
		zTF_2 = new JTextField();
		zTF_2.setBounds(430, 205, 115, 28);
		zTF_2.setEditable(false);
		zTF_2.setHorizontalAlignment(SwingConstants.CENTER);
		zTF_2.setText("0");
		dpTab.add(zTF_2);
		zTF_2.setColumns(10);
		
		solutionTF_1 = new JTextField();
		solutionTF_1.setBounds(32, 320, 509, 43);
		solutionTF_1.setEditable(false);
		dpTab.add(solutionTF_1);
		solutionTF_1.setColumns(10);
		
		answerTF_1 = new JTextField();
		answerTF_1.setBounds(32, 402, 509, 43);
		answerTF_1.setEditable(false);
		answerTF_1.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		answerTF_1.setHorizontalAlignment(SwingConstants.CENTER);
		dpTab.add(answerTF_1);
		answerTF_1.setColumns(10);
		
		JLabel label_8 = new JLabel("=");
		label_8.setBounds(120, 166, 20, 16);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		dpTab.add(label_8);
		
		JLabel lblX_2 = new JLabel("x");
		lblX_2.setBounds(264, 166, 20, 16);
		lblX_2.setHorizontalAlignment(SwingConstants.CENTER);
		dpTab.add(lblX_2);
		
		JLabel lblX_4 = new JLabel("x");
		lblX_4.setBounds(405, 166, 23, 16);
		lblX_4.setHorizontalAlignment(SwingConstants.CENTER);
		dpTab.add(lblX_4);
		
		JLabel label_2 = new JLabel("=");
		label_2.setBounds(120, 211, 20, 16);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		dpTab.add(label_2);
		
		JLabel lblX_5 = new JLabel("x");
		lblX_5.setBounds(264, 211, 20, 16);
		lblX_5.setHorizontalAlignment(SwingConstants.CENTER);
		dpTab.add(lblX_5);
		
		JLabel lblX2 = new JLabel("x");
		lblX2.setBounds(405, 211, 23, 16);
		lblX2.setHorizontalAlignment(SwingConstants.CENTER);
		dpTab.add(lblX2);
		
		JLabel lblNewLabel_10 = new JLabel("Solution:");
		lblNewLabel_10.setBounds(20, 288, 96, 20);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 16));
		dpTab.add(lblNewLabel_10);
		
		JButton calculateBtn_2 = new JButton("Calculate");
		calculateBtn_2.setBounds(220, 251, 117, 29);
		calculateBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkInputs(xTF_1, yTF_1, zTF_1, xTF_2, yTF_2, zTF_2, solutionTF_1)){
					double x = Double.parseDouble(xTF_1.getText());
					double y = Double.parseDouble(yTF_1.getText());
					double z = Double.parseDouble(zTF_1.getText());
					double x_2 = Double.parseDouble(xTF_2.getText());
					double y_2 = Double.parseDouble(yTF_2.getText());
					double z_2 = Double.parseDouble(zTF_2.getText());
					String vector = vectorTF_1.getText().toUpperCase();
					String vector_2 = vectorTF_2.getText().toUpperCase();
					String answer = Double.toString(findDotProduct(x, y, z, x_2, y_2, z_2));
					String solution = vector + "·" + vector_2 + " = " + vector + "x · " + vector_2 + "x + " + vector + "y · " + vector_2 + "y + " 
									+ vector + "z · " + vector_2 + "z = " + x + " · " + x_2 + " + " + y + " · " + y_2 + " + " + z + " · " + z_2 + " = " + answer;
					solutionTF_1.setText(solution);
					answerTF_1.setText(answer);
				}
			}
		});
		dpTab.add(calculateBtn_2);
		
		JButton clearBtn_2 = new JButton("Clear");
		clearBtn_2.setBounds(220, 457, 117, 29);
		clearBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vectorTF_1.setText("");
				vectorTF_2.setText("");
				xTF_1.setText("0");
				yTF_1.setText("0");
				zTF_1.setText("0");
				xTF_2.setText("0");
				yTF_2.setText("0");
				zTF_2.setText("0");
				solutionTF_1.setText("");
				answerTF_1.setText("");
			}
		});
		dpTab.add(clearBtn_2);
		
		JLabel lblNewLabel_9 = new JLabel("\u2248");
		lblNewLabel_9.setBounds(248, 374, 61, 16);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		dpTab.add(lblNewLabel_9);
		
		//////////////////////////////////////////////////////////////////////////////////////end of dpTab code
		
		JPanel cpTab = new JPanel();
		cpTab.setBackground(new Color(255, 250, 250));
		tabbedPane.addTab("Cross Product", null, cpTab, null);
		cpTab.setLayout(null);
		
		JLabel lbl = new JLabel("Number of dimensions:");
		lbl.setBounds(16, 76, 224, 35);
		lbl.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 16));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		cpTab.add(lbl);
		
		JLabel lbl_2 = new JLabel("Cross Product Calculator");
		lbl_2.setBounds(6, 6, 555, 58);
		lbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_2.setFont(new Font("Britannic Bold", Font.PLAIN, 36));
		cpTab.add(lbl_2);
		
		final JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(232, 80, 37, 28);
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spinner_3.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent arg0) {
				int dimensions = (Integer) spinner_3.getValue();
				if(dimensions==1){
					yTF_3.setEditable(false);
					zTF_3.setEditable(false);
					yTF_3.setText("0");
					zTF_3.setText("0");
					yTF_4.setEditable(false);
					zTF_4.setEditable(false);
					yTF_4.setText("0");
					zTF_4.setText("0");
				}
				else if(dimensions==2){
					yTF_3.setEditable(true);
					zTF_3.setEditable(false);
					zTF_3.setText("0");
					yTF_4.setEditable(true);
					zTF_4.setEditable(false);
					zTF_4.setText("0");
				}
				else{
					yTF_3.setEditable(true);
					zTF_3.setEditable(true);
					yTF_4.setEditable(true);
					zTF_4.setEditable(true);
				}
			}
		});
		cpTab.add(spinner_3);
		
		JLabel lbl_3 = new JLabel("Input Vectors:");
		lbl_3.setBounds(30, 123, 125, 20);
		lbl_3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_3.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 16));
		cpTab.add(lbl_3);
		
		vectorTF_3 = new JTextField();
		vectorTF_3.setBounds(36, 160, 80, 28);
		vectorTF_3.setHorizontalAlignment(SwingConstants.CENTER);
		vectorTF_3.setText("V1");
		cpTab.add(vectorTF_3);
		vectorTF_3.setColumns(10);
		
		vectorTF_4 = new JTextField();
		vectorTF_4.setBounds(36, 205, 80, 28);
		vectorTF_4.setHorizontalAlignment(SwingConstants.CENTER);
		vectorTF_4.setText("V2");
		cpTab.add(vectorTF_4);
		vectorTF_4.setColumns(10);
		
		xTF_3 = new JTextField();
		xTF_3.setBounds(145, 160, 115, 28);
		xTF_3.setHorizontalAlignment(SwingConstants.CENTER);
		xTF_3.setText("0");
		cpTab.add(xTF_3);
		xTF_3.setColumns(10);
		
		xTF_4 = new JTextField();
		xTF_4.setBounds(145, 205, 115, 28);
		xTF_4.setHorizontalAlignment(SwingConstants.CENTER);
		xTF_4.setText("0");
		cpTab.add(xTF_4);
		xTF_4.setColumns(10);
		
		yTF_3 = new JTextField();
		yTF_3.setBounds(288, 160, 115, 28);
		yTF_3.setEditable(false);
		yTF_3.setHorizontalAlignment(SwingConstants.CENTER);
		yTF_3.setText("0");
		cpTab.add(yTF_3);
		yTF_3.setColumns(10);
		
		yTF_4 = new JTextField();
		yTF_4.setBounds(288, 205, 115, 28);
		yTF_4.setEditable(false);
		yTF_4.setHorizontalAlignment(SwingConstants.CENTER);
		yTF_4.setText("0");
		cpTab.add(yTF_4);
		yTF_4.setColumns(10);
		
		zTF_3 = new JTextField();
		zTF_3.setBounds(430, 160, 115, 28);
		zTF_3.setEditable(false);
		zTF_3.setHorizontalAlignment(SwingConstants.CENTER);
		zTF_3.setText("0");
		cpTab.add(zTF_3);
		zTF_3.setColumns(10);
		
		zTF_4 = new JTextField();
		zTF_4.setBounds(430, 205, 115, 28);
		zTF_4.setEditable(false);
		zTF_4.setHorizontalAlignment(SwingConstants.CENTER);
		zTF_4.setText("0");
		cpTab.add(zTF_4);
		zTF_4.setColumns(10);
		
		solutionTF_2 = new JTextField();
		solutionTF_2.setBounds(32, 320, 509, 43);
		solutionTF_2.setEditable(false);
		cpTab.add(solutionTF_2);
		solutionTF_2.setColumns(10);
		
		answerTF_2 = new JTextField();
		answerTF_2.setBounds(32, 402, 509, 43);
		answerTF_2.setEditable(false);
		answerTF_2.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		answerTF_2.setHorizontalAlignment(SwingConstants.CENTER);
		cpTab.add(answerTF_2);
		answerTF_2.setColumns(10);
		
		JLabel lbl_4 = new JLabel("=");
		lbl_4.setBounds(120, 166, 20, 16);
		lbl_4.setHorizontalAlignment(SwingConstants.CENTER);
		cpTab.add(lbl_4);
		
		JLabel lbl_5 = new JLabel("x");
		lbl_5.setBounds(264, 166, 20, 16);
		lbl_5.setHorizontalAlignment(SwingConstants.CENTER);
		cpTab.add(lbl_5);
		
		JLabel lbl_6 = new JLabel("x");
		lbl_6.setBounds(405, 166, 23, 16);
		lbl_6.setHorizontalAlignment(SwingConstants.CENTER);
		cpTab.add(lbl_6);
		
		JLabel lbl_7 = new JLabel("=");
		lbl_7.setBounds(120, 211, 20, 16);
		lbl_7.setHorizontalAlignment(SwingConstants.CENTER);
		cpTab.add(lbl_7);
		
		JLabel lbl_8 = new JLabel("x");
		lbl_8.setBounds(264, 211, 20, 16);
		lbl_8.setHorizontalAlignment(SwingConstants.CENTER);
		cpTab.add(lbl_8);
		
		JLabel lbl_9 = new JLabel("x");
		lbl_9.setBounds(405, 211, 23, 16);
		lbl_9.setHorizontalAlignment(SwingConstants.CENTER);
		cpTab.add(lbl_9);
		
		JLabel lbl_10 = new JLabel("Solution:");
		lbl_10.setBounds(20, 288, 96, 20);
		lbl_10.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_10.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 16));
		cpTab.add(lbl_10);
		
		JButton calculateBtn_3 = new JButton("Calculate");
		calculateBtn_3.setBounds(220, 251, 117, 29);
		calculateBtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkInputs(xTF_3, yTF_3, zTF_3, xTF_4, yTF_4, zTF_4, solutionTF_2)){
					double x = Double.parseDouble(xTF_3.getText());
					double y = Double.parseDouble(yTF_3.getText());
					double z = Double.parseDouble(zTF_3.getText());
					double x_2 = Double.parseDouble(xTF_4.getText());
					double y_2 = Double.parseDouble(yTF_4.getText());
					double z_2 = Double.parseDouble(zTF_4.getText());
					String vector = vectorTF_3.getText().toUpperCase();
					String vector_2 = vectorTF_4.getText().toUpperCase();
					String ans_x = Double.toString(findCrossProduct(x, y, z, x_2, y_2, z_2, 0));
					String ans_y = Double.toString(findCrossProduct(x, y, z, x_2, y_2, z_2, 1));
					String ans_z = Double.toString(findCrossProduct(x, y, z, x_2, y_2, z_2, 2));
					String solution = vector + " x " + vector_2 + " = (" + vector + "y · " + vector_2 + "z - " + vector + "z · " + vector_2 + "y)i - (" 
									+ vector + "x · " + vector_2 + "z - " + vector + "z · " + vector_2 + "x)j + (" 
									+ vector + "x · " + vector_2 + "y - " + vector + "y · " + vector_2 + "z)k = " 
									+ "(" + y*z_2 + " - " + z*y_2 + ")i - (" + x*z_2 + " - " + z*x_2 + ")j + (" + x*y_2 + " - " + y*x_2 + ")k = {"
									+ ans_x + " , " + ans_y + " , " + ans_z + "}";
					solutionTF_2.setText(solution);
					answerTF_2.setText("{" + ans_x + " , " + ans_y + " , " + ans_z + "}");
				}
			}
		});
		cpTab.add(calculateBtn_3);
		
		JButton clearBtn_3 = new JButton("Clear");
		clearBtn_3.setBounds(220, 457, 117, 29);
		clearBtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vectorTF_3.setText("");
				vectorTF_4.setText("");
				xTF_3.setText("0");
				yTF_3.setText("0");
				zTF_3.setText("0");
				xTF_4.setText("0");
				yTF_4.setText("0");
				zTF_4.setText("0");
				solutionTF_2.setText("");
				answerTF_2.setText("");
			}
		});
		cpTab.add(clearBtn_3);
		
		JLabel lbl_11 = new JLabel("\u2248");
		lbl_11.setBounds(248, 374, 61, 16);
		lbl_11.setHorizontalAlignment(SwingConstants.CENTER);
		cpTab.add(lbl_11);
	}
}