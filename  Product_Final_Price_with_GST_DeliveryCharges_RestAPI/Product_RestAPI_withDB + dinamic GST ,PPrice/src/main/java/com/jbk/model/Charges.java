package com.jbk.model;

public class Charges {

	
	
	private double gst;
	private double deliveryCharges;
	
	public Charges() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Charges(double gst, double deliveryCharges) {
		super();
		this.gst = gst;
		this.deliveryCharges = deliveryCharges;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public double getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	@Override
	public String toString() {
		return "Charges [gst=" + gst + ", deliveryCharges=" + deliveryCharges + "]";
	}
	
	
	
}
