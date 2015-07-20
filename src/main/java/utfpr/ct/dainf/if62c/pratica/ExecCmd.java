/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.IOException;

/**
 *
 * @author Guilherme
 */
public class ExecCmd extends Thread{
    String cmd;
    protected Process p;

    public ExecCmd(String cmd) {
        this.cmd = cmd;
    }
    
    @Override
    public void run(){
        Runtime r = Runtime.getRuntime();
        //System.out.println("Executando > "+ cmd);
        try{
            p = r.exec(cmd);
            p.waitFor();
        }catch (IOException e){
            System.out.println("O comando não foi executado");
        }catch (InterruptedException e){
            System.out.println("O processo foi fechado");
        }
    }
    
    public synchronized void cancela(){
        if(p != null){
            p.destroy();
        }
    }
    
    public boolean terminado(){
        return !p.isAlive();
    }
    
}
