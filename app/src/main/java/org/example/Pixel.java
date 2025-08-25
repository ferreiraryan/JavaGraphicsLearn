package org.example;

public class Pixel {
  public double x, y;
  public double vx, vy;
  public int tamanho;
  public double massa;
  public int cor;

  public Pixel(double x, double y, int tamanho, int cor) {
    this.x = x;
    this.y = y;
    this.tamanho = tamanho;
    this.cor = cor;

    this.vx = 0;
    this.vy = 0;
    this.massa = tamanho;
  }

  public boolean colideCom(Pixel outro) {
    if (this.x >= outro.x + outro.tamanho)
      return false;
    if (this.x + this.tamanho <= outro.x)
      return false;
    if (this.y >= outro.y + outro.tamanho)
      return false;
    if (this.y + this.tamanho <= outro.y)
      return false;
    return true;
  }

  public boolean contemPonto(int px, int py) {
    return (px >= this.x && px < this.x + this.tamanho &&
        py >= this.y && py < this.y + this.tamanho);
  }

  public void desenhar(Renderizador renderizador) {
    renderizador.desenharPixel((int) this.x, (int) this.y, this.tamanho, this.cor);
  }
}
