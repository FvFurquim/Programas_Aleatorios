//Neste desafio, será importado o Scanner e o Arrays (utilizaremos o Arrays.copyOf());
//Note que foi utilizado um "*", isso significa que TUDO de java.util foi importado;

import java.util.*;

//Inicio da classe SalvandoProfessora:

public class SalvandoProfessora {
    
    //Inicio do main
	public static void main(String[] args) {
	    
	    //Inicializacao do Scanner chamado 'input':
	    
	    Scanner input = new Scanner(System.in);
	    
	    /* Para o 'while' ter alguma comparacao, eh necessario uma variavel.
	     Para isso, foi criado 'entrada' do tipo String, que sera utilizada depois;*/
	    
	    String entrada = "";
	    
	    /* Note que por conta do break (um pouco mais para baixo), 
	     a condicao do 'while' nao sera utilizada para sair do loop; */
	    
	    // Inicio do loop:
	    
	    while(!entrada.equalsIgnoreCase("fim")){
	        
	        // Entrada recebe um tipo String do usuario:
	        
	        entrada = input.nextLine();
	        
	        // Compara se usuario digitou fim:
	        
	        if(entrada.equalsIgnoreCase("fim"))
	            break;
	         
	        // Separa a entrada em todos os ", ", utilizando o metodo split:
	        
	        String[] eSeparada = entrada.split(", ");
	        
	        // Chama a funcao 'excluirRepetidos':
	        
	        String[] esSemRepetir = excluirRepetidos(eSeparada);
	        
	        // Chama a funcao 'ordemAlfabetica':
	        
	        String[] essrOrdenado = ordemAlfabetica(esSemRepetir);
	        
	        System.out.print("|");
	        
	        // Imprime o essrOrdenado:
	        
	        for(int i = 0; i < essrOrdenado.length; i++) {
	            System.out.printf("%s|", essrOrdenado[i]);
	        }
	        
	        System.out.printf("\n");
	        
	        
	        // Fim do loop:
	    }

        // Fim do main:
    
	}
	
	// Inicio da funcao que exclui todos os elementos repetidos de um array:
	
	static String[] excluirRepetidos(String[] original) {
	    
	    int tam = original.length;

        //Cria um novo String[] (para armazenar os elements sem repeticao) e dois int (que serao utilizados mais tarde)

	    String[] atualizada = new String[tam];
	    int posA = 0;
	    int removidos = 0;
	    
	    // Este loop serve para percorrer a lista original e adcionar elementos sem repeticao no novo array;
	    
	    for(int i = 0; i < tam; i++) {
	        
	        boolean repetiu = false;
	        
	        // Este loop serve para percorrer o array atualizado para comparar e verificar se nao tem enhum elemento igual ao elemento do original
	        
	        for(int j = 0; j < tam; j++) {

                // Se tiver, encrementa 'removidos' e define 'repetiu' como true;
                
    	        if(original[i].equalsIgnoreCase(atualizada[j])) {
    	            removidos++;
    	            repetiu = true;
    	        }
	        
	        }
	        
	        // Caso nao tenha repetido, significa que nao tem esse lemento na 'atualizada', entao ele sera adcionado e depois encrementara 'posA';
	        // 'posA' serve para ir para o proximo espaco vazio do 'atualizada';
	        
	        if(repetiu == false) {
	            atualizada[posA] = original[i];
	            posA++;
	            repetiu = false;
	        }

	    }
	    
	    //Atualiza o 'tam', note que agora tam condiz com o numero de elementos validos de 'atualizada';
	    
	    tam = tam - removidos;
	    
	    // Atualiza a atualizada com uma copia da 'atualizada', porem sem conter espaco que nao foi utilizado;
	    // o metodo 'Arrays.copyOf' faz uma copia do array passado coo parametro ate a posicao indicada, tambem passada como parametro;
	    
	    atualizada = Arrays.copyOf(atualizada, tam);
	    
	    return atualizada;
	    
	    // Fim da funcao 'excluirRepetidos':
	}
	
	// Inicio da funcao que coloca todos os elementos de um array em ordem alfabetica:
	
	static String[] ordemAlfabetica(String[] original) {
	    
	    boolean ordenado = false;
	    
	    // Loop para rodar constantemente ate que o array esteja ordenado;
	    
	    while(ordenado == false) {
	        
	        ordenado = true;
	        
	        //Loop para andar no array;
	        
	        for(int i = 1; i < original.length; i++) {
	            
	            /* Compara-se quem vem antes utilizando a funcao 'compareTo()'.
	            Essa funcao compara duas strings e retorna um inteiro. Considere como exemplo 'A.compareTo(B)'. A funcao retornara:
	            - O caso A seja igual a B (Exemplo: A = "Batata" B = "Batata").
	            - Maior ou igual a 1 caso A va alfabeticamente depois de B (Exemplo: A = "Batata" B = "Almondega"
	            - Menor ou igual a -1 caso A venha alfabeticamente depois de B (Exemplo: A = "Batata" B = "Brocolis")*/
	            
	            int quemVemAntes = original[i-1].compareTo(original[i]);
	            
	            // Caso seja >= 1, significa que estao fora de ordem, entao eles invertem de posicao;
	            // Para isso, foi utilizado uma variavel temporaria 'temp';
	            
	            if(quemVemAntes >= 1) {
	                String temp = original[i-1];
	                original[i-1] = original[i];
	                original[i] = temp;
	                ordenado = false;
	            }
	        }
	    }
	    
	    return original;
	    
	    // Fim da funcao 'ordemAlfabetica':
	}
	
	// Fim da classe:
}
