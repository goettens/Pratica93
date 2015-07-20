/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.pratica.*;

public class Pratica93 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        List<ExecCmd> exec = new ArrayList<>();
        String comando = "inicio";
        int i;
        
        OUTER:
        while (true) {
            System.out.println("comando>");
            if(in.hasNext()){
                comando = in.nextLine();
            }
            if ("fim".equals(comando)) {
                i=0;
                for(ExecCmd a : exec){
                    if (!a.terminado()){
                        i++;
                    }
                }
                if (i>0) {
                    System.out.println("Há "+ i +" processos em execução. Deseja terminá-los? (s/n) ");
                    String terminar = null;
                    terminar = in.next();
                    switch (terminar) {
                        case "s":
                            for(ExecCmd b : exec){
                                b.cancela();
                                exec.remove(b);
                                i--;
                            }
                            break;
                        case "n":
                            i=0;
                            System.out.println("ENTROU AQUI");
                            continue;
                    }
                }
            }
            ExecCmd e = new ExecCmd(comando);
            exec.add(e);
            e.start();
        }
    }
}
