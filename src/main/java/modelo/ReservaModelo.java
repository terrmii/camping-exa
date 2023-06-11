package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReservaModelo extends Conector{
/*
	"INSERT INTO reservas(nombre_usuario, apellido_usuario, dni_usuario, numero_usuarios, inicio_reserva, fin_reserva,  luz, id_parcela) "
			+ "VALUES (?,?,?,?,?,?,?,?)"
			
	"DELETE FROM reservas WHERE id = ?"
		*/
		

	public int reservarParcela(Reserva reserva) {
		
		int id = 0;
		
		try {
			PreparedStatement ps = conexion.prepareStatement("INSERT INTO reservas(nombre_usuario, apellido_usuario, dni_usuario, numero_usuarios, inicio_reserva, fin_reserva,  luz, id_parcela) VALUES (?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			ResultSet gk = ps.getGeneratedKeys();
			
			ps.setString(1, reserva.getNombreUsuario());
			ps.setString(2, reserva.getApellidoUsuario());
			ps.setString(3, reserva.getDniUsuario());
			ps.setInt(4, reserva.getNumeroUsuarios());
			ps.setDate(5, new java.sql.Date(reserva.getInicioReserva().getTime()));
			ps.setDate(6, new java.sql.Date(reserva.getFinReserva().getTime()));
			ps.setBoolean(7, reserva.isLuz());
			ps.setInt(8, reserva.getIdParcela());
			
			ps.executeUpdate();
			
			if(gk.next()) {
				reserva.setId(gk.getInt(1));
				id = reserva.getId();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}

	public void anularReserva(int id) {
		
		try {
			PreparedStatement ps = conexion.prepareStatement("Delete FROM reservas WHERE id = ?");
			
			ps.setInt(1, id);
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Reserva verReservaGenerada(int id) {
		
		Reserva reserva = new Reserva();
		
		try {
			PreparedStatement ps = conexion.prepareStatement("Select * from reservas WHERE id = ?");
			
			ps.setInt(1, id);
			
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				reserva.setId(id);
				reserva.setNombreUsuario(rs.getString("nombre_usuario"));
				reserva.setApellidoUsuario(rs.getString("apellido_usuario"));
				reserva.setDniUsuario(rs.getString("dni_usuario"));
				reserva.setNumeroUsuarios(rs.getInt("numero_usuarios"));
				reserva.setInicioReserva(rs.getDate("inicio_reserva"));
				reserva.setFinReserva(rs.getDate("fin_reserva"));
				reserva.setLuz(rs.getBoolean("luz"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reserva;
	}
}
