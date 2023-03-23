package unit.com.br.atv;

import java.util.Scanner;

public class AppMedidorEnergia {

	static MedidorEnergia medidorEnergia = new MedidorEnergia();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao;

		do {
			System.out.println("\n--- Seletor de Opções ---");
			System.out.println();
			System.out.println("1 - Cadastrar Medidor");
			System.out.println("2 - Registra Leitura");
			System.out.println("0 - Finalizar");

			System.out.print("\nOpção: ");
			opcao = scan.nextInt();

			switch (opcao) {
			case 1:
				cadastrarMedidor();
				break;
			case 2:
				receberLeitura();
				break;
			case 0:
				System.out.println("\n--- PROGRAMA FINALIZADO---");
				break;
			default:
				System.out.println("\nOpção incorreta");

			}

		} while (opcao != 0);

	}

	public static void cadastrarMedidor() {

		int idMedidor;

		do {
			System.out.println("Digite o Id do medidor: ");
			idMedidor = scan.nextInt();
			if (idMedidor <= 0) {
				System.out.println("Erro!!Digite o valor positivo!");
				continue;
			}
			break;
		} while (true);

		String nrSerie;
		scan.nextLine();
		do {
			System.out.println("Digite o número de série do equipamento");
			nrSerie = scan.nextLine();
			if (nrSerie == null) {
				System.out.println("Digite o número correto");
				continue;
			}
			break;
		} while (true);

		char tipoUcInstalado;
		do {
			System.out.println("Digite o tipo de unidade de consumo 'C', 'I', 'R': ");
			tipoUcInstalado = scan.nextLine().charAt(0);
			if (tipoUcInstalado != 'C' && tipoUcInstalado != 'I' && tipoUcInstalado != 'R') {
				System.out.println("ERRO!! Digite 'C', 'I', 'R' ");
				continue;
			}
			break;
		} while (true);

		int leitura;

		do {
			System.out.print("Informe a leitura atual do medidor: ");
			leitura = scan.nextInt();
			if (leitura <= 0) {
				System.out.println("O nÃºmero da leitura altual deve ser um nÃºmero positivo");
				continue;
			}
			break;
		} while (true);

		medidorEnergia = new MedidorEnergia(idMedidor, nrSerie, tipoUcInstalado, leitura);

		System.out.println("-----------------------------------");

		System.out.println("Identificador               :" + medidorEnergia.getIdMedidor());
		System.out.println("Número de série:            :" + medidorEnergia.getNrSerie());
		System.out.println("Tipo da unidade de consumo  :" + medidorEnergia.getTipoUcInstalado());
		System.out.println("Leitura atual               :" + medidorEnergia.getLeituraAtual());

		System.out.println("\n-----------------------------------");

	}

	public static void receberLeitura() {
		System.out.println();
		System.out.println("-------  leitura do Medidor ------");
		System.out.println("ID do medidor               : " + medidorEnergia.getIdMedidor());
		System.out.println("Número de série do medidor  : " + medidorEnergia.getNrSerie());
		System.out.println("Tipo de Consumo de Unidade  : " + medidorEnergia.getTipoUcInstalado());
		System.out.println("Leitura anterior do medidor : " + medidorEnergia.getLeituraAnterior());
		System.out.println();

		int leituraAtual;
		for (int i = 0; i < 2; i++) {
			do {
				System.out.print("Informe a leitura atual do medidor: ");
				leituraAtual = scan.nextInt();
				medidorEnergia.registrarLeitura(leituraAtual);
				if (leituraAtual <= 0) {
					System.out.println("O número da leitura atual deve ser um número positivo");
					continue;
				}
				break;
			} while (true);

			System.out.println("Valor do consumo : " + medidorEnergia.getConsumo());
			System.out.println("Valor da conta   : " + medidorEnergia.getValorConta());
			System.out.println("\n-----------------------------------");

		}

	}

}
