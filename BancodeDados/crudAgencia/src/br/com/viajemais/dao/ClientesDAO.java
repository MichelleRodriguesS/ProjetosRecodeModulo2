package br.com.viajemais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.viajemais.model.*;

import br.com.viajemais.factory.ConnectionFactory;
import br.com.viajemais.model.Cliente;

public class ClientesDAO {
	/*
	 * CRUD c: create r: read u: update d: delete
	 */

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Cliente c1) {
		// metodo de salvar

		String sql = "INSERT INTO Cliente(nome,cpf,endereco)" + "VALUES(?,?,?)";
		// interrogação será substituida pelos parametros inseridos

		// testa se a conexão ainda não existe
		Connection conn = null;

		PreparedStatement pstm = null;
		try {
			// criar uma conexao com o banco de dados
			conn = ConnectionFactory.creatConnectiontoMySQL();
			// criamos uma PrepareStatement, para executar uma query

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, c1.getNome());
			pstm.setString(2, c1.getCpf());
			pstm.setString(3, c1.getEndereco());

			// executar a inserção de dados
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexoes
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void removebyId(int Id_cliente) {
		String sql = "DELETE FROM Cliente WHERE Id_cliente = ?";
		try {
			conn = ConnectionFactory.creatConnectiontoMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, Id_cliente);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexoes
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void update(Cliente cliente) {
		String sql = "UPDATE Cliente SET Nome = ?, Cpf = ?, Endereco = ?" + "WHERE Id_cliente = ?";
		try {
			conn = ConnectionFactory.creatConnectiontoMySQL();

			pstm = conn.prepareStatement(sql);

			// primeiro parametro (nome) da tabela (cliente) do banco
			pstm.setString(1, cliente.getNome());
			// segundo parametro (cpf) da tabela (cliente) do banco

			pstm.setString(2, cliente.getCpf());
			// terceiro parametro (endereco) da tabela (cliente) do banco

			pstm.setString(3, cliente.getEndereco());
			// quatro parametro (Id_cliente) da tabela (cliente) do banco

			// para que não seja alterado todas as linhas da tabela
			pstm.setInt(4, cliente.getId_cliente());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexoes
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public  List<Cliente> getClientes() {

		String sql = "SELECT * FROM Cliente";

		List<Cliente> clienteLista = new ArrayList<Cliente>();
		
		// classe que vai recuperar e mostrar os dados do banco Viajemais ( Tabela Clientes)
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.creatConnectiontoMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			// enquanto houver dados no banco faça

			while (rset.next()) {
				Cliente cliente = new Cliente();

				// recupera o Id do banco e atribui ao objeto
				cliente.setId_cliente(rset.getInt("Id_cliente"));
				
				// recupera o nome do banco e atribui ao objeto
				cliente.setNome(rset.getString("Nome"));
				
				// recupera o endereco e atribui nesse o objeto
				cliente.setEndereco(rset.getString("Endereco"));
				
				//recupera o CPF e atribui ao objeto 
				cliente.setCpf(rset.getString("Cpf"));
				
				// Adiciono o Cliente recuperado, a lista de clientes
				clienteLista.add(cliente);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexoes
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return clienteLista;
 
	}
	
	public Cliente buscaById(int Id_cliente) {
		String sql = "SELECT * FROM Cliente WHERE id IN (?);";
		ResultSet rset = null;
		Cliente cliente = new Cliente();

		try {
			conn = ConnectionFactory.creatConnectiontoMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, Id_cliente);

			rset = pstm.executeQuery();

			rset.next();
			cliente.setId(rset.getInt("Id_cliente"));
			cliente.setNome(rset.getString("Nome"));
			cliente.setCpf(rset.getString("Cpf"));
			cliente.setEndereco(rset.getString("Endereço"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		return cliente;
	}

	public static void removeById(int id_cliente) {
	}

	
}