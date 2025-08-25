package org.example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GerenciadorDeEntrada implements MouseListener, MouseMotionListener {
  private final Mundo mundo;

  public GerenciadorDeEntrada(Mundo mundo) {
    this.mundo = mundo;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    int vx = e.getX() / App.TAMANHO_PIXEL;
    int vy = e.getY() / App.TAMANHO_PIXEL;
    mundo.notificarPressionado(vx, vy);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    mundo.notificarSolto();
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    int vx = e.getX() / App.TAMANHO_PIXEL;
    int vy = e.getY() / App.TAMANHO_PIXEL;
    mundo.notificarArrastado(vx, vy);

    // Repaint é chamado no JPanel (App), então o gerenciador não deveria chamá-lo.
    // O ideal é ter um loop de atualização no App.
    // Por enquanto, a lógica de arrastar não vai redesenhar a tela.
  }

  // Métodos não utilizados
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
  public void mouseMoved(MouseEvent e) {
  }
}
