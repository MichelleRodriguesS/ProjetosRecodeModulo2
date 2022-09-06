package br.com.viajemais.dao;
import java.util.Scanner;

import br.com.viajemais.model.*;

public class Principal {

	public static void main(String args[]) {

		ClientesDAO clientesDAO = new ClientesDAO();
		Cliente c1 = new Cliente();
		Destino d1 = new Destino();
		DestinosDAO destinosDAO = new DestinosDAO();

		Scanner entrada = new Scanner(System.in);
		int escolha = 0;
		String nome = "";
		String Cpf;
		String endereco;
		int Id_cliente = 0;
		String cidade;
		String aeroporto;
		String estado;
		double valor = 0;
		int id_destino = 0;

		do {

			System.out.println("===== ************************************=====");
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Cadastrar novo Cliente");
			System.out.println("2 - Excluir dados de um Cliente");
			System.out.println("3 - Atualizar dados cadastrais de Clientes");
			System.out.println("4 - Mostrar todos os Clientes Cadastrados");
			System.out.println("5 - Cadastro de novo Destino:");
			System.out.println("6 - Deletar dados de Destino");
			System.out.println("7 - Mostrar todos os destinos");
			System.out.println("8 - Atualizar dados de um Destino");
			System.out.println("9 - Procurar um Destino por ID");
		

			System.out.println("0 - Sair");
			escolha = entrada.nextInt();

			switch (escolha) {
				// metodo salvar
			case 1: {
				System.out.println("Digite o nome completo do Cliente a ser Incluído no cadastro: ");
				nome = entrada.next();
				System.out.println("Digite o CPF do Cliente para cadastro: ");
				Cpf = entrada.next();
				System.out.println("Digite o endereço do Cliente: ");
				endereco = entrada.next();
				c1.setNome(nome);
				c1.setCpf(Cpf);
				c1.setEndereco(endereco);

				clientesDAO.save(c1);
				break;
			}
			// metodo Deletar 
			case 2: {
				System.out.println("Digite o ID do cliente para exclusão: ");
				try {
					Id_cliente = entrada.nextInt();
					
					ClientesDAO.removeById(Id_cliente);
					
				} catch (Exception e) {
					// e.getMessage();
					 
					System.out.println(" ID não foi encontrado");
				}

				break;
			}
			// método de atualizar
			case 3: {

				System.out.println("Digite o ID do Cliente que deseja atualizar: ");
				Id_cliente = entrada.nextInt();

				System.out.println("Digite o novo nome do cadastro: ");
				nome = entrada.next();
				c1.setNome(nome);
				
				System.out.println("Digite o CPF para cadastro: ");
				Cpf = entrada.next();
				c1.setCpf(Cpf);
				
				System.out.println("Digite o endereço do Cliente: ");
				endereco = entrada.next();				
				c1.setEndereco(endereco);
				

				c1.setId(Id_cliente);

				clientesDAO.update(c1);
			}
			case 4: {
				// READ - Leitura
				try {
					for (Cliente c2: clientesDAO.getClientes()) {
						System.out.println("Nome: " + c2.getNome());
						System.out.println("CPF:  " + c2.getCpf());
						System.out.println("Endereço: "+ c2.getEndereco());
						System.out.println("-------------------------------");
					} 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
				
			case 5: {
				// Cadastrar Novo Destino
				try {
					{
						System.out.println("Digite a cidade do destino a ser Incluído no cadastro: ");
						cidade = entrada.next();
						System.out.println("Digite o estado do Destino: ");
						estado = entrada.next();
						System.out.println("Digite o código do Aeroporto com 3 letras do Destino: ");
						aeroporto = entrada.next();
						System.out.println("Digite o valor do Destino a ser incluído: ");
						valor = entrada.nextDouble();
						d1.setCidade(cidade);
						d1.setEstado(estado);
						d1.setAeroporto(aeroporto);
						d1.setValor(valor);
		
						destinosDAO.save(d1);
						break;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
				
			case 6: {
				
				try {
					System.out.println("Digite o ID do destino para exclusão: ");
				try {
					id_destino = entrada.nextInt();
					
					destinosDAO.removebyId(id_destino);
					
				} catch (Exception e) {
					// e.getMessage();
					 
					System.out.println(" ID não foi encontrado");
				}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
				
			case 7: {
				// READ - Leitura
				try {
					for (Destino d2Destino: destinosDAO.getDestinos()) {
			            System.out.println("Cidade: " + d1.getCidade());
			            System.out.println("Estado: " + d1.getEstado());
			            System.out.println("Código do Aeroporto: " + d1.getAeroporto());
						System.out.println("Valor:  " + d1.getValor);
			            
			            System.out.println("-------------------------------");
			        }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
				
			case 8: {
				// READ - Atualizar destino
						try {
						System.out.println("Digite o ID do Destino que deseja atualizar: ");
									id_destino = entrada.nextInt();
					
									System.out.println("Digite a cidade do destino a ser Incluído no cadastro: ");
									cidade = entrada.next();
									System.out.println("Digite o estado do Destino: ");
									estado = entrada.next();
									System.out.println("Digite o código do Aeroporto com 3 letras do Destino: ");
									aeroporto = entrada.next();
									System.out.println("Digite o valor do Destino a ser incluído: ");
									valor = entrada.nextDouble();
									d1.setCidade(cidade);
									d1.setEstado(estado);
									d1.setAeroporto(aeroporto);
									d1.setValor(valor);
					
									d1.setId_destino(id_destino);
					
									destinosDAO.update(d1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
				
			case 9: {
				// READ - Leitura
				try {
					for (Destino d2Destino: destinosDAO.getDestinos()) {
			            System.out.println("Cidade: " + d1.getCidade());
			            System.out.println("Estado: " + d1.getEstado());
			            System.out.println("Código do Aeroporto: " + d1.getAeroporto());
						System.out.println("Valor:  " + d1.getValor);
			            
			            
			            System.out.println("-------------------------------");
			        }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
						
			case 0: {
				System.out.println(" Você saiu do menu ");
				break;
			}
			default:
				System.out.println("Opção invalida: ");

			};

		} while (escolha != 9);

		entrada.close();

	}
}
