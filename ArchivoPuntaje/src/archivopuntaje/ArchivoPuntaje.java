package archivopuntaje;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ArchivoPuntaje {

  
    public static void main(String[] args) {
        
        int scoreAleatorio;
        Random numeroAleatorio = new Random ();
        scoreAleatorio=numeroAleatorio.nextInt(101);
        /**System.out.println("Numeros aleatorios del 0 al 100: " + scoreAleatorio );**/   
        
        for (int i=0 ; i<=scoreAleatorio ; i++ ){
            scoreAleatorio=numeroAleatorio.nextInt(101);
        
            try {
                File file = new File("Score.txt");
                    
                    if (!file.exists()){
                        file.createNewFile();
                    }
            
                    FileWriter Sobrescribe = new FileWriter(file.getAbsoluteFile(),true);
                    try(BufferedWriter Score = new BufferedWriter(Sobrescribe)) {
                        Score.write("Score: " + scoreAleatorio);
                        Score.write("\n");
                        Score.newLine();
                        Score.close();
                    }
                }catch (IOException e){
                 System.out.println("Error: " + e);
                 } 
    }
         }
}
