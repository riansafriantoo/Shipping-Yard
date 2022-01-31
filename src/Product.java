
public class Product {
	
	protected int stockId;
	protected String nameProduct;
	protected float priceProduct;
	protected int stockProduct;
	
	public Product(int _stockId ,String _nameProduct, float _priceProduct, int _stockProduct) {
		// TODO Auto-generated constructor stub
		stockId = _stockId;
		nameProduct = _nameProduct;
		priceProduct = _priceProduct;
		stockProduct = _stockProduct;
	}
	

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public float getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}

	public int getStockProduct() {
		return stockProduct;
	}

	public void setStockProduct(int stockProduct) {
		this.stockProduct = stockProduct;
	}
	
	public int getStockId() {
		return stockId;
	}


	public void setStockId(int stockId) {
		this.stockId = stockId;
	}	
}
