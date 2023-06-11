package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ParcelaModelo extends Conector {
	
	//select * from parcelas
	
	public ArrayList<Parcela> visualizarParcelas(){
		
		ArrayList<Parcela> parcelas = new ArrayList<Parcela>();
		
		try {
			PreparedStatement ps = conexion.prepareStatement("Select * from parcelas");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Parcela parcela = new Parcela();
				
				parcela.setId(rs.getInt(1));
				parcela.setNumero(rs.getString(2));
				parcela.setmCuadrados(rs.getInt(3));
				parcela.setPrecioDia(rs.getDouble(4));
				
				parcelas.add(parcela);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return parcelas;
		
	}
	
	public Parcela verParcelaSegunId(int id) {
		
		Parcela parcela = new Parcela();
		
		try {
			PreparedStatement ps = conexion.prepareStatement("Select * from parcelas where id = ?");
			ps.setInt(1, id);
			
			ps.execute();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				parcela.setId(id);
				parcela.setNumero(rs.getString(2));
				parcela.setmCuadrados(rs.getInt(3));
				parcela.setPrecioDia(rs.getDouble(4));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return parcela;
	}



}
