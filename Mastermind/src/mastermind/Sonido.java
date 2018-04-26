package mastermind;

import java.applet.AudioClip;
import java.net.URL;

public class Sonido{
    public void mov(){
        try
            {
                AudioClip sonido; 
                URL a = getClass().getResource("/recursos/Movimiento.wav");
                sonido = java.applet.Applet.newAudioClip(a);
                sonido.play();
                Thread.sleep(200);
                sonido.stop();
            }
            catch (Exception e){}
    }
}

class victoriaThread extends Thread{
    victoriaThread(){
        super();
    }
    @Override
    public void run(){
        AudioClip sonido; 
        URL a = getClass().getResource("/recursos/Victory.wav");
        sonido = java.applet.Applet.newAudioClip(a);
        try{
            while (!Thread.currentThread().isInterrupted()) {
            
            sonido.play();
            Thread.sleep(54000);
            sonido.stop();
            }
        }catch(InterruptedException ex){
            sonido.stop();
        }
    }
}

class derrotaThread extends Thread{
    derrotaThread(){
        super();
    }
    @Override
    public void run(){
        AudioClip sonido; 
        URL a = getClass().getResource("/recursos/GameOver.wav");
        sonido = java.applet.Applet.newAudioClip(a);
        try{while (!Thread.currentThread().isInterrupted()) {            
            sonido.play();
            Thread.sleep(35000);
            sonido.stop();
        }
        }catch(InterruptedException ex){            
            sonido.stop();
        }
    }   
}

class fondoThread extends Thread{
    fondoThread(){
        super();
    }
    @Override
    public void run(){
        AudioClip sonido;
            URL a = getClass().getResource("/recursos/Fondo.wav");
            sonido = java.applet.Applet.newAudioClip(a);
            
        try{while (!Thread.currentThread().isInterrupted()) {            
            sonido.loop();
            Thread.sleep(59000);
        }
        }catch(InterruptedException ex){
            sonido.stop();
        }     
    }
}