import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "lista.txt";

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String linha;

        int totalSeguros = 0;    

        while ((linha = reader.readLine()) != null) {
            String[] elementos = linha.split(" ");
            

            int[] numeros = new int[elementos.length];
            for(int i=0; i<elementos.length; i++){
                numeros[i] = Integer.parseInt(elementos[i]);
            }
            
            if(isSeguro(numeros)){
                totalSeguros++;
            }else {
                for(int i = 0; i < numeros.length; i++){
                    int[] modificado = removeElementos(numeros, i);
                    if(isSeguro(modificado)){
                        totalSeguros++;
                        break;
                    }
                }
            }
        }
        reader.close();

        System.out.print(totalSeguros);
    }


    private static boolean isSeguro(int[] numeros){
        boolean crescente = true;
        boolean decrescente = true;
        boolean DiferencaValida = true;


        for(int i = 0; i < numeros.length - 1; i++){
            int diferenca = Math.abs(numeros[i] - numeros[i + 1]);
            if(diferenca < 1 || diferenca > 3){
                DiferencaValida = false;
                break;
                }

            if (numeros[i] > numeros[i + 1]){
                crescente = false;
                }

            if (numeros[i] < numeros[i + 1]){
                decrescente = false;
                }
            }

            return DiferencaValida && (crescente || decrescente);
    }

    private static int[] removeElementos(int[] numeros, int index){
        int [] novoArray = new int[numeros.length - 1];
        int pos = 0;
        for(int i = 0; i < numeros.length; i++){
            if(i != index){
                novoArray[pos++] = numeros[i];
            }
        }

        return novoArray;
    }
}
