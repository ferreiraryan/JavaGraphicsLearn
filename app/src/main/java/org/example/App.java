package org.example;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class App extends JPanel implements MouseMotionListener, MouseListener {
  private final int LARGURA_JANELA = 800;
  private final int ALTURA_JANELA = 600;

  private final int TAMANHO_PIXEL = 10;

  private final BufferedImage imagem;
  private final int[] pixels;

  private boolean mouseSobrePixel = false;
  private Pixel pixelArrastado = null;

  private Pixel meuPixel;

  public App() {
    setPreferredSize(new Dimension(LARGURA_JANELA, ALTURA_JANELA));
    imagem = new BufferedImage(LARGURA_JANELA, ALTURA_JANELA, BufferedImage.TYPE_INT_RGB);
    pixels = ((DataBufferInt) imagem.getRaster().getDataBuffer()).getData();
    meuPixel = new Pixel(10, 15, 0xFFFFFF);
    addMouseMotionListener(this);
    addMouseListener(this);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    desenharPadrao();
    g.drawImage(imagem, 0, 0, LARGURA_JANELA, ALTURA_JANELA, null);
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    int mouseX = e.getX();
    int mouseY = e.getY();

    int mouseVX = mouseX / TAMANHO_PIXEL;
    int mouseVY = mouseY / TAMANHO_PIXEL;

    boolean antes = mouseSobrePixel;

    if (mouseVX == meuPixel.x && mouseVY == meuPixel.y) {
      mouseSobrePixel = true;
    } else {
      mouseSobrePixel = false;
    }

    if (antes != mouseSobrePixel) {
      repaint();
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
    int mouseVX = e.getX() / TAMANHO_PIXEL;
    int mouseVY = e.getY() / TAMANHO_PIXEL;

    if (mouseVX == meuPixel.x && mouseVY == meuPixel.y) {
      pixelArrastado = meuPixel;
      System.out.println("Agarrou o pixel!");
    }
    System.out.println("Ao pixel!");

  }

  @Override
  public void mouseReleased(MouseEvent e) {
    pixelArrastado = null;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    if (pixelArrastado != null) {
      int newMouseVX = e.getX() / TAMANHO_PIXEL;
      int newMouseVY = e.getY() / TAMANHO_PIXEL;

      pixelArrastado.x = newMouseVX;
      pixelArrastado.y = newMouseVY;

      repaint();
    }
  }

  private void desenharSuperPixel(int vx, int vy, int cor) {
    int xInicial = vx * TAMANHO_PIXEL;
    int yInicial = vy * TAMANHO_PIXEL;

    for (int y = 0; y < TAMANHO_PIXEL; y++) {
      for (int x = 0; x < TAMANHO_PIXEL; x++) {
        int px = xInicial + x;
        int py = yInicial + y;

        if (px >= 0 && px < LARGURA_JANELA && py >= 0 && py < ALTURA_JANELA) {
          pixels[py * LARGURA_JANELA + px] = cor;
        }
      }
    }
  }

  private void desenharPadrao() {
    Arrays.fill(pixels, 0);

    int corPixelBranco;
    if (mouseSobrePixel) {
      corPixelBranco = 0x00FF00;
    } else {
      corPixelBranco = 0xFFFFFF;
    }

    desenharSuperPixel(meuPixel.x, meuPixel.y, corPixelBranco);

  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Controle de Pixels");
    App painel = new App();
    frame.add(painel);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
