package com.pojoclass;

public class Request_POJOS {
	 private long id;
	    private Integer petId;
	    private Integer quantity;
	    private String shipDate;
	    private String status;
	    private Boolean complete;
	    public long getId() {
	        return id;
	    }
	    public void setId(long id) {
	        this.id = id;
	    }
	    public Integer getPetId() {
	        return petId;
	    }
	    public void setPetId(Integer petId) {
	        this.petId = petId;
	    }
	    public Integer getQuantity() {
	        return quantity;
	    }
	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }
	    public String getShipDate() {
	        return shipDate;
	    }
	    public void setShipDate(String shipDate) {
	        this.shipDate = shipDate;
	    }
	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }
	    public Boolean getComplete() {
	        return complete;
	    }
	    public void setComplete(Boolean complete) {
	        this.complete = complete;
	    }
	    
	    public Request_POJOS(long id,int petId,Integer quantity,String shipDate,String status,Boolean complete) {
	    	setId(id);
	    	setPetId(petId);
	    	setQuantity(quantity);
	    	setShipDate(shipDate);
	    	setStatus(status);
	    	setComplete(complete);
	    	
		}
}
