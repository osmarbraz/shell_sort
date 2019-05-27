/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplina: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 *
 * Página 42 Thomas H. Cormen 3 ed
 *
 * Algoritmo ShellSort/Ordenação com incrementos descrescente. 
 * É um método baseado no método Insertsort.  Criado por Donald L. Shell em 1959.
 *
 * Atenção:
 * Vetor em java inicia em 0, os algoritmos consideram início em 1.
 * A subtração de -1 ocorre somente no local de acesso ao vetor ou matriz 
 * para manter a compatibilidade entre os algoritmos.
 * 
 */

/**
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal {

    /**
     * Ordenação por Inserção.
     *
     * Inicialmente, pega os dois primeiros elementos de um vetor, ou seja, posições 0 e 1 considerando o salto
     * 1. Atribui o elemento na posição 1 como chave 
     *    Compara a chave com todos os elementos cujos respectivos índices sejam inferiores 
     *      - Até que encontre um menor valor menor que o da chave; OU 
     *      - O início do vetor seja atingido. 
     * 2. Repete o processo até o último elemento do vetor
     *
     * Complexidade de tempo no pior caso Theta(n^2) 
     * Complexidade de tempo no caso médio/esperado O(n^2) 
     * Complexidade de tempo no melhor caso O(n)
     * 
     * @param A Vetor a ser ordenado
     * @param n Quantidade de elementos do vetor
     * @param salto Quantidade de saltos
     * 
     */
    public static void ordenaPorInsercao(int A[], int n, int salto) {
       for (int j = 2; j <= n - salto; j++) {                           //c1 * n
            int chave = A[j + salto - 1];                               //c2 * n-1
            //Inserir A[j] dentro da sequência ordenada A[1..j-1]
            //Compara chave com elementos posicionados antes no vetor(j-1)
            //Para se pelo menos uma das situações ocorrer:
            //Alcançar o início do vetor(i>=0) ou a elemento anterior for maior que a chave
            int i = j + salto - 1;                                      //c3 * n-1
            while ((i >= salto) && (A[i - salto] > chave)) {            //c4 * Somatorio(2 até n)tj
                //Desloca os elementos para abrir espa;o
                A[i] = A[i - salto];                                    //c5 * Somatorio(2 até n)tj-1
                //Decrementa o contador até o inicio do vetor
                i = i - salto;                                          //c6 * Somatorio(2 até n)tj-1
            } 
            //posição de inserção
            A[i] = chave;                                               //c7 * n - 1
        }
    }
   
   /**
    * ´Ordenação por incrementos descrecentes(Shellsort).
    * 
    * Complexidade de tempo no pior caso O(n log n) 
    * Complexidade de tempo no caso médio/esperado dependende do salto
    * Complexidade de tempo no melhor caso O(n log n) 
    * 
    * @param A Vetor a ser ordenado.
    * @param n Tamanho do vetor.
    */
    public static void shellsort(int A[], int n) {
        //Reduz o pasos dividindo por 2
        //8 elementos geral a sequência 8,4,2,1
        for (int salto = n; salto >= 1; salto=salto/2) {            
            ordenaPorInsercao(A, n, salto);
        }
    }

    public static void main(String args[]) {

        //Vetor dos dados        
        int A[] = {50, 70, 60, 90, 10, 30, 20, 40};

        //Fim do vetor
        int r = A.length;

        System.out.println(">>> Algoritmo ShellSort/Ordenação por incrementos descrescentes <<<");
        System.out.println("Original: ");
        for (int i = 0; i < r; i++) {
            System.out.println((i + 1) + " - " + A[i]);
        }

        shellsort(A, r);

        System.out.println("Depois: ");
        for (int i = 0; i < r; i++) {
            System.out.println((i + 1) + " - " + A[i]);
        }
    }
}