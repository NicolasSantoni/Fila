/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filanicolass63b;

/**
 *
 * @author Nicolas
 */
public class Processo {
    private int id;
    private long tarefa;

    public Processo(int id, long tarefa){
        this.id = id;
        this.tarefa = tarefa;
    }

    public boolean executa(){
        if(this.tarefa>0){
            this.tarefa--;
            return true;
        }
        return false;
    }
    public String toString(){
        return "Id: "+this.id+" C: "+this.tarefa;
    }
}

