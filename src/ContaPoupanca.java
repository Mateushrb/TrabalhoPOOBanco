
public class ContaPoupanca extends Conta {
	
	// -- Atributos -- //
	
	// Principais
	private int aniversario;
	
	private float rendimentos = 0;
	
	// Tipo da conta
	private static final String tipo = "Conta Poupanca";
	
	public ContaPoupanca(int conta, String abertura, boolean status, String senha, float saldo, int aniversario, Pessoa titular) {
		super(conta, abertura, status, senha, saldo, titular);
		this.aniversario = aniversario;
	}
	
	// -- Getters e Setters
	public int getAniversario() {
		return aniversario;
	}
	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
	public void addRendimentos(float rendimento) {
		this.rendimentos += rendimento;
	}
	public float getRendimentos() {
		return rendimentos;
	}
	
	// Retorna o tipo da conta
	public String getTipo() {
		return tipo;
	}
	
	// Métodos da interface IMovimentos
	public void atualizaTaxa() {
		float saldoAnterior = getSaldo();
		float saldoNovo = getSaldo()*1.005f;
		setSaldo(saldoNovo);
		float jurus = saldoNovo - saldoAnterior;
		addMovimentos(new Movimento("Juros", jurus));
		addRendimentos(jurus);
	}
	
	// Relatório
	public void relatorio() {
		System.out.println("-------------------------------");
		System.out.println("Conta : " + getConta());
		System.out.println("Tipo : " + this.getTipo());
		System.out.println("Dia Aniversario : " + getAniversario());
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
		System.out.println("Rendimentos: " + getRendimentos());
	}
	
	@Override
	public String toString() {
		return "ContaPoupanca [diaAniversario=" + this.getAniversario() + ", numero=" + this.getConta() + ", dataAbertura=" + this.getAbertura() + ", status=" + this.getStatus() + ", senha=" + this.getSenha() + ", saldo=" + this.getSaldo() + ", titular=" + this.getTitular() + ", movimentos=" + getMovimentos() + "]";
	}
	
	public String getElementoInfo() {
		return toString();
	}
}
