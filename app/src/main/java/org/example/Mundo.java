package org.example;

import java.util.ArrayList;

public class Mundo {
  private final ArrayList<Pixel> pixels = new ArrayList<>();

  private Pixel pixelArrastado = null;

  private int mouseX, mouseY;
  private int offsetX, offsetY;

  private static final double K_MOLA = 0.10;

  private static final double FRICAO = 0.95;

  public Mundo() {
    pixels.add(new Pixel(100.0, 150.0, 20, 0xFFFFFF));
    pixels.add(new Pixel(250.0, 150.0, 40, 0xFF0000));
    pixels.add(new Pixel(400.0, 150.0, 60, 0x0000FF));
  }

  public void atualizar() {
    for (Pixel p : pixels) {
      if (p == pixelArrastado) {
        double distCentroX = mouseX - (p.x + p.tamanho / 2.0);
        double distCentroY = mouseY - (p.y + p.tamanho / 2.0);

        double forcaX = distCentroX * K_MOLA;
        double forcaY = distCentroY * K_MOLA;

        p.vx += forcaX / p.massa;
        p.vy += forcaY / p.massa;
      }

      p.vx *= FRICAO;
      p.vy *= FRICAO;

      p.x += p.vx;
      p.y += p.vy;
    }

    for (int i = 0; i < 4; i++) {
      for (Pixel p : pixels) {
        resolverColisoesPara(p);
      }
    }
  }

  public void desenhar(Renderizador renderizador) {
    renderizador.limpar(0x101010);
    for (Pixel p : pixels) {
      p.desenhar(renderizador);
    }
  }

  private void resolverColisoesPara(Pixel p) {
    for (Pixel obstaculo : pixels) {
      if (p == obstaculo)
        continue;

      if (p.colideCom(obstaculo)) {
        double overlapX = Math.min(p.x + p.tamanho, obstaculo.x + obstaculo.tamanho) - Math.max(p.x, obstaculo.x);
        double overlapY = Math.min(p.y + p.tamanho, obstaculo.y + obstaculo.tamanho) - Math.max(p.y, obstaculo.y);

        if (overlapX < overlapY) {
          if (p.x < obstaculo.x)
            p.x -= overlapX;
          else
            p.x += overlapX;
        } else {
          if (p.y < obstaculo.y)
            p.y -= overlapY;
          else
            p.y += overlapY;
        }
      }
    }
    if (p.x < 0) {
      p.x = 0;
      p.vx *= -0.5;
    }
    if (p.y < 0) {
      p.y = 0;
      p.vy *= -0.5;
    }
    if (p.x + p.tamanho > App.LARGURA) {
      p.x = App.LARGURA - p.tamanho;
      p.vx *= -0.5;
    }
    if (p.y + p.tamanho > App.ALTURA) {
      p.y = App.ALTURA - p.tamanho;
      p.vy *= -0.5;
    }
  }

  public void atualizarPosicaoMouse(int x, int y) {
    this.mouseX = x;
    this.mouseY = y;
  }

  public void notificarPressionado(int mouseX, int mouseY) {
    for (int i = pixels.size() - 1; i >= 0; i--) {
      Pixel p = pixels.get(i);
      if (p.contemPonto(mouseX, mouseY)) {
        pixelArrastado = p;
        offsetX = (int) (mouseX - p.x);
        offsetY = (int) (mouseY - p.y);
        return;
      }
    }
  }

  public void notificarSolto() {
    if (pixelArrastado != null) {
      // pixelArrastado.vx = 0;
      // pixelArrastado.vy = 0;
      pixelArrastado = null;
    }
  }
}
