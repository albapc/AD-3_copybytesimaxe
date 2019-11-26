package copybytesimaxe;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Alba
 */
public class Metodos {

    /*
a) partindo do que aprendiches no exercicio anterior ( copybytestexto ) saberias
copiar  o contido dun arquivo .jpg noutro ?. Comprobao copiando a imaxe foto.jpg
que se achega  nun arquivo que se denomine foto2.jpg. Canto ocupa foto2.jpg ? 
ocupa o mesmo que a imaxe orixinal?  
    Ocupa 2.5 mb como a imaxe orixinal
    
b) executa por segunda vez a aplicacion para que se engada de novo a imaxe 
foto.jpg  á imaxe foto2.jpg. ¿que ocorre se abrimos a imaxe, vese a imaxe 
repetida? , Canto ocupa agora o arquivo foto2.jpg? 
    Non se ve repetida. Ocupa 5 mb.
     */
    public static void crearCopiaImaxe() {

        try {
            FileInputStream fis = new FileInputStream("foto.jpg");
//            FileOutputStream fos = new FileOutputStream("texto2.txt"); //ex 2_1
            FileOutputStream fos = new FileOutputStream("foto2.jpg", true); //modificacion ex 2_2
            System.out.println("Arquivo copiado");
            int c;
            while ((c = fis.read()) != -1) {
//                fos.write((char)c);
                fos.write(c); //tardo 8 segundos
            }
            fis.close();
            fos.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    c) fai unha segunda version do exercicio anteior e chamaa copybytesimaxe2 
    modifica o exercicio anterior para facer o mesmo pero aumentando a 
    velocidade de copia facendo uso de ditas clases combinadas. 
    
    Notaches a diferenza en velocidade a hora de facer a copia da imaxen con
    respecto a cando NON usaches as clases BufferedInputStream e 
    BufferedOutputStream ?  Se non a notas escolle unha imaxe de maior numero de
    bytes ou executa varias veces o realiado  no apartado b) de este exercicio 
    antes de executar este apartado ( para que a imaxen sexa o suficientemente 
    grande para que se note a diferenza na velocidade de copia)
    Nótase a diferenza, esta vez tardou 3 segundos.
    */
    public static void copyBytesImaxe2() {
        try {
            FileInputStream fis = new FileInputStream("foto.jpg");
            BufferedInputStream bis = new BufferedInputStream(fis);
//            FileOutputStream fos = new FileOutputStream("texto2.txt"); //ex 2_1
            FileOutputStream fos = new FileOutputStream("foto2.jpg", true); //modificacion ex 2_2
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            System.out.println("Arquivo copiado");
            int c;
            while ((c = bis.read()) != -1) {
//                bos.write((char)c);
                bos.write(c);
            }
            bos.close();
            fos.close();
            bis.close();
            fis.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
