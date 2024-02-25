package com.fatec.detector_img.servico;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
/*
 * captura a imagem 10s depois do inicio da execucao do algoritmo
 */
public class CapturaImagem {
	public static void main(String[] args) throws IOException {
		int segundosDesejados = 10; // Define o número de segundos para execução do laco 
		long tempoInicio = System.currentTimeMillis();
		long tempoAtual;
		
		while (true) {
			tempoAtual = System.currentTimeMillis();
			long tempoDecorrido = (tempoAtual - tempoInicio) / 1000; // Convertendo para segundos
			if (tempoDecorrido >= segundosDesejados) {
				// abre a webcan default no sistema
				Webcam webcam = Webcam.getDefault();
				webcam.open();
				// obtem a imagem
				BufferedImage image = webcam.getImage();
				// salva a imagem em um arquivo PNG 
				ImageIO.write(image, "PNG", new File("test2.png"));
                break; // Sai do laço quando o tempo desejado for atingido
            }
			
			System.out.println("Executando... Tempo decorrido: " + tempoDecorrido + " segundos");
		}
	}
}
