import java.util.ArrayList;
import java.util.List;

public class Conta implements IMovimentos, ElementosDoBanco {
	
	// -- Atributos -- //
	
	// Principais
	private int conta;
	private String abertura;
	private boolean status;
	private String senha;
	private float saldo;
	private Pessoa titular;
	
	// Tipo da conta
	private static final String tipo = "Conta Comum";
	
	// Movimentos
	private List<Movimento> movimentos = new ArrayList<>();
	//private List<String> movimentos = new ArrayList<>();
	
	
	// -- Construtor -- //
	public Conta(int conta, String abertura, boolean status, String senha, float saldo, Pessoa titular) {
		this.conta = conta;
		this.abertura = abertura;
		this.status = status;
		this.senha = senha;
		this.saldo = saldo;
		this.titular = titular;
	}
	
	// -- Getters e Setters -- //
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}

	public String getAbertura() {
		return abertura;
	}
	public void setAbertura(String abertura) {
		this.abertura = abertura;
	}

	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Pessoa getTitular() {
		return titular;
	}
	public void setTitular(PessoaFisica titular) {
		this.titular = titular;
	}
	
	public List<Movimento> getMovimentos() {
		return movimentos;
	}
	public void addMovimentos(Movimento movimento) {
		movimentos.add(movimento);
	}
	
	// Retorna o tipo da conta
	public String getTipo() {
		return tipo;
	}
	
	// Métodos da interface IMovimentos
	public void deposito(float deposito) {
		saldo += deposito;
		movimentos.add(new Movimento("Deposito", deposito));
	}
	
	public void saque(float saque) {
		saldo -= saque;
		movimentos.add(new Movimento("Saque", saque));
	}
	
	public void atualizaTaxa() {
		saldo -= 20;
		movimentos.add(new Movimento("Taxa", 20.0f));
	}
	
	
	// Relatório
	public void relatorio() {
		System.out.println("-------------------------------");
		System.out.println("Conta : " + getConta());
		System.out.println("Tipo : " + getTipo());
		System.out.println("Abertura: " + getAbertura());
		if (status) {
			System.out.println("Status : Ativa");
		} else {
			System.out.println("Status : Desativada");
		}
		System.out.println("Titular : " + titular.toString());
		System.out.println("Movimentos:");
		int qtd = 0;
		for (Movimento s: movimentos) {
			qtd++;
			System.out.println(qtd + "	" + s.movimento());
		}
		System.out.println("Saldo: " + getSaldo());
	}
	
	@Override
	public String toString() {
		return "Conta [numero=" + getConta() + ", dataAbertura=" + getAbertura() + ", status=" + getStatus() + ", senha=" + getSenha() + ", saldo=" + getSaldo() + ", titular=" + getTitular() + ", movimentos=" + getMovimentos() + "]";
	}
	
	public String getElementoInfo() {
		return toString();
	}
}
