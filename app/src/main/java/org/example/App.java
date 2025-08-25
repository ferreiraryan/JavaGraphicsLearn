// Arquivo: App.java
package org.example;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class App extends JPanel {
  private static final int LARGURA = 800;
  private static final int ALTURA = 600;
  public static final int TAMANHO_PIXEL = 10;

  private final BufferedImage imagem;
  private final int[] pixels;

  private final Mundo mundo;
  private final Renderizador renderizador;
  private final GerenciadorDeEntrada gerenciadorDeEntrada;

  public App() {
    setPreferredSize(new Dimension(LARGURA, ALTURA));
    imagem = new BufferedImage(LARGURA, ALTURA, BufferedImage.TYPE_INT_RGB);
    pixels = ((DataBufferInt) imagem.getRaster().getDataBuffer()).getData();

    this.mundo = new Mundo();
    this.renderizador = new Renderizador(LARGURA, ALTURA, pixels);
    this.gerenciadorDeEntrada = new GerenciadorDeEntrada(mundo);

    addMouseListener(gerenciadorDeEntrada);
    addMouseMotionListener(gerenciadorDeEntrada);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    mundo.desenhar(renderizador);

    g.drawImage(imagem, 0, 0, LARGURA, ALTURA, null);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("POO com Pixels");
    App painel = new App();
    frame.add(painel);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
