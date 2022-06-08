
package projeto04;

import java.io.*;
import static java.lang.System.exit;
import java.util.NoSuchElementException;

public class CalcRPN {
        Pilha<Double> aPilha;
        Pilha<Operacao> hist; // Pilha do historico
	public CalcRPN(){
		aPilha = new Pilha<>();	
		hist = new Pilha<>();
	}
	public void mais() throws Error{
            try{
		Double a = aPilha.desempilha();
		Double b = aPilha.desempilha();
		Double reseultado = a + b; 
                hist.empilha(new Operacao('+', a, b));
		aPilha.empilha(reseultado);
            }catch(NoSuchElementException vazia){
                throw new Error("A pilha nao tem elementos");
            }
	}
	public void menos() throws Error{
            try{
		Double a = aPilha.desempilha();
		Double b = aPilha.desempilha();
		Double reseultado = b - a; 
                hist.empilha(new Operacao('-', b, a));
		aPilha.empilha(reseultado);
            }catch(NoSuchElementException vazia){
                throw new Error("A pilha nao tem elementos");
            }
	}
	public void vezes() throws Error{
            try{
		Double a = aPilha.desempilha();
		Double b = aPilha.desempilha();
		Double reseultado = a * b; 
                hist.empilha(new Operacao('*', a, b));
		aPilha.empilha(reseultado);
            }catch(NoSuchElementException vazia){
                throw new Error("A pilha nao tem elementos");
            }
	}
	public void dividido() throws Error{
            try{
		Double a = aPilha.desempilha();
		Double b = aPilha.desempilha();
		Double reseultado = b / a; 
                hist.empilha(new Operacao('/', b, a));
		aPilha.empilha(reseultado);
            }catch(ArithmeticException op_falha){
                throw new Error("Operacao feita da forma errada");
            }catch(NoSuchElementException vazia){
                throw  new Error("A pilha nao tem elementos");
            }
	}
	public Double resultado() throws Error{
            try{
                hist.empilha(new Operacao(aPilha.topo()));
		return aPilha.topo();  
            }catch(NoSuchElementException vazia){
                throw new Error("A pilha nao tem elementos");
            }
	}
        
        public void cancela(){
            try{
                if(hist.topo().code.equals('e')){
                    aPilha.desempilha();
                    hist.desempilha();
                    System.out.println("Historico = "+ hist.toStringInverse());
                }else{
                    aPilha.desempilha();
                    aPilha.empilha(hist.topo().b);
                    aPilha.empilha(hist.topo().a);
                    hist.desempilha();
                    System.out.println("Historico = "+ hist.toStringInverse());
                }
            }catch(NoSuchElementException vazia){
                throw new Error("A pilha nao tem elementos");
            }
	}
	public void exec(String cmd){
		switch(cmd){
		case "+":
			mais();
			break;
		case "-":
			menos();
			break;
		case "*":
			vezes();
			break;
		case "/":
			dividido();
			break;
                case "hist":
                    System.out.println("Historico = "+ hist.toStringInverse());
                    break;
                case "undo":
                    cancela();
                    break;
		case "clear":
			aPilha.reinicialize();
                        hist.reinicialize();
			break;
		default:
			Double elem = Double.parseDouble(cmd);
			aPilha.empilha(elem);
                        hist.empilha(new Operacao(elem));
		}
	}
        static void test() {
CalcRPN calc = new CalcRPN() ;
System.out.print("3 2 + = ");
calc.aPilha.empilha(3.0);
calc.aPilha.empilha(2.0);
calc.mais();
System.out.println(calc.resultado());
calc = new CalcRPN();
System.out.print("3 2 - = ");
calc.aPilha.empilha(3.0);
calc.aPilha.empilha(2.0);
calc.menos();
System.out.println(calc.resultado());
calc = new CalcRPN();
System.out.print("3 2 * = ");
calc.aPilha.empilha(3.0);
calc.aPilha.empilha(2.0);
calc.vezes();
System.out.println(calc.resultado());
calc = new CalcRPN();
System.out.print("3 2 / = ");
calc.aPilha.empilha(3.0);
calc.aPilha.empilha(2.0);
calc.dividido();
System.out.println(calc.resultado());
calc = new CalcRPN();
System.out.print("1 2 + 3 4 - / 10 3 - * = ");
calc.aPilha.empilha(1.0);
calc.aPilha.empilha(2.0);
calc.mais();
calc.aPilha.empilha(3.0);
calc.aPilha.empilha(4.0);
calc.menos();
calc.dividido();
calc.aPilha.empilha(10.0);
calc.aPilha.empilha(3.0);
calc.menos();
calc.vezes();
System.out.println(calc.resultado());
}
        
static void interfaceUsuario() throws IOException {
CalcRPN calc = new CalcRPN() ;
String line;
BufferedReader reader = new BufferedReader
(new InputStreamReader (System.in));
while((line = reader.readLine()) != null) {
if (line.isEmpty())
continue;
for (String s : line.split(" "))
calc.exec(s);
System.out.println("Pilha = " + calc.aPilha);
}
System.out.println("At´e logo");
}

        
        public static void main(String[] args) throws IOException {
            //test();
            interfaceUsuario();
        }
    }