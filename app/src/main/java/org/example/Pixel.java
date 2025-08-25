package org.example;

public class Pixel {
  public int x, y;
  public int tamanho;
  public int cor;

  public Pixel(int x, int y, int tamanho, int cor) {
    this.x = x;
    this.y = y;
    this.tamanho = tamanho;
    this.cor = cor;
  }

  public boolean contemPonto(int px, int py) {
    return (px >= this.x && px < this.x + this.tamanho &&
        py >= this.y && py < this.y + this.tamanho);
  }

  public void desenhar(Renderizador renderizador) {
    renderizador.desenharPixel(this.x, this.y, this.tamanho, this.cor);
  }
}
