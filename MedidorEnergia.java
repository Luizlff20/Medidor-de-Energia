package unit.com.br.atv;

public class MedidorEnergia {

	private int idMedidor;
	private String nrSerie;
	private char tipoUcInstalado;
	private int leituraAnterior;
	private int leituraAtual;
	private int consumo;
	private double valorConta;

	public MedidorEnergia() {
	}

	public MedidorEnergia(int idMedidor, String nrSerie, char tipoUcInstalado, int leituraAtual) {
		super();
		this.idMedidor = idMedidor;
		this.nrSerie = nrSerie;
		this.tipoUcInstalado = tipoUcInstalado;
		this.leituraAnterior = leituraAtual;
		this.leituraAtual = leituraAtual;
		this.consumo = 0;
		this.valorConta = 0;
	}

	public void registrarLeitura(int leituraRecebida) {

		this.leituraAtual = leituraRecebida;
		this.consumo = this.leituraAtual - this.leituraAnterior;
		this.leituraAnterior = this.leituraAtual;
		this.calcularConta(tipoUcInstalado);

	}

	private void calcularConta(char tipoUcInstalado) {
		if (tipoUcInstalado == 'C') {
			valorConta = consumo * 0.70;
		} else if (tipoUcInstalado == 'I') {
			valorConta = consumo * 0.50;
		} else if (tipoUcInstalado == 'R') {
			valorConta = consumo * 0.60;
		}
	}

	public int getIdMedidor() {
		return idMedidor;
	}

	public String getNrSerie() {
		return nrSerie;
	}

	public char getTipoUcInstalado() {
		return tipoUcInstalado;
	}

	public int getLeituraAnterior() {
		return leituraAnterior;
	}

	public int getLeituraAtual() {
		return leituraAtual;
	}

	public int getConsumo() {
		return consumo;
	}

	public double getValorConta() {
		return valorConta;
	}

	public void setTipoUcInstalado(char tipoUcInstalado) {
		this.tipoUcInstalado = tipoUcInstalado;
	}

	public void setLeituraAnterior(int leituraAnterior) {
		this.leituraAnterior = leituraAnterior;
	}

	public void setLeituraAtual(int leituraAtual) {
		this.leituraAtual = leituraAtual;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	public void setValorConta(double valorConta) {
		this.valorConta = valorConta;
	}

}