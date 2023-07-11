package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Jogo;

public class JogoDao {

	public void cadastrarJogo(Jogo jogo) {
		
		String sql = "INSERT INTO JOGOS VALUES (null,?,?,?,?,?)";
		
		PreparedStatement pStatemant = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatemant = conn.prepareStatement(sql);
			pStatemant.setString(1, jogo.getImagemUrl());
			pStatemant.setString(2, jogo.getNome());
			pStatemant.setString(3, jogo.getDataLancamento());
			pStatemant.setString(4, jogo.getEmpresaProducao());
			pStatemant.setString(5, jogo.getEmpresaPublicacao());
			pStatemant.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pStatemant!=null) {
					pStatemant.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<Jogo> BuscarJogoPorNome(String nome){
		String sql = "SELECT * FROM JOGOS WHERE nome LIKE '%" + nome + "%'";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatemant = null;
		Jogo jogo = null;
		ArrayList<Jogo> jogos = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatemant = conn.prepareStatement(sql);
			rs = pStatemant.executeQuery();
			if(rs!=null) {
				jogos = new ArrayList<Jogo>();
				
				while(rs.next()) {
					jogo = new Jogo();
					jogo.setIdJogo(rs.getInt("idJogo"));
					jogo.setImagemUrl(rs.getString("url"));
					jogo.setNome(rs.getString("nome"));
					jogo.setDataLancamento(rs.getString("lancamento"));
					jogo.setEmpresaProducao(rs.getString("produtora"));
					jogo.setEmpresaPublicacao(rs.getString("publicadora"));
					jogos.add(jogo);
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pStatemant!=null) {
					pStatemant.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return jogos;
	}
}