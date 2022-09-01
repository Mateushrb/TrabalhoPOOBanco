
public class PessoaFisica extends Pessoa {
	
	private String cpf;
	private String dataNascimento;
	private String rg;
	private float renda;
	
	public PessoaFisica(String cpf, String nome, String dataNascimento, String rg, float renda) {
		super(nome);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.renda = renda;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}

	public float getRenda() {
		return renda;
	}
	public void setRenda(float renda) {
		this.renda = renda;
	}
	
	@Override
	public String toString() {
		return "PessoaFisica [cpf=" + getCpf() + ", dataNascimento=" + getDataNascimento() + ", rg=" + getRg() + ", renda=" + getRenda() + ", nome=" + getNome() + "]";
	}
	
	public String getElementoInfo() {
		return toString();
	}
	
	
}
