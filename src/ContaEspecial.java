
public class ContaEspecial extends Conta {
	
	// -- Atributos -- //
	
	// Principais
	private float limite;
	
	// Tipo da conta
	private static final String tipo = "Conta Especial";
	
	// -- Construtor -- //
	public ContaEspecial(int conta, String abertura, boolean status, String senha, float saldo, float limite, Pessoa titular) {
		super(conta, abertura, status, senha, saldo, titular);
		this.limite = limite;
	}

	// -- Getters e Setters
	public float getLimite() {
		return limite;
	}
	public void setLimite(float limite) {
		this.limite = limite;
	}

	// Retorna o tipo da conta
	public String getTipo() {
		return tipo;
	}
	
	// Métodos da interface IMovimentos
	public void atualizaTaxa() {
		float saldo = getSaldo();
		saldo -= 30;
		setSaldo(saldo);
		addMovimentos(new Movimento("Taxa", 30.0f));
		
	}
	
	// Relatório
	public void relatorio() {
		System.out.println("-------------------------------");
		System.out.println("Conta : " + getConta());
		System.out.println("Tipo : " + this.getTipo());
		System.out.println("Limite : " + getLimite());
		System.out.println("Abertura: " + getAbertura());
		if (getStatus()) {
			System.out.println("Status : Ativa");
		} else {
			System.out.println("Status : Desativada");
		}
		System.out.println("Titular : " + getTitular().toString());
		System.out.println("Movimentos:");
		int qtd = 0;
		for (Movimento s: getMovimentos()) {
			qtd++;
			System.out.println(qtd + "	" + s.movimento());
		}
		System.out.println("Saldo: " + getSaldo());
	}
	
	@Override
	public String toString() {
		return "ContaEspecial [limite=" + this.getLimite() + ", numero=" + this.getConta() + ", dataAbertura=" + this.getAbertura() + ", status=" + this.getStatus() + ", senha=" + this.getSenha() + ", saldo=" + this.getSaldo() + ", titular=" + this.getTitular() + ", movimentos=" + getMovimentos() + "]";
	}
	
	public String getElementoInfo() {
		return toString();
	}
		
}
