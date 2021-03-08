package filanicolass63b;

/**
 *
 * @author Rodrigo
 */
public class Fila<T> extends EstruturaBasica<T> {
  
  public Fila(int capacidadeInicial){
    super(capacidadeInicial);
  }
  
  public Fila(){
    super();
  }
  
  public boolean enfileirar(T elemento){
    return adiciona(elemento);
  }
  
  public T proximo(){
    return obterElemento(0);
  }
  //O 0 representa a primeira posição da minha fila
  public T desenfileirar(){
    return remove(0);
  }
}

