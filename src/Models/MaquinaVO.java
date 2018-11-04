package Models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MaquinaVO {
	private final SimpleIntegerProperty codigo;
	private final SimpleStringProperty descricao;
	private final SimpleFloatProperty kwh;
	
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



	public float getKwh() {
		return kwh.get();
	}
	
	public void setKwh(float preco) {
		this.kwh.set(preco);
	}

	
	
	public MaquinaVO() {
		codigo = new SimpleIntegerProperty(0);
		descricao = new SimpleStringProperty("");
		kwh = new SimpleFloatProperty(0);
	}
	
	public MaquinaVO(int codigo,String descricao,float kwh) {
		this.codigo = new SimpleIntegerProperty(codigo);
		this.descricao = new SimpleStringProperty(descricao);
		this.kwh = new SimpleFloatProperty(kwh);
	}
	
	@Override
	public String toString() {
	    return this.getDescricao();
	}
}
