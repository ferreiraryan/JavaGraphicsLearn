package org.example;

public class Pixel {
  public int x, y, tamanho, cor;

  public Pixel(int x, int y, int tamanho, int cor) {
    this.x = x;
    this.y = y;
    this.tamanho = tamanho;
    this.cor = cor;
  }

  public void desenhar(Renderizador renderizador) {
    renderizador.desenharPixel(x, y, tamanho, cor);
  }
}
