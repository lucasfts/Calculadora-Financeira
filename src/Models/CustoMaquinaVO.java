package Models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CustoMaquinaVO {
	private final SimpleIntegerProperty codigo;
	private final SimpleIntegerProperty codigoProduto;
	private final SimpleIntegerProperty codigoMaquina;
	private final SimpleFloatProperty tempoUnitario;
	
	public int getCodigo() {
		return codigo.get();
	}
	
	public void setCodigo(int codigo) {
		this.codigo.set(codigo);
	}

	public int getCodigoProduto() {
		return codigoProduto.get();
	}
	
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto.set(codigoProduto);
	}
	
	public int getCodigoMaquina() {
		return codigoMaquina.get();
	}
	
	public void setCodigoMaquina(int codigoMaquina) {
		this.codigoMaquina.set(codigoMaquina);
	}
	
	public float getTempoUnitario() {
		return tempoUnitario.get();
	}
	
	public void setTempoUnitario(float tempoUnitario) {
		this.tempoUnitario.set(tempoUnitario);
	}
	
	
	public CustoMaquinaVO() {
		codigo = new SimpleIntegerProperty(0);
		codigoProduto = new SimpleIntegerProperty(0);
		codigoMaquina = new SimpleIntegerProperty(0);
		tempoUnitario = new SimpleFloatProperty(0);
	}
	
	public CustoMaquinaVO(int codigo,int codigoProduto, int codigoMaquina, float tempoUnitario) {
		this.codigo = new SimpleIntegerProperty(codigo);
		this.codigoProduto = new SimpleIntegerProperty(codigoProduto);
		this.codigoMaquina = new SimpleIntegerProperty(codigoMaquina);
		this.tempoUnitario = new SimpleFloatProperty(tempoUnitario);
	}
	
	@Override
	public String toString() {
	    return String.valueOf(this.getCodigo());
	}
}
