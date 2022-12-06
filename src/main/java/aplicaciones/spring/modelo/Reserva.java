package aplicaciones.spring.modelo;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Reservas")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String cliente;
	private String destino;
	private String lorigen;
	private int cantidad;
	private double pago;
	@Temporal(TemporalType.DATE)
	private Date fsalida;
	@Temporal(TemporalType.DATE)
	private Date fretorno;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public String getLorigen() {
		return lorigen;
	}
	public void setLorigen(String lorigen) {
		this.lorigen = lorigen;
	}
	public Date getFsalida() {
		return fsalida;
	}
	public void setFsalida(Date fsalida) {
		this.fsalida = fsalida;
	}
	public Date getFretorno() {
		return fretorno;
	}
	public void setFretorno(Date fretorno) {
		this.fretorno = fretorno;
	}
	public double getPago() {
		return pago;
	}
	public void setPago(double pago) {
		this.pago = pago;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", cliente=" + cliente + ", destino=" + destino + ", lorigen=" + lorigen
				+ ", cantidad=" + cantidad + ", pago=" + pago + ", fsalida=" + fsalida + ", fretorno=" + fretorno + "]";
	}

	
	
}
