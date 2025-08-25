package org.example;

import java.util.ArrayList;

public class Mundo {
  private final ArrayList<Pixel> pixels = new ArrayList<>();
  private Pixel pixelArrastado = null;
  private int offsetX, offsetY;

  public Mundo() {
    pixels.add(new Pixel(100, 150, 10, 0xFFFFFF));
    pixels.add(new Pixel(250, 150, 20, 0xFF0000));
  }

  public void desenhar(Renderizador renderizador) {
    renderizador.limpar(0);
    for (Pixel p : pixels) {
      p.desenhar(renderizador);
    }
  }

  public void notificarPressionado(int mouseX, int mouseY) {
    for (int i = pixels.size() - 1; i >= 0; i--) {
      Pixel p = pixels.get(i);
      if (p.contemPonto(mouseX, mouseY)) {
        pixelArrastado = p;
        offsetX = mouseX - p.x;
        offsetY = mouseY - p.y;
        return;
      }
    }
  }

  public void notificarArrastado(int mouseX, int mouseY) {
    if (pixelArrastado != null) {
      int novoX = mouseX - offsetX;
      int novoY = mouseY - offsetY;

      if (isMovimentoValido(pixelArrastado, novoX, novoY)) {
        pixelArrastado.x = novoX;
        pixelArrastado.y = novoY;
      }

    }
  }

  public void notificarSolto() {
    pixelArrastado = null;
  }

  private boolean isMovimentoValido(Pixel pixelEmMovimento, int novoX, int novoY) {
    if (novoX < 0 || (novoX + pixelEmMovimento.tamanho) > App.LARGURA ||
        novoY < 0 || (novoY + pixelEmMovimento.tamanho) > App.ALTURA) {
      return false;
    }

    for (Pixel outroPixel : pixels) {
      if (outroPixel == pixelEmMovimento) {
        continue;
      }

      Pixel cloneNaNovaPosicao = new Pixel(novoX, novoY, pixelEmMovimento.tamanho, 0);

      if (cloneNaNovaPosicao.colideCom(outroPixel)) {
        return false;
      }
    }

    return true;
  }
}
