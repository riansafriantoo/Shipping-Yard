import java.util.*;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	String name,productName;
	int productQty;
	float productPrice;
	int choose;
	int id = 0;
	int j = 0;
	Order order = null;
	List<Order> hasilOrder = new ArrayList<Order>();
	Random random = new Random();
	
	void clearScreen() {
		for(int i = 0; i < 3; i++)
			System.out.println();
	}

	public Main() {
		// TODO Auto-generated constructor stub
		Product prod1 = new Product(1,"The Aubree Niacinamide Serum",99000 , 20);
		Product prod2 = new Product(2,"Tiff Body Cacao Coffee Scrub",150000 , 50);
		Product prod3 = new Product(3,"Kleveru Glass Skin Serum",143000 , 23);
		Product prod4 = new Product(4,"Sensatia Botanicals Unscented Facial-C Serum",180000 , 25);
		Product prod5 = new Product(5,"Mineral Botanicals Vanila Lip Scrub",55000 , 33);
		Product prod6 = new Product(6,"Think Hale Let's Mask",129000 , 41);
		Product prod7 = new Product(7,"Faith In Face Cica Jelly Mask",29000 , 32);
		Product prod8 = new Product(8,"Lacoco Swallow Facial Foam",165000 , 23);
		Product prod9 = new Product(9,"Everwhite Brightening Essence Serum",125000 , 45);
		
//		System.out.println(prod1.nameProduct + " " + prod1.stockProduct);
		
		List<Product> list_product = new ArrayList<>();
		
		list_product.add(prod1);
		list_product.add(prod2);
		list_product.add(prod3);
		list_product.add(prod4);
		list_product.add(prod5);
		list_product.add(prod6);
		list_product.add(prod7);
		list_product.add(prod8);
		list_product.add(prod9);
		
		Product produce = new Product(id, productName, productPrice, productQty);
		
		for (int i = 0; i < list_product.size(); i++) {
			if(list_product.get(i).getStockId() == (id))
				j++;
		}
		
		System.out.println("Welcome to VI Shop! ^_^");
		do {
			System.out.println("To Create an order, please insert your name :");
			name = scan.nextLine();
			System.out.println();
			if (name.length() == 0 || !name.contains(" ") || name.length()<=5) {
				System.out.println("Please insert name");
			}
		} while (!name.contains(" ") || name.length()<=2);
		
		do {
			if (hasilOrder.isEmpty() == false) {
				for (int i = 0; i < hasilOrder.size(); i++) {
					if (hasilOrder.get(i).getShipmentStatus().equals("Failed")) {
						System.out.println(hasilOrder.get(i).getShipmentType());
						System.out.println("----------------");
						System.out.println("Shipping ID: " + hasilOrder.get(i).getOrderID());
						System.out.println("Shipping Status: " +hasilOrder.get(i).getShipmentStatus());
						System.out.println("===================================");
						System.out.println("Sorry for your inconvinience, your packet has missing somewhere.");
						System.out.println("Insurance fee will be delivered by your address.");
					} else if (hasilOrder.get(i).getShipmentStatus().equals("On Going")) {
						System.out.println(hasilOrder.get(i).getShipmentType());
						System.out.println("----------------");
						System.out.println("Shipping ID: " + hasilOrder.get(i).getOrderID());
						System.out.println("Shipping Status: " +hasilOrder.get(i).getShipmentStatus());
						System.out.println("===================================");	
					}
				}
			}
			clearScreen();
			
			System.out.println("Hello, " + name);
			System.out.println("==================");
			System.out.println("1.Shop at Vi");
			System.out.println("2.Refresh My Shipping Status");
			System.out.println("3.View Purchase History");
			System.out.println("4.Exit");
			choose = scan.nextInt(); scan.nextLine();
			
			switch (choose) {
			case 1:
				if(list_product.isEmpty()) {
					System.out.println("Sorry, our product currently out of stock."); scan.nextLine();
				}else {
					int pick = 0;
					int pickQty = 0;
					String choice = "";
					List<Product> orderedProducts = new ArrayList<Product>();
					order = new Order();
					String address = "";
					String shipmentType = "";
					
					do {
						for (int i = 0; i < list_product.size(); i++) {
							System.out.println("No : " + list_product.get(i).getStockId());
							System.out.println("Name : " + list_product.get(i).getNameProduct());
							System.out.println("Price : " + list_product.get(i).getPriceProduct());
							System.out.println("Stocks : " + list_product.get(i).getStockProduct());
							clearScreen();
						}
						
						do {
							System.out.println("Pick product to buy[1.." + list_product.size() + "]");
							pick =  scan.nextInt(); scan.nextLine();
							
							if ((pick <= 0) || (pick > list_product.size())) {
								System.out.println("Salah");
							}
							
						} while ((pick <= 0) || (pick > list_product.size()));
						
						do {
							System.out.println("Input quantity: [1.." + list_product.get(pick - 1).getStockProduct() + "]");
							pickQty =  scan.nextInt(); scan.nextLine();
							
							if ((pickQty <= 0) || (pickQty > list_product.get(pick - 1).getStockProduct())) {
								System.out.println("Salah");
							}
							
						} while ((pick <= 0) || (pickQty > list_product.get(pick - 1).getStockProduct()));
						
						do {
							System.out.println("Would you like add More Product [Y/N] : ");
							choice = scan.nextLine();
						} while (!choice.equals("Y") && !choice.equals("N"));
						
						Product orderedProduct = new Product(list_product.get(pick - 1).getStockId(), 
								list_product.get(pick - 1).getNameProduct(), list_product.get(pick - 1).getPriceProduct(), pickQty);
						
						orderedProducts.add(orderedProduct);			
					} while (choice.equals("Y"));
					
					do {
						System.out.println("Address: ");
						address = scan.nextLine();
					} while (!address.startsWith("Jl. ") || address.length() < 10);
					 
					do {
						System.out.println("Shipment Type [ViCepat|VeDex] : ");
						shipmentType = scan.nextLine();
					} while (!shipmentType.equalsIgnoreCase("ViCepat") && !shipmentType.equalsIgnoreCase("VeDex"));
					
					order.setProducts(orderedProducts);
					order.setShipmentType(shipmentType);
					order.setAddress(address);
					
					int totalHargaBarang = 0;
			
					for (int i = 0; i < orderedProducts.size(); i++) {
						
						totalHargaBarang += Math.round(orderedProducts.get(i).getPriceProduct()) * orderedProducts.get(i).getStockProduct();
					}
					
					if (shipmentType.equalsIgnoreCase("ViCepat")) {
						order.setShipmentFee(12000);
					} else if (shipmentType.equalsIgnoreCase("VeDex")) {	
						if (totalHargaBarang >= 150000) {
							order.setShipmentFee(0);
						} else {
							order.setShipmentFee(10000);
						}
					}
					
					order.setOrderID(UUID.randomUUID());
					order.setGrandTotal(totalHargaBarang + order.getShipmentFee());
					order.setShipmentStatus("On Going");
					order.start();
					hasilOrder.add(order);
					
					System.out.println("Product's Price: " + totalHargaBarang);
					System.out.println("Shipping Fee: " + order.getShipmentFee());
					System.out.println("Grand Total: " + order.getGrandTotal());
					clearScreen();
				}
				break;
			case 2:
				
				break;
			case 3:
				clearScreen();
				if (hasilOrder.isEmpty() == false) {
					for (int i = 0; i < hasilOrder.size(); i++) {
						if (hasilOrder.get(i).getShipmentStatus().equals("Success")) {
							System.out.println(hasilOrder.get(i).getShipmentType());
							System.out.println("----------------");
							System.out.println("Shipping ID: " + hasilOrder.get(i).getOrderID());
							System.out.println("Shipping Status: " +hasilOrder.get(i).getShipmentStatus());
							System.out.println("===================================");
							clearScreen();
						}
					}
				}
				break;
			case 4:
				
				break;
			}
		} while (choose != 4);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
