/* ****************************************************************
* Autor: Icaro Medeiros Lobo                                      *
* Matricula: 202310130                                            *
* Data Inicio: 13.03.2024                                         *
* Data Ultima Alteracao: 27.03.2024                               *
* Nome programa: Trabalho 01                                      *
* Funcao codigo: Trata a animacao dos objetos Trem e Text         * 
**************************************************************** */

import javafx.animation.AnimationTimer;
import javafx.scene.text.Text;

public class Animacao extends AnimationTimer { // classe responsavel por animar cada quadro
  private Trem[] trens; // trens do programa principal
  private Text velocimetro1; // texto do primeiro velocimetro
  private Text velocimetro2;// texto do segundo velocimetro

  public Animacao(Trem[] trens, Text velocimetro1, Text velocimetro2) {
    this.trens = trens;
    this.velocimetro1 = velocimetro1;
    this.velocimetro2 = velocimetro2;
  }

  /* ****************************************************************
  * Metodo: handle                                                  *
  * Funcao: chama funcoes de animacao                               *
  * Parametros: valor do tipo long                                  *
  * Saida: nenhuma                                                  *
  **************************************************************** */
  @Override
  public void handle(long now) {
    trens[0].move(); // anima o primeiro trem
    // ajusta visual do velocimetro do primeiro trem
    velocimetro1.setText("" + Math.round(trens[0].getVelocidade() * (100.0/6)));
      
    trens[1].move(); // anima o segundo trem
    // ajusta visual do velocimetro do primeiro trem
    velocimetro2.setText("" + Math.round(trens[1].getVelocidade() * (100.0/6)));

  } // fim de handle
} // fim de Animacao
