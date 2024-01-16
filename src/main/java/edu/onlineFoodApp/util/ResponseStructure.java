package edu.onlineFoodApp.util;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.onlineFoodApp.dto.FoodOrders;

public class ResponseStructure<T> {
	
	private int status;
	private String message;
	private T data;
	
	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

	public void setData(ResponseEntity<ResponseStructure<List<FoodOrders>>> findAllFoodOrders) {
		
	}

	
}
