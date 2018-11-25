package Models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CustoGeralVO {
	private final SimpleIntegerProperty codigo;
	private final SimpleStringProperty descricao;
	private final SimpleFloatProperty valorCusto;
	
	public int getCodigo() {
		return codigo.get();
	}
	
	public void setCodigo(int codigo) {
		this.codigo.set(codigo);
	}


	public String getDescricao() {
		return descricao.get();
	}
	
	public void setDescricao(String descricao) {
		this.descricao.set(descricao);
	}



	public float getValorCusto() {
		return valorCusto.get();
	}
	
	public void setValorCusto(float valorCusto) {
		this.valorCusto.set(valorCusto);
	}

	
	
	public CustoGeralVO() {
		codigo = new SimpleIntegerProperty(0);
		descricao = new SimpleStringProperty("");
		valorCusto = new SimpleFloatProperty(0);
	}
	
	public CustoGeralVO(int codigo,String descricao,float valorCusto) {
		this.codigo = new SimpleIntegerProperty(codigo);
		this.descricao = new SimpleStringProperty(descricao);
		this.valorCusto = new SimpleFloatProperty(valorCusto);
	}
	
	@Override
	public String toString() {
	    return this.getDescricao();
	}
}
