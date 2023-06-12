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

import modelo.Reserva;
import modelo.ReservaModelo;

/**
 * Servlet implementation class NuevaReserva
 */
@WebServlet("/NuevaReserva")
public class NuevaReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("nuevaReserva.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reserva.setInicioReserva(inicioReserva);
		reserva.setFinReserva(finReserva);

		if(request.getParameter("luz") != null) {
			reserva.setLuz(true);
		}
		else {
			reserva.setLuz(false);
		}
		
		reserva.setIdParcela(Integer.parseInt(request.getParameter("id_parcela")));
		
		ReservaModelo rm = new ReservaModelo();
		
		rm.nuevaReserva(reserva);
		
		request.getRequestDispatcher(getServletInfo());
	}

}
