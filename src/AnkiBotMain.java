import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random; 

import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;

public class AnkiBotMain {

	static boolean onoroff;
	//static boolean onlyankix;

	static int checkbeforedelay = 3;
	static int checkafterdelay = 4;
	static int checkpercentage = 90;
	
	//static boolean ankiopen;

	public static void main(String[] args) throws AWTException, InterruptedException {
		makeGui();

		while (true) {
			if (onoroff) {					
					Robot r = new Robot();
			        Random rand = new Random(); 

					Thread.sleep(checkbeforedelay * 1000);					

					r.keyPress(KeyEvent.VK_SPACE);
					System.out.println("Space pressed");
					r.keyRelease(KeyEvent.VK_SPACE);

					
					Thread.sleep(checkafterdelay * 1000);
				
					int randChecker = rand.nextInt(101);
					if (randChecker >= checkpercentage) {
						r.keyPress(KeyEvent.VK_1);
						System.out.println("1 pressed");
						r.keyRelease(KeyEvent.VK_1);
					} else {
						r.keyPress(KeyEvent.VK_2);
						System.out.println("2 pressed");
						r.keyRelease(KeyEvent.VK_2);
					}
							
				
			} else {
				System.out.println(onoroff);
			}
		}
		/*while (true) {
			if (!onoroff) {
				System.out.println("onion");

			} else {
				System.out.println("potato");

			}
		}*/

	}
	public static void checkWindow() {
		
	}
	public static void makeGui() {
		Color selected = Color.GREEN;

		JFrame frame = new JFrame("aidan is gay peepee");
		frame.setVisible(true);
		frame.setSize(400, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);

		JToggleButton onoff = new JToggleButton("press to kiss noah");
		onoff.setBounds(140, 50, 150, 35);
		onoff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JToggleButton tBtn = (JToggleButton) e.getSource();
				if (tBtn.isSelected()) {
					onoroff = true;
				} else {
					onoroff = false;
				}
			}
		});
		panel.add(onoff);

		/*JToggleButton onlyanki = new JToggleButton("Only Anki");
		onlyanki.setBounds(170, 85, 95, 35);
		onlyanki.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JToggleButton tBtn = (JToggleButton) e.getSource();
				if (tBtn.isSelected()) {
					onlyankix = true;
				} else {
					onlyankix = false;
				}
			}
		});
		panel.add(onlyanki);*/

		JLabel delaylabel = new JLabel("death threats per minute");
		delaylabel.setBounds(170, 150, 105, 55);

		panel.add(delaylabel);

		JLabel delaylabel2 = new JLabel("iq level");
		delaylabel2.setBounds(170, 270, 105, 55);
		panel.add(delaylabel2);

		JLabel percentagelabel = new JLabel("Success Percentage");
		percentagelabel.setBounds(150, 390, 125, 55);
		panel.add(percentagelabel);

		JSlider delay = new JSlider(69, 101, 200);
		delay.setBounds(60, 180, 300, 55);
		delay.setMajorTickSpacing(4);
		delay.setMinorTickSpacing(1);
		delay.setPaintTicks(true);

		Hashtable<Integer, JLabel> labels = new Hashtable<>();
		labels.put(1, new JLabel("69"));
		labels.put(5, new JLabel("101"));
		labels.put(9, new JLabel("200"));

		delay.setLabelTable(labels);

		delay.setPaintLabels(true);

		delay.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					checkbeforedelay = (int) source.getValue();

				}
			}
		});

		panel.add(delay);

		//////////////////////////////////////////////////////////

		JSlider delay2 = new JSlider(1, 9, 4);
		delay2.setBounds(60, 300, 300, 55);
		delay2.setMajorTickSpacing(4);
		delay2.setMinorTickSpacing(1);
		delay2.setPaintTicks(true);

		Hashtable<Integer, JLabel> labels3 = new Hashtable<>();
		labels3.put(1, new JLabel("1"));
		labels3.put(5, new JLabel("5"));
		labels3.put(9, new JLabel("9"));

		delay2.setLabelTable(labels3);

		delay2.setPaintLabels(true);

		delay2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					checkafterdelay = (int) source.getValue();

				}
			}
		});

		panel.add(delay2);
		///////////////////////////////////////////////

		JSlider percentage = new JSlider(0, 100, 90);
		percentage.setBounds(60, 420, 300, 55);
		percentage.setMajorTickSpacing(50);
		percentage.setMinorTickSpacing(10);
		percentage.setPaintTicks(true);

		Hashtable<Integer, JLabel> labels2 = new Hashtable<>();
		labels2.put(0, new JLabel("0"));
		labels2.put(50, new JLabel("50"));
		labels2.put(100, new JLabel("100"));

		percentage.setLabelTable(labels2);

		percentage.setPaintLabels(true);

		percentage.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					checkpercentage = (int) source.getValue();

				}
			}
		});

		panel.add(percentage);

	}

}