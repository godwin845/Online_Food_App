package edu.onlineFoodApp.util;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.onlineFoodApp.dto.FoodOrders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ResponseStructure<T> {
	
	private int status;
	private String message;
	private T data;
	

	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public T getData() {
		return data;
	}



	public void setData(T data) {
		this.data = data;
	}



	public void setData(ResponseEntity<ResponseStructure<List<FoodOrders>>> findAllFoodOrders) {
		
	}
}