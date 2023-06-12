package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ParcelaModelo;
import modelo.Reserva;
import modelo.ReservaModelo;

/**
* Servlet implementation class ConfirmarReserva
*/
@WebServlet("/AlmacenarReserva")
public class AlmacenarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	* @see HttpServlet#HttpServlet()
	*/
	public AlmacenarReserva() {
		super();
	}
	
	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO implementar la funcionalidad de almacenar reserva
		//se abrirá la vista infoReserva
		int idReserva = Integer.parseInt(request.getParameter("idReserva"));
		int idParcela = Integer.parseInt(request.getParameter("id_parcela"));
		
		ParcelaModelo pm = new ParcelaModelo();
		ReservaModelo rm = new ReservaModelo();
		
		request.setAttribute("reserva", rm.verReservaGenerada(idReserva));
		request.setAttribute("parcela", pm.verParcelaSegunId(idParcela));
		
		request.getRequestDispatcher("infoReserva.jsp").forward(request, response);
	}
	
	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Reserva reserva = new Reserva();
		
		reserva.setNombreUsuario(request.getParameter("nombre"));
		reserva.setApellidoUsuario(request.getParameter("apellido"));
		reserva.setDniUsuario(request.getParameter("dni"));
		reserva.setNumeroUsuarios(Integer.parseInt(request.getParameter("numero_personas")));
		
		Date inicioReserva = null;
		Date finReserva = null;
		try {
			inicioReserva = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("fecha_inicio"));
			finReserva = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("fecha_fin"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		reserva.setInicioReserva(inicioReserva);
		reserva.setFinReserva(finReserva);
		
		if (request.getParameter("luz") != null) {
			reserva.setLuz(true);
		} else {
			reserva.setLuz(false);
		}
		
		reserva.setIdParcela(Integer.parseInt(request.getParameter("id_parcela")));
		
		ReservaModelo rm = new ReservaModelo();
		
		int idReserva = 0;
		int idParcela = 0;
		

		
//		idReserva = rm.veridInsertado();
		idReserva = rm.reservarParcela(reserva);
		idParcela = reserva.getIdParcela();
		
		response.sendRedirect(request.getContextPath() + "/AlmacenarReserva?idReserva=" + idReserva
				+ "&id_parcela=" + idParcela);
	}
	
}
