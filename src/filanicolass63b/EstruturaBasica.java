package filanicolass63b;

/**
 *
 * @author Rodrigo Henrich
 */
public class EstruturaBasica<T> {
  
  private T[] elementos;
  private int tamanho;
  
  public EstruturaBasica(){
    tamanho = 0;
    elementos = (T[]) new Object[10];
  }
  
  public EstruturaBasica(int tamanhoIncial){
    tamanho = 0;
    elementos = (T[]) new Object[tamanhoIncial];
  }
  
  /**
   * método que adiciona um elemento no final da lista
   * @param elemento elemento a ser adicionado
   * @return true caso o elemento seja adcionado a lista ou false em caso de algum erro
   */
  protected boolean adiciona(T elemento){
    aumentaCapacidade();
    if(tamanho<elementos.length){
      elementos[tamanho] = elemento;
      tamanho++;
      return true;
    }
    return false;
  }
  /**
   * Adiciona um elemento a qualquer posição da lista, desde que ela seja válida
   * @param posicao posição da lista onde adicionar o elemento
   * @param elemento o elemento a ser adicionado na lista
   * @return true em caso de sucesso e lança uma IllegalArgumentException em caso de falha
   */
  protected boolean adiciona(int posicao, T elemento){
    aumentaCapacidade();
    if(!(posicao>=0&&posicao<tamanho)){
      throw new IllegalArgumentException(posicao+" não é uma posição válida");
    }
    for (int i = tamanho-1; i>=posicao; i--) {
      elementos[i+1] = elementos[i];
    }
    elementos[posicao] = elemento;
    tamanho++;
    return true;
  }

  /**
   * Permite remover um elemento de determinada posição
   * @param posicao posição que deseja apagar
   * @return devolve o elemento presente na posição removida
   * @throws IllegalArgumentException caso a posição seja inválida
   */
  protected T remove(int posicao){
    if(!(posicao>=0 && posicao<tamanho))
      throw new IllegalArgumentException(posicao+" não é uma posição válida");
    T elemento = elementos[posicao];
    for (int i = posicao; i < tamanho-1; i++) {
      elementos[i] = elementos[i+1];
    }
    tamanho--;
    return elemento;
  }
  /**
   * Este método remove o elemento recebido como parâmetro se ele existir
   * @param elemento elemento a ser removido
   * @return true - se o elemento foi apagado e false - caso ele não seja encontrado;
   */
  protected boolean remove(T elemento){
    //Pequisar se o elemento existe na minha lista
    int posicao = -1;
    for (int i = 0; i < tamanho&&posicao==-1; i++) {
      if(elementos[i].equals(elemento))
        posicao = i;
    }
    //Removendo o elemento da lista se ele foi localizado
    if(posicao>=0){
      for (int i = posicao; i < tamanho-1; i++) {
        elementos[i] = elementos[i+1];
      }
      tamanho--;
      return true;
    }
    return false;
  }
  
//  public boolean remove(T elemento){
//    int posicao = posicaoDe(elemento);
//    if(posicao>=0){
//      remove(posicao);
//      return true;
//    }
//    return false;
//  }
  /**
   * Remove o último elemento da lista
   * @return retorna o elemento removido
   */
  public T remove(){
    T elemento = elementos[tamanho-1];
    tamanho--;
    return elemento;
  }
  
  /**
   * Método que busca um elemento pela posição no vetor
   * @param posicao posição do elemento pesquisado
   * @return o elemento da posição, caso a posição seja inválida o método retorno uma IllegalArgumentException
   */
  public T obterElemento(int posicao){
    if(!(posicao>=0 && posicao<tamanho))
      throw new IllegalArgumentException(posicao+" não é uma posição válida");
    return elementos[posicao];
  }
  
  /**
   * Método que pesquisa a posição de determinado elemento na lista
   * @param elemento elemento a ser buscado
   * @return a posição do elemento na lista ou -1 caso o elemento não seja encontrado
   */
  public int posicaoDe(T elemento){
    for (int i = 0; i < tamanho; i++) {
      if(elementos[i].equals(elemento))
        return i;
    }
    return -1;
  }
  /**
   * Método que pesquisa por um elemento na lista e devolve a última ocorrência se não houver elementos duplicados
   * o funcionamento é o mesmo do posicaoDe
   * @param elemento
   * @return a última posição da lista onde encontrar o elemento ou -1 se não econtrar
   */
  public int ultimaPosicaoDe(T elemento){
    int posicao=-1;
    for(int i=0;i<tamanho;i++){
      if(elementos[i].equals(elemento))
        posicao = i;
    }
    return posicao;
  }
  /**
   * método que apaga todo o conteúdo da lista
   */
  public void limpar(){
    tamanho = 0;
  }
  
  /**
   * método que verifica se um elemento existe na minha lista
   * @param elemento elemento a ser pesquisado
   * @return true se o elemento existir e false se não
   */
  public boolean contem(T elemento){
    for (int i = 0; i < tamanho; i++) {
      if(elementos[i].equals(elemento))
        return true;
    }
    return false;
  }
  
//  public boolean contem(T elemento){
//    return posicaoDe(elemento) != -1;
//  }
  
  public int tamanho(){
    return tamanho;
  }
  
  public boolean estaVazia(){
    if(tamanho==0)
      return true;
    return false;
  }
  
//  public boolean estaVazia(){
//    return tamanho==0;
//  }
  
  private void aumentaCapacidade(){
    if(tamanho==elementos.length){
      T[] listaAux = (T[]) new Object[elementos.length*2];
      //System.arraycopy(elementos, 0, listaAux, 0, elementos.length);
      for (int i = 0; i < elementos.length; i++) {
        listaAux[i] = elementos[i];
      }
      elementos = listaAux;
    }
  }
  
  @Override
  public String toString(){
    //[1, 2, 3, 4, 5,]
    String retorno = "[";
    if(tamanho>0){
      for(int i=0;i<tamanho-1;i++){
        retorno+=elementos[i]+", ";
      }
      retorno+=elementos[tamanho-1]+"]";
    }
    else
      retorno+="]";
    return retorno;
  }
}
