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
        String comando;
        List<ExecCmd> execCmd = new ArrayList<>();
        int i = 0;
        while (true) {
            System.out.println("comando>");
            comando = in.nextLine();
            if (comando.equals("fim")) {
                for (ExecCmd e : execCmd) {
                    if (!e.terminado()) {
                        i++;
                    }
                }
                if (i > 0) {
                    System.out.println("Há " +i+ " processos em execução. Deseja terminá-los? (s/n)");
                    if (in.next().equals("s")) {
                        for (ExecCmd c : execCmd) {
                            if (!c.terminado()) {
                                c.cancela();
                            }
                        }
                        break;
                    }
                }
                if (i == 0){
                    break;
                }
            }
            else {
                ExecCmd exe = new ExecCmd(comando);
                execCmd.add(exe);
                exe.start();
            }
            i = 0;
        }
    }
}