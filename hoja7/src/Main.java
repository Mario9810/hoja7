import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner ingreso = new Scanner(System.in);
        String source = "";
        ArrayList<String> diccionario;
        diccionario = new ArrayList<String>();
        BinaryTree<String, String> dic  = new BinaryTree<String, String>();
        String textoTraducido = "";

      
     

            try {
						/*Lee el archivo y obtiene la cadena*/
                /**\
                 *  try{
                while(entrada.ready()){
                    String parts[] = entrada.readLine().split("|");
                    cards.put(parts[0], parts[1]);
                    cartaslista.add(new Carta(parts[0], parts[1]));
                }

            }catch (IOException e) {
                System.out.println("No se halla el archivo.");

            }finally{
                try{
                    entrada.close();
                }
                catch(IOException e){
                }
            }
                 */
            BufferedReader entrada;
            entrada = new BufferedReader(new FileReader("diccionario.txt"));

                String strLine;
                while ((strLine = br.readLine()) != null) {
                    diccionario.add(strLine); //agregar cada linea al diccionario
                }

                /* Separar cadenas y hacer asociacion */
                for (int i = 0; i < diccionario.size(); i++) {
                    String temp = diccionario.get(i).substring(1, diccionario.get(i).length() - 1);
                    String[] partes = temp.split(", ");
                    dic.insert(partes[0],partes[1]);
                }
            } catch (Exception e) {
                System.out.println("Archivo no valido!!!");
            }
        

       
        


        try
        {
            BufferedReader datos = new BufferedReader(new FileReader(source));  // Abre documento para su lectura
            String rawText = datos.readLine();  // Lee la unica linea y la guarda como string
            /*en caso de punto al final*/
            rawText = rawText.substring(0, rawText.length()-1);
            String textoATraducir = rawText.toLowerCase();
            datos.close();  // Se finaliza el lector
            System.out.println("El texto Originas es: \n" + textoATraducir);
            String wIngles, wEspanol;
            StringTokenizer st = new StringTokenizer (textoATraducir);

            /* traduce las palabras*/
            while (st.hasMoreTokens())
            {
                wIngles = st.nextToken();
                wEspanol = dic.find(wIngles);
                if (wEspanol != null){
                    textoTraducido = (textoTraducido +" "+ wEspanol);
                }
                else{
                    textoTraducido = (textoTraducido + " *"+wIngles+"*");
                }

            }
            System.out.println("El texto traducido es: \n");
            textoTraducido = textoTraducido + ".";
            System.out.println(textoTraducido);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Archivo no valido!!!");
        }


        dic.display(dic.root);


    }
}