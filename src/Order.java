import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Order extends Thread {

	private UUID orderID;
	private String shipmentStatus;
	private String shipmentType;
	private String address;
	private int shipmentFee;
	private int grandTotal;
	private List<Product> products;
	private Random random = new Random();
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			if (this.shipmentType.equalsIgnoreCase("ViCepat")) {
				Thread.sleep(10000);
				this.setShipmentStatus("Success");
			} else {
				Thread.sleep(20000);
				int persenan = random.nextInt(10 + 1 - 1) + 1;
				if (persenan == 1) {
					this.setShipmentStatus("Failed");
				} else {
					this.setShipmentStatus("Success");	
				}	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public UUID getOrderID() {
		return orderID;
	}

	public void setOrderID(UUID uuid) {
		this.orderID = uuid;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public String getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
	}

	public int getShipmentFee() {
		return shipmentFee;
	}

	public void setShipmentFee(int shipmentFee) {
		this.shipmentFee = shipmentFee;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
