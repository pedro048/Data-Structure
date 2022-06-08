
package Projeto06;

public class FenwickTree{

    int value;
    int leftSize;
    FenwickTree left, right;
            
    public FenwickTree(int value){ //constroi uma folha referente ao valor value
        this.value = value;
        this.left = null;
        this.right = null;
        this.leftSize = 0;            
    }
    
    public FenwickTree(int leftSize, FenwickTree left, FenwickTree right){  //constroi um no interno
        this.left = left;
        this.right = right;
        this.value = left.value + right.value;
        this.leftSize = initLeftSize(this);
    }

    public String toString(){
        String resultado = "[" + value + ", " + leftSize;
        if (this.left != null) resultado += (", " + this.left);
        if (this.right != null) resultado += (", " + this.right);
        resultado += "]";
        return resultado;
    }

    static FenwickTree allZeros(int n){
        if (n==0) return null;
        if (n==1) return new FenwickTree(0);
        int m = n/2;
        return new FenwickTree(0, allZeros(n-m), allZeros(m));   //no arquivo pdf esta de forma diferente, nao entendi o termo a mais, verifique se eu fiz errado aqui
    }

    public int size() {   //nao sei se esta sendo executando em tempo O(log n)
        if (this.right == null && this.left == null) return 1;

        if (this.right == null) return leftSize;

        int leafs = leftSize;
        leafs += this.right.size();
        return leafs;
    }

    public void increment(int i, int delta) {  //altera o valor de uma folha de acordo com o valor de delta
        if (i == 0 && left == null && right == null) {
                value += delta;
                return;
        }

        if (i < leftSize) {
            left.increment(i, delta);
        } else {
            right.increment((i-leftSize), delta);
        }
        value = left.value + right.value;
    }

    public int prefixSum(int upto) {  //retorna a soma dos valores das folhas de 0 ate o upto, veja se esta sendo em O(log n)
        if (upto == 0 && right == null && left == null) {
            return 0;
        }
        if (right == null && left == null) {
            return value;
        }

        if (upto >= leftSize) {
            return (value - right.value) + right.prefixSum(upto-leftSize);
        } else {
            return left.prefixSum(upto);
        }
    }

    public int between(int lo, int hi) {  //realiza a soma dos valores das folhas entre dois valores atribuidos
        return prefixSum(hi) - prefixSum(lo);
    }

    private int initLeftSize(FenwickTree ftree){  //conta quantas folhas estao a esquerda
        int leafs = 0;
        if(ftree.left != null) leafs += countLeafs(ftree.left);
        return leafs;
    }

    private int countLeafs(FenwickTree ftree){  //realiza a contagem de quantas folhas a arvore tem em seu total
        if(ftree.left == null && ftree.right == null) return 1;
        
        int cnt = 0;
        if(ftree.left != null) cnt += countLeafs(ftree.left);
        if(ftree.right != null) cnt += countLeafs(ftree.right);
        return cnt;
    }
   /* 
public static void main(String[] args){
System.out.println("Construcao de FenwickTree(3) : " + new FenwickTree(3));
System.out.println("Construcao da arvore da figura : " +
new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
new FenwickTree(1, new FenwickTree(3),
new FenwickTree(1, new FenwickTree(6), new FenwickTree(1)))));
}
*/
  /*   
public static void main(String[] args){
System.out.println("Construcao de allZeros(3) : " + FenwickTree.allZeros(3));
System.out.println("Construcao de allZeros(4) : " + FenwickTree.allZeros(4));
System.out.println("Construcao de allZeros(5) : " + FenwickTree.allZeros(5));
System.out.println("Construcao de allZeros(6) : " + FenwickTree.allZeros(6));
}
 */   
    /*
    public static void main(String[] args){
// teste de correcao
System.out.println("Verificacao de correcao da funcao...");
System.out.println("Tamanho de FenwickTree(6) : "
+ (new FenwickTree(6)).size());
System.out.println("Tamanho de allZeros(6) : "
+ (FenwickTree.allZeros(6)).size());
System.out.println("Tamanho de allZeros(12) : "
+ (FenwickTree.allZeros(12)).size());
FenwickTree T1 = new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
new FenwickTree(1, new FenwickTree(3),
new FenwickTree(1, new FenwickTree(6), new FenwickTree(1))));
System.out.println("Arvore this : " + T1);
System.out.println("Tamanho de this : " + T1.size());
}
    */
    /*
    public static void main(String[] args){
// teste de correcao
System.out.println("Verificacao de correcao da funcao...");
FenwickTree T = new FenwickTree(3,
new FenwickTree(1, new FenwickTree(0),
new FenwickTree(1, new FenwickTree(0), new FenwickTree(0))),
new FenwickTree(1, new FenwickTree(0),
new FenwickTree(1, new FenwickTree(0), new FenwickTree(0))));
System.out.println("Arvore this : " + T);
T.increment(0, 4);
System.out.println("Resultado de increment(0, 4) : " + T);
T.increment(1, 2);
System.out.println("Resultado de increment(1, 2) : " + T);
T.increment(2, 5);
System.out.println("Resultado de increment(2, 5) : " + T);
T.increment(3, 3);
System.out.println("Resultado de increment(3, 3) : " + T);
T.increment(4, 6);
System.out.println("Resultado de increment(4, 6) : " + T);
T.increment(5, 1);
System.out.println("Resultado de increment(5, 1) : " + T);
}
    */
    /*
    public static void main(String[] args){
// teste de correcao
System.out.println("Verificacao de correcao da funcao...");
FenwickTree T = new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
new FenwickTree(1, new FenwickTree(3),
new FenwickTree(1, new FenwickTree(6), new FenwickTree(1))));
System.out.println("Arvore this : " + T);
System.out.println("Soma das primeiras folhas : ");
for(int upto = 0; upto <= 6; upto++)
System.out.println("prefixSum(" + upto + ") : " + T.prefixSum(upto));
}
    */
/*
    public static void main(String[] args){
FenwickTree T = new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
new FenwickTree(1, new FenwickTree(3),
new FenwickTree(1, new FenwickTree(6), new FenwickTree(1))));
System.out.println("Arvore this : " + T);
System.out.println("Soma das folhas entre lo e hi : ");
System.out.print(" ");
for(int lo = 0; lo <= 6; lo++)
System.out.print("lo = " + lo + " ");
System.out.println();
for(int hi = 0; hi <= 6; hi++){
System.out.print("hi = " + hi + " ");
for(int lo = 0; lo <= hi; lo++){
System.out.print(T.between(lo, hi) + " ");
if(T.between(lo, hi) < 10) System.out.print(" ");
}
System.out.println();
}
}
  */  
}
