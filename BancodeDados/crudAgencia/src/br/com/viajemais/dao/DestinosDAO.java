package br.com.viajemais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.viajemais.factory.ConnectionFactory;
import br.com.viajemais.model.Cliente;
import br.com.viajemais.model.Destino;

public class DestinosDAO {

	/*
	 * CRUD c: create r: read u: update d: delete
	 */

	Connection conn = null;
	PreparedStatement pstm = null;

	
	public void save(Destino destino) {
		// metodo de salvar

		String sql = "INSERT INTO Destinos(Cidade, Aeroporto, Estado, valor)" + "VALUES(?,?,?,?)";
		// interrogação será substituida pelos parametros inseridos

		// testa se a conexão ainda não existe
		Connection conn = null;

		PreparedStatement pstm = null;
		try {
			// criar uma conexao com o banco de dados
			conn = ConnectionFactory.creatConnectiontoMySQL();
			// criamos uma PrepareStatement, para executar uma query

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getCidade());
			pstm.setString(2, destino.getAeroporto());
			pstm.setString(3, destino.getEstado());
			pstm.setDouble(4, destino.getValor());

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
	
	public void removebyId(int id_destino) {
		String sql = "DELETE FROM Destinos WHERE id_destino = ?";
		try {
			conn = ConnectionFactory.creatConnectiontoMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_destino);

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
	
	public void update(Destino destino) {
		String sql = "UPDATE Destinos SET Cidade = ?, Aeroporto = ?, Estado = ?, valor = ?" + "WHERE id_destinos = ?";
		try {
			conn = ConnectionFactory.creatConnectiontoMySQL();

			pstm = conn.prepareStatement(sql);

			// primeiro parametro (Cidade) da tabela (Destinos) do banco
			pstm.setString(1, destino.getCidade());
			
			// segundo parametro (Aeroporto) da tabela (Destinos) do banco
			pstm.setString(2, destino.getAeroporto());
			
			// terceiro parametro (Estado) da tabela (Destinos) do banco
			pstm.setString(3, destino.getEstado());
			
			// quatro parametro (Valor) da tabela (Destinos) do banco
			pstm.setDouble(4, destino.getValor());

			// para que não seja alterado todas as linhas da tabela
			pstm.setInt(5, destino.getId_destino());

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

	public Destino buscaById(int id_destino) {
		String sql = "SELECT * FROM Destinos WHERE id_destino IN (?);";
		ResultSet rset = null;
		Destino destinos = new Destino();

		try {
			conn = ConnectionFactory.creatConnectiontoMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_destino);

			rset = pstm.executeQuery();

			rset.next();
			destinos.setId_destino(rset.getInt("id_destinos"));
			destinos.setCidade(rset.getString("Cidade"));
			destinos.setAeroporto(rset.getString("Aeroporto"));
			destinos.setEstado(rset.getString("Estado"));

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
		return destinos;
	}	
	
	public  List<Destino> getDestinos() {

		String sql = "SELECT * FROM Destinos";

		List<Destino> destinosLista = new ArrayList<Destino>();
		
		// classe que vai recuperar e mostrar os dados do banco Viajemais ( Tabela Destinos)
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.creatConnectiontoMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			// enquanto houver dados no banco faça

			while (rset.next()) {
				Destino destino = new Destino();

				// recupera o Id do banco e atribui ao objeto
				destino.setId_destino(rset.getInt("id_destino"));
				
				// recupera o Cidade do banco e atribui ao objeto
				destino.setCidade(rset.getString("Cidade"));
				
				// recupera o Aeroporto e atribui nesse o objeto
				destino.setAeroporto(rset.getString("Aeroporto"));
				
				//recupera o Estado e atribui ao objeto 
				destino.setEstado(rset.getString("Estado"));
				
				//recupera o valor e atribui ao objeto 
				destino.setValor(rset.getDouble("Valor"));
				
				// Adiciono o Cliente recuperado, a lista de clientes
				destinosLista.add(destino);

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
		return destinosLista;
 
	}
	
}
