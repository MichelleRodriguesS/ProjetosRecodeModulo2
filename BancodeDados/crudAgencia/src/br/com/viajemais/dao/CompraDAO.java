package br.com.viajemais.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import br.com.viajemais.factory.ConnectionFactory;
import br.com.viajemais.model.Cliente;
import br.com.viajemais.model.Compra;
import br.com.viajemais.model.Destino;
import br.com.viajemais.dao;

public class CompraDAO {

	

		/*
		 * CRUD c: create r: read u: update d: delete
		 */

		Connection conn = null;
		PreparedStatement pstm = null;

		
		public void save(Compra compra) {
			// metodo de salvar

			String sql = "INSERT INTO Compra (dataEmbarque,dataRetorno, dataCompra)" + "VALUES(?,?,?)";
			// interrogação será substituida pelos parametros inseridos

			// testa se a conexão ainda não existe
			Connection conn = null;

			PreparedStatement pstm = null;
			try {
				// criar uma conexao com o banco de dados
				conn = ConnectionFactory.creatConnectiontoMySQL();
				// criamos uma PrepareStatement, para executar uma query

				pstm = conn.prepareStatement(sql);

				pstm.setString(1, compra.getDataEmbarque());
				pstm.setString(2, compra.getDataRetorno());
				pstm.setDate(3, null);
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
		
		public void removebyId(int id_compra) {
			String sql = "DELETE FROM Compra WHERE id_compra = ?";
			try {
				conn = ConnectionFactory.creatConnectiontoMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id_compra);

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
		
		public  List<Compra> getCompra() {

			String sql = "SELECT * FROM Compra";

			List<Compra> compraLista = new ArrayList<Compra>();
			
			// classe que vai recuperar e mostrar os dados do banco Viajemais ( Tabela Compra)
			ResultSet rset = null;
			try {
				conn = ConnectionFactory.creatConnectiontoMySQL();
				pstm = conn.prepareStatement(sql);
				rset = pstm.executeQuery();

				// enquanto houver dados no banco faça

				while (rset.next()) {
					Compra compra = new Compra();
					Cliente cliente = new Cliente();
					Destino destino = new Destino();

					// recupera o Id do banco e atribui ao objeto
					compra.setId_compra(rset.getInt("id_compra"));

					destino.setId_destino(rset.getInt("Id_destino"));

					cliente.setId(rset.getInt("Id_cliente"));
					
					// recupera o nome do banco e atribui ao objeto
					compra.setDataEmbarque(rset.getString("dataEmbarque"));
					
					// recupera o endereco e atribui nesse o objeto
					compra.setDataRetorno(rset.getString("dataRetorno"));
					
					//recupera a data e atribui ao objeto 
					pstm.setDate(3, new Date(compra.getDataCompra().getTime()));
					
					
					
					// Adiciono o Cliente recuperado, a lista de clientes
					compraLista.add(compra);

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
			return compraLista;
	 
		}
	
		public Compra buscaById(int id_compra) {
			String sql = "SELECT * FROM Compra WHERE id_compra IN (?);";
			ResultSet rset = null;
			Compra compra = new Compra();
			Destino destino = new Destino();
			Cliente cliente = new Cliente();
	
			try {
				conn = ConnectionFactory.creatConnectiontoMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, id_compra);
	
				rset = pstm.executeQuery();
	
				rset.next();
				
				cliente.setId_cliente(rset.getInt("Id_cliente"));
				destino.setId_destino(rset.getInt("id_destino"));
				compra.setDataEmbarque(rset.getString("dataEmbarque"));
				compra.setDataRetorno(rset.getString("dataRetorno"));
				compra.setDataCompra(rset.getDate("dataCompra"));
				
	
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
			return compra;
		}	
}
