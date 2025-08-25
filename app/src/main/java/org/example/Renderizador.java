package org.example;

import java.util.Arrays;

public class Renderizador {
  private final int largura;
  private final int altura;
  private final int[] pixels;

  public Renderizador(int largura, int altura, int[] pixels) {
    this.largura = largura;
    this.altura = altura;
    this.pixels = pixels;
  }

  public void limpar(int cor) {
    Arrays.fill(pixels, cor);
  }

  public void desenharPixel(int vx, int vy, int tamanho, int cor) {
    for (int y = 0; y < tamanho; y++) {
      for (int x = 0; x < tamanho; x++) {
        int px = vx + x;
        int py = vy + y;

        if (px >= 0 && px < largura && py >= 0 && py < altura) {
          pixels[py * largura + px] = cor;
        }
      }
    }
  }
}
