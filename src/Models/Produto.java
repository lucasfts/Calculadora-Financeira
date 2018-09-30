package Models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Produto {
	
	
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



	public float getPreco() {
		return preco.get();
	}
	
	public void setPreco(float preco) {
		this.preco.set(preco);
	}

	private final SimpleIntegerProperty codigo;
	private final SimpleStringProperty descricao;
	private final SimpleFloatProperty preco;
	
	
	public Produto(int codigo,String descricao,float preco) {
		this.codigo = new SimpleIntegerProperty(codigo);
		this.descricao = new SimpleStringProperty(descricao);
		this.preco = new SimpleFloatProperty(preco);
	}
}
