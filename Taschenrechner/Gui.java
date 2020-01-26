import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame implements ActionListener {

	private Double zahl1;
	private Double zahl2 = (double) 0;
	private String operation = "+";

	private JPanel ausgabe;
	private JPanel zahlen;
	private JPanel zeichen;
	private JPanel eingabe;

	private JButton z01;
	private JButton z02;
	private JButton z03;
	private JButton z04;
	private JButton z05;
	private JButton z06;
	private JButton z07;
	private JButton z08;
	private JButton z09;
	private JButton z2;
	private JButton z3;
	private JButton z4;
	private JButton enter;
	private JButton plus;
	private JButton minus;
	private JButton mal;
	private JButton geteilt;
	private JButton aufNull;

	private JTextField textfeld;

	Gui() {
		init();
	}

	private void init() {
		setTitle("Taschenrechner");

		zahlen = new JPanel();
		zahlen.setLayout(new GridLayout(4, 3));

		z01 = new JButton("1");
		z02 = new JButton("2");
		z03 = new JButton("3");
		z04 = new JButton("4");
		z05 = new JButton("5");
		z06 = new JButton("6");
		z07 = new JButton("7");
		z08 = new JButton("8");
		z09 = new JButton("9");
		zahlen.add(z01);
		zahlen.add(z02);
		zahlen.add(z03);
		zahlen.add(z04);
		zahlen.add(z05);
		zahlen.add(z06);
		zahlen.add(z07);
		zahlen.add(z08);
		zahlen.add(z09);
		z01.addActionListener(this);
		z02.addActionListener(this);
		z03.addActionListener(this);
		z04.addActionListener(this);
		z05.addActionListener(this);
		z06.addActionListener(this);
		z07.addActionListener(this);
		z08.addActionListener(this);
		z09.addActionListener(this);

		z2 = new JButton("0");
		zahlen.add(z2);
		z2.addActionListener(this);
		z3 = new JButton("00");
		zahlen.add(z3);
		z3.addActionListener(this);
		z4 = new JButton(".");
		zahlen.add(z4);
		z4.addActionListener(this);

		zeichen = new JPanel();
		zeichen.setLayout(new GridLayout(4, 1));
		plus = new JButton("+");
		zeichen.add(plus);
		plus.addActionListener(this);
		minus = new JButton("-");
		zeichen.add(minus);
		minus.addActionListener(this);
		mal = new JButton("*");
		zeichen.add(mal);
		mal.addActionListener(this);
		geteilt = new JButton("/");
		zeichen.add(geteilt);
		geteilt.addActionListener(this);

		eingabe = new JPanel();
		eingabe.setLayout(new GridLayout(1, 2));
		eingabe.add(zahlen);
		eingabe.add(zeichen);

		ausgabe = new JPanel();
		ausgabe.setLayout(new GridLayout(1, 2));
		textfeld = new JTextField();
		textfeld.setText("");
		ausgabe.add(textfeld);
		enter = new JButton("=");
		ausgabe.add(enter);
		enter.addActionListener(this);
		aufNull = new JButton("Reset");
		ausgabe.add(aufNull);
		aufNull.addActionListener(this);

		getContentPane().setLayout(new GridLayout(2, 1));
		getContentPane().add(ausgabe);
		getContentPane().add(eingabe);

		setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
			if (Character.isDigit(((AbstractButton) e.getSource()).getText().charAt(0))) {
				String text = textfeld.getText();
				textfeld.setText(text + ((AbstractButton) e.getSource()).getText());
			} else if (((AbstractButton) e.getSource()).getText() == "+") {
				zahl1 = Double.parseDouble(textfeld.getText());
				textfeld.setText("");
				operation = "+";
			} else if (((AbstractButton) e.getSource()).getText() == "-") {
				zahl1 = Double.parseDouble(textfeld.getText());
				textfeld.setText("");
				operation = "-";
			} else if (((AbstractButton) e.getSource()).getText() == "*") {
				zahl1 = Double.parseDouble(textfeld.getText());
				textfeld.setText("");
				operation = "*";
			} else if (((AbstractButton) e.getSource()).getText() == "/") {
				zahl1 = Double.parseDouble(textfeld.getText());
				textfeld.setText("");
				operation = "/";
			} else if (((AbstractButton) e.getSource()).getText() == ".") {
				String text = textfeld.getText();
				textfeld.setText(text + ((AbstractButton) e.getSource()).getText());
			} else if (((AbstractButton) e.getSource()).getText() == "=") {
				if (operation == "+") {
					zahl2 = Double.parseDouble(textfeld.getText());
					textfeld.setText(Double.toString(zahl1 + zahl2));
				} else if (operation == "-") {
					zahl2 = Double.parseDouble(textfeld.getText());
					textfeld.setText(Double.toString(zahl1 - zahl2));
				} else if (operation == "/") {
					zahl2 = Double.parseDouble(textfeld.getText());
					textfeld.setText(Double.toString(zahl1 / zahl2));
				} else if (operation == "*") {
					zahl2 = Double.parseDouble(textfeld.getText());
					textfeld.setText(Double.toString(zahl1 * zahl2));
				}
				
			}
			else if(((AbstractButton) e.getSource()).getText() == "Reset") {
				textfeld.setText("");
				}
			}
		
	}

