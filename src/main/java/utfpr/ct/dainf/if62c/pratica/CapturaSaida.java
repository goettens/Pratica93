/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author Guilherme
 */
public class CapturaSaida extends Thread{
    
    private final InputStream in;
    private final OutputStream out;

    public CapturaSaida(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run(){
        try{
            String s;
            InputStreamReader in2 = new InputStreamReader(in);
            OutputStreamWriter out2 = new OutputStreamWriter(out);
            
            BufferedReader bufferR = new BufferedReader(in2);
            BufferedWriter bufferW = new BufferedWriter(out2);
            
           
            while ((s=bufferR.readLine()) != null){
                bufferW.write(s);
            }
            
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
