package com.FernandoFerreira.TesteArduino.App;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Timer;

import com.FernandoFerreira.TesteArduino.View.ArduinoJumpScare;
import com.fazecast.jSerialComm.SerialPort;

public class Main {

	public static void main(String[] args) {
		SerialPort arduinoPort = SerialPort.getCommPort("..."); // Substitua pela porta correta
		arduinoPort.setBaudRate(9600);

		if (arduinoPort.openPort()) {
			System.out.println("Porta aberta com sucesso!");
		} else {
			System.out.println("Falha ao abrir a porta.");
			return;
		}

		try (
		Scanner data = new Scanner(arduinoPort.getInputStream())) {
			while (data.hasNextLine()) {
				String line = data.nextLine();
				ArduinoJumpScare jumpScarePanel = new ArduinoJumpScare(Integer.parseInt(line));
				Timer timer = new Timer(2000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						jumpScarePanel.setImageIndex(Integer.parseInt(line));
					}
				});
				timer.start();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		arduinoPort.closePort();
	}

}
