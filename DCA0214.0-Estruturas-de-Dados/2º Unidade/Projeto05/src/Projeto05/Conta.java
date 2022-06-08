
package Projeto05;


public class Conta {

    private String nomeCliente;
    private String saldo;
    private String agencia;
    private String numero;
    private String senha;
    private String md5;
    
    Conta(String agencia, String numero, String senha){
        this.agencia = agencia;
        this.numero = numero;
        this.senha = senha;
        md5  = SecurityProvider.md5ToServer(this);
    }
    Conta(String agencia,String numero,String senha,String saldo,String nomeCliente){
        this.agencia = agencia;
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
        this.nomeCliente = nomeCliente;
        md5  = SecurityProvider.md5ToServer(this);
    }
    Conta(String nomeCliente, String saldo){
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
        md5 = null;
    }
    public String getNomeCliente(){
        return nomeCliente;
    }
    public String getSaldo(){
        return saldo;
    }
    public String getAgencia(){
        return agencia;
    }
    public String getNumero(){
        return numero;
    }
    public String getSenha(){
        return senha;
    }
    public String getMD5(){
        return md5;
    }
    public void setNomeCliente(String NomeCliente){
        this.nomeCliente = NomeCliente;
    }
    public void setSaldo(String Saldo){
        this.saldo = Saldo;
    }
    public void setNumero(String Numero){
        this.numero = Numero;
    }
    public void setAgencia(String Agencia){
        this.agencia = Agencia;
    }
    public void setSenha(String Senha){
        this.senha = Senha;
    }
    
    public String toString() {
        String str = "";
        str += "AGENCIA: " + agencia + "\n";
        str += "CONTA: " + numero + "\n";
        str += "SENHA: " + senha + "\n";
        str += "NOME CLIENTE: " + nomeCliente + "\n";
        str += "SALDO: " + saldo + "\n";
        str+= "MD5: " + md5 + "\n";
        return str;
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
        test();
    }
   
}



