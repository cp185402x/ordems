package model;

public class Peca {

	///Atributos
	private int id;
	private String nm_peca;
    private String vl_custo;
    private String vl_venda;
	
	public  String getNm_peca() {
		return nm_peca;
	}
	public void setNm_peca(String nm_peca) {
		this.nm_peca = nm_peca;
	}
	public String getVl_custo() {
		return vl_custo;
	}
	public void setVl_custo(String vl_custo) {
		this.vl_custo = vl_custo;
	}
	public String getVl_venda() {
		return vl_venda;
	}
	public void setVl_venda(String vl_venda) {
		this.vl_venda = vl_venda;
	}

	 public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	
public String toString() {
		
		return "Peca [id=" + id + ", nm_peca=" + nm_peca + ", vl_custo=" + vl_custo + ", vl_venda=" + vl_venda + "]";
	}
}
