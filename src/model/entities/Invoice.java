package model.entities;

public class Invoice {

	private Double basicPayment;
	private Double tax;

	public Invoice() {
	}

	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	public Double getBasicPayment() {
		return basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public Double getTotalPayment() {
		return getBasicPayment() + getTax();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("INVOICE:\n");
		sb.append("Basic payment: " + String.format("%.2f",getBasicPayment()) + "\n");
		sb.append("Tax: " + String.format("%.2f",getTax()) + "\n");
		sb.append("Total Payment: " + String.format("%.2f",getTotalPayment()) + "\n");
		return sb.toString();
	}

}
