/* ****************************************************************
* Autor: Icaro Medeiros Lobo                                      *
* Matricula: 202310130                                            *
* Data Inicio: 20.03.2024                                         *
* Data Ultima Alteracao: 27.03.2024                               *
* Nome programa: Trem                                             *
* Funcao codigo: Modela a classe do trem                          *
**************************************************************** */

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Trem extends ImageView {
   
  private int inicioX;
  private int inicioY;
  private double velocidade;
  private double velocidadePadrao = 3;
  boolean esquerda;
  boolean cima;
  //top left (-70, -320)
  //top right (60, -320)
  //bot left (-70, +340)
  //bot right (60, +340)
  public Trem(boolean esquerda, boolean cima) {
   super(); // construtor do ImageView
    Image imagemTrem = new Image("img/trem.png"); // carrega imagem do rem
    setImage(imagemTrem); // adiciona imagem ao trem
    this.esquerda = esquerda;
    this.cima = cima;
    definePosicaoInicial();
    setFitHeight(50); // altura do trem
    setFitWidth(50); // largura do trem
    velocidade = velocidadePadrao;
    posicaoInicial(); // move o trem para a posicao inicial
  } // fim do construtor
      
  /* ****************************************************************
  * Metodo: definePosicaoInicial                                    *
  * Funcao: define as coordenadas da posicao inicial do trem        *
  * Parametros: nenhum                                              *
  * Saida: nenhuma                                                  *
  **************************************************************** */
  public void definePosicaoInicial() {
    // com base em esquerda-direita
    if(esquerda) {
      inicioX = -70;
    } else { // comeca na direita
      inicioX = 60;
    } //  fim do if esquerda
    
    // com base em cima-baixo
    if(cima) {
      inicioY = -320;
    } else { // comeca embaixo
      inicioY = 340;
    }
  } // fim do definePosicaoInicial

  /* ****************************************************************
  * Metodo: posicaoInicial                                          *
  * Funcao: move o trem para a posicao incial                       *
  * Parametros: nenhum                                              *
  * Saida: nenhuma                                                  *
  **************************************************************** */
  public void posicaoInicial() {
    setTranslateX(inicioX);
    setTranslateY(inicioY);
  } // fim do posicaoInicial 
  
  /* ****************************************************************
  * Metodo: move                                                    *
  * Funcao: controla o movimento do trem com base na sua posicao    *
  *         inicial                                                 *
  * Parametros: nenhum                                              *
  * Saida: nenhuma                                                  *
  **************************************************************** */
  public void move() {
    if(esquerda){ // o trem inicia na esquerda
      
      if(cima){ // o trem inicia em cima
        movePrincipal();
        moveParaBaixo();
      } else { // o trem inicia embaixo
        moveSecundaria();
        moveParaCima();
      } // fim do if topo
    
    } else { // o trem inicia na direita
      
      if(cima){ // o trem inicia em cima
        moveSecundaria();
        moveParaBaixo();
      } else { // o trem inicia embaixo
        movePrincipal();
        moveParaCima();
      } // fim do else cima
    
    } // fim do else esquerda
  
  } // fim do move

  /* ****************************************************************
  * Metodo: movePrincipal                                           *
  * Funcao: controla as curvas dos carrinhos na esquerda-cima ou    *
  *         na direita-baixo                                        *
  * Parametros: nenhum                                              *
  * Saida: nenhuma                                                  *
  **************************************************************** */
  public void movePrincipal() {
    // faz a curva adequada no intervalo adequado
    if(getTranslateY() > -280 && getTranslateY() < -210){
      setTranslateX(getTranslateX() + velocidade);
    } // faz a primeira curva
    
    if(getTranslateY() > -125 && getTranslateY() < -40){
      setTranslateX(getTranslateX() - velocidade);
    } // faz a segunda curva
    
    if(getTranslateY() > 40 && getTranslateY() < 120){
      setTranslateX(getTranslateX() + velocidade);
    } // faz a terceira curva
    
    if(getTranslateY() > 200 && getTranslateY() < 270){
      setTranslateX(getTranslateX() - velocidade);
    } // faz a quarta curva
  } // fim do moveEsquerdaCima

  /* ****************************************************************
  * Metodo: moveSecundaria                                          *
  * Funcao: controla as curvas dos carrinhos na esquerda-baixoou    *
  *         na direita-cima                                         *
  * Parametros: nenhum                                              *
  * Saida: nenhuma                                                  *
  **************************************************************** */
  public void moveSecundaria() {
    // faz a curva adequada no intervalo adequado
    if(getTranslateY() > -280 && getTranslateY() < -210){
      setTranslateX(getTranslateX() - velocidade);
    } // faz a primeira curva
    
    if(getTranslateY() > -125 && getTranslateY() < -40){
      setTranslateX(getTranslateX() + velocidade);
    } // faz a segunda curva
    
    if(getTranslateY() > 40 && getTranslateY() < 120){
      setTranslateX(getTranslateX() - velocidade);
    } // faz a terceira curva
    
    if(getTranslateY() > 200 && getTranslateY() < 270){
      setTranslateX(getTranslateX() + velocidade);
    } // faz a quarta curva
  } // fim do moveEsquerdaBaixo
 
  /* ****************************************************************
  * Metodo: moveParaBaixo                                           *
  * Funcao: move trem para baixo e faz o looping quando necessario  *
  * Parametros: nenhum                                              *
  * Saida: nenhuma                                                  *
  **************************************************************** */
  public void moveParaBaixo() {
    if(getTranslateY() > 340){
      posicaoInicial(); // faz o looping
    }
    setTranslateY(getTranslateY() + velocidade); // anda para baixo
  } // fim do moveParaBaixo

  /* ****************************************************************
  * Metodo: moveParaCima                                            *
  * Funcao: move trem para cima  e faz o looping quando necessario  *
  * Parametros: nenhum                                              *
  * Saida: nenhuma                                                  *
  **************************************************************** */
  public void moveParaCima() {
    if(getTranslateY() < -320){
      posicaoInicial(); // faz o looping
    }
    setTranslateY(getTranslateY() - velocidade); // anda para cima
  } // fim do moveParaCima
  
  /* ****************************************************************
  * Metodo: reset                                                   *
  * Funcao: reinicia a posicao e velocidade dos trens               *
  * Parametros: nenhum                                              *
  * Saida: nenhuma                                                  *
  **************************************************************** */
  public void resetTrem(){
    posicaoInicial();
    velocidade = velocidadePadrao;  
  } // fim do resetTrem

  /* ****************************************************************
  * Metodo: setEsquerda                                             *
  * Funcao: atualiza valor da variavel Boolean esquerda             *
  * Parametros: Boolean esquerda (comeca na esquerda ou direita)    *
  * Saida: nenhuma                                                  *
  **************************************************************** */
  public void setEsquerda(boolean esquerda) {
    this.esquerda = esquerda;
  } // fim do setEsquerda

  /* ****************************************************************
  * Metodo: setCima                                                 *
  * Funcao: atualiza valor da variavel Boolean cima                 *
  * Parametros: Boolean cima (comeca em cima ou embaixo)            *
  * Saida: nenhuma                                                  *
  **************************************************************** */
  public void setCima(boolean cima) {
    this.cima = cima;
  } // fim do setCima

  /* ****************************************************************
  * Metodo: incrementaVelocidade                                    *
  * Funcao: atualiza valor da variavel double Velocidade            *
  * Parametros: Double velocidade (incremento da velocidade)        *
  * Saida: nenhuma                                                  *
  **************************************************************** */ 
  public void incrementaVelocidade(double valor) {
    setVelocidade(getVelocidade() + valor);
  } // fim do incrementaVelocidade

  /* ****************************************************************
  * Metodo: getVelocidade                                           *
  * Funcao: retorna valor da velocidade                             *
  * Parametros: nenhum                                              *
  * Saida: double que reprenseta valor da velocidade                *
  **************************************************************** */  
  public double getVelocidade() {
    return velocidade;
  } // fim do getVelocidade

  /* ****************************************************************
  * Metodo: setVelocidade                                           *
  * Funcao: atualiza valor da velocidade                            *
  * Parametros: valor double que representa nova velocidade         *
  * Saida: nenhuma                                                  *
  **************************************************************** */   
  public void setVelocidade(double velocidade) { 
    this.velocidade = velocidade;
  } // fim do setVelocidade
 
  /* ****************************************************************
  * Metodo: criaTrens                                               *
  * Funcao: inicializa os trens do programa principal               *
  * Parametros: vetor do tipo Trem[] do programa principal          *
  * Saida: nenhuma                                                  *
  **************************************************************** */     
  public static void criaTrens(Trem[] trens) {
    trens[0] = new Trem(true, true); // cria o primeiro trem na posicao esquerda-cima
    trens[1] = new Trem(false, true); // cria o segundo trem na posicao direita-cima

  } // fim do criaTrens
} // fim do Trem
