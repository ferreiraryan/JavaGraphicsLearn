# 🚀 Java Graphics Learn - Sandbox de Física 2D

Um sandbox de física 2D desenvolvido em Java para fins de aprendizado. O projeto simula quadrados de diferentes tamanhos que podem ser arrastados com o mouse, respondendo a forças como atrito e um efeito de mola, criando uma interação dinâmica e visual.

---

## ⚙️ Tecnologias

Este projeto foi desenvolvido com as seguintes tecnologias:

-   [Java](https://www.java.com/)
-   [Java Swing](https://docs.oracle.com/javase/tutorial/uiswing/) e [AWT (Abstract Window Toolkit)](https://docs.oracle.com/javase/tutorial/awt/) para a interface gráfica.

---

## ✨ Funcionalidades

### Simulação de Física
-   **Efeito Mola:** Os quadrados são atraídos de volta para uma posição de origem ou âncora quando arrastados.
-   **Atrito (Fricção):** O movimento dos quadrados desacelera gradualmente com o tempo, simulando atrito com o ambiente.

### Interação com o Mouse
-   **Arrastar e Soltar:** Clique e arraste os quadrados pela tela para interagir com a simulação em tempo real.

### Renderização Gráfica
-   **Múltiplos Objetos:** Renderiza e gerencia o estado de diversos quadrados (Pixels) na tela simultaneamente.

---

## 📂 Estrutura do Projeto

A lógica do projeto está dividida nos seguintes arquivos principais:

```
/JavaGraphicsLearn
├── src/
│   ├── App.java                   # Ponto de entrada, cria a janela e inicia o loop da simulação.
│   ├── Mundo.java                 # Gerencia a lógica da física e o estado de todos os objetos.
│   ├── Pixel.java                 # Representa um dos quadrados, com suas propriedades (posição, velocidade).
│   ├── Renderizador.java          # Responsável por desenhar os objetos na tela (componente visual).
│   └── GerenciadorDeEntrada.java  # Captura e processa os inputs do mouse (cliques, arrastar).
├── .gitignore
└── README.md

```

---

## 📥 Instalação e Configuração

Para executar este projeto, você precisa ter o **JDK (Java Development Kit)** instalado em sua máquina.

```bash
# 1. Clone este repositório
git clone [https://github.com/ferreiraryan/JavaGraphicsLearn.git](https://github.com/ferreiraryan/JavaGraphicsLearn.git)

# 2. Acesse o diretório
cd JavaGraphicsLearn

# 3. Rode com o gradle
./gradle run

```

---

## 🤝 Contribuindo

Sinta-se à vontade para contribuir! Basta seguir os passos abaixo:

1. Faça um **fork** do projeto.
2. Crie uma **branch** com a sua feature: `git checkout -b minha-feature`
3. Faça **commit** das suas alterações: `git commit -m 'Adiciona nova feature'`
4. Envie para o GitHub: `git push origin minha-feature`
5. Abra um **Pull Request**

---

## 📬 Contato

- **Ryan Ferreira** - [ryanferreira4883@gmail.com](mailto:ryanferreira4883@gmail.com)
- **GitHub** - [https://github.com/ferreiraryan](https://github.com/ferreiraryan)
- **LinkedIn** - [https://www.linkedin.com/in/ferryan/](https://www.linkedin.com/in/ferryan/)

---
