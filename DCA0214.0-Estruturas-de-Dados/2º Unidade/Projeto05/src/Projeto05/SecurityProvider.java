
package Projeto05;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecurityProvider
{
    public static String salt = "5a1t";
    public static String md5(String stringToConvert){
        String hashtext="";
        stringToConvert +=salt;
        MessageDigest m;
        try{
            m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(stringToConvert.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            hashtext = bigInt.toString(16);
        }
        catch (NoSuchAlgorithmException ex)
        {
            Logger.getLogger(SecurityProvider.class.getName()).
            log(Level.SEVERE, null, ex);
        }
        return hashtext;
    }
   
    public static String md5ToServer(Conta conta){
        if(conta.getAgencia()==null || conta.getNumero()==null || conta.getSenha()==null){
            return null;
        }
        String cat= conta.getAgencia()+conta.getNumero()+conta.getSenha()+SecurityProvider.salt;
        cat = md5(cat);
        return cat;
    }
    
    public static String[] md5ToClient(Conta conta) {
	String toCrypt = conta.getNomeCliente() + " " + conta.getSaldo();
	String[] str = new String[toCrypt.length()];
	for (int i = 0; i < str.length; i++) {
		str[i] = md5(toCrypt.substring(i, i + 1));
	}
	return str;
    }
    
    public static void test1(){
        System.out.println(SecurityProvider.md5("teste"));
    }
    
    public static void test2() {
        Conta c = new Conta("1234", "2222", "1245");
        System.out.println(SecurityProvider.md5ToServer(c));
    }
    
     public static void test() {
        Conta c1 = new Conta("124", "333", "1234", "10", "john doe");
        System.out.println(c1);
        Conta c2 = new Conta("John Doe", "10");
        System.out.println(c2);
        Conta c3 = new Conta("123", "321", "666");
        System.out.println(c3);
    }
     
    public static void main(String[] args) {
        System.out.println("---TESTE 1---");
        test1();
        System.out.println("---TESTE 2---");
        test2();
        System.out.println("---TESTE 3--");
        test();
    }
    
  
}
