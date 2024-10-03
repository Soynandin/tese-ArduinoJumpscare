package com.FernandoFerreira.TesteArduino.View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ArduinoJumpScare extends JPanel {

	private static final long serialVersionUID = 1L;

	private int imageIndex;
	private Image[] images;

	public ArduinoJumpScare(int sonar) {
		this.imageIndex = sonar;
		images = new Image[3];
		inicializaImagens();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	private void inicializaImagens() {
		images[0] = new ImageIcon("contato1.png").getImage();
		images[1] = new ImageIcon("contato2.png").getImage();
		images[2] = new ImageIcon("scare.png").getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch (imageIndex) {
		case 300:
			g.drawImage(images[0], 0, 0, this.getWidth(), this.getHeight(), this);
			break;
		case 200:
			g.drawImage(images[1], 0, 0, this.getWidth(), this.getHeight(), this);
			break;
		case 100:
			g.drawImage(images[2], 0, 0, this.getWidth(), this.getHeight(), this);
			break;
		default:
			break;
		}
	}

	public void setImageIndex(int index) {
		this.imageIndex = index;
		repaint();
	}

}
