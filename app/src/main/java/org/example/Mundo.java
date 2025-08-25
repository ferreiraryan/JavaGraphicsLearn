package org.example;

import java.util.ArrayList;

public class Mundo {
  private final ArrayList<Pixel> pixels = new ArrayList<>();
  private Pixel pixelArrastado = null;

  public Mundo() {
    pixels.add(new Pixel(10, 15, 10, 0xFFFFFF));
    pixels.add(new Pixel(25, 15, 10, 0xFF0000));
  }

  public void desenhar(Renderizador renderizador) {
    renderizador.limpar(0);
    for (Pixel p : pixels) {
      p.desenhar(renderizador);
    }
  }

  public void notificarPressionado(int vx, int vy) {
    for (Pixel p : pixels) {
      if (p.x == vx && p.y == vy) {
        pixelArrastado = p;
        return;
      }
    }
  }

  public void notificarArrastado(int vx, int vy) {
    if (pixelArrastado != null) {
      pixelArrastado.x = vx;
      pixelArrastado.y = vy;
    }
  }

  public void notificarSolto() {
    pixelArrastado = null;
  }
}
