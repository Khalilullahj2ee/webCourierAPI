package com.webCourier.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webCourier.model.OrderTableModel;
import com.webCourier.model.UserModel;
import com.webCourier.repository.OrderRepository;
import com.webCourier.repository.UserService;

@RestController
@CrossOrigin(origins = "*")
public class OrderConteroller {

	Map<String, Object> res = new HashMap<String, Object>();
	
	 @Autowired
	OrderRepository orderRepository;
	
	
	
	@PostMapping("order")
	public Map saveOrder(@RequestBody OrderTableModel otm) {
		
		try {
			OrderTableModel savedOtm =	orderRepository.save(otm);
			
			res.put("status", "success");
			
			res.put("data", savedOtm);
		} catch (Exception e) {
			res.put("status", "failed");
			res.put("data", e);
		}
	  
		return res; 
	}
	
	
	@GetMapping("order/orderList")
	public ResponseEntity<?> getOrderList(){
		Map<String, Object> map = new HashMap<>();
		
		try {
			List<OrderTableModel> orderList = (List<OrderTableModel>) orderRepository.findAll();
			map.put("message", "Order get successfully");
			map.put("data", orderList);
			return ResponseEntity.status(HttpStatus.OK).body(map);
		} catch (Exception e) {
			map.put("message", e.getLocalizedMessage());
			map.put("data", null);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
		
	}
	
	@GetMapping("order_Edite/{id}")
	public ResponseEntity<Map> findById(@PathVariable(value = "id") long id){
		Map<String, Object> map = new HashMap<>();
		
		try {
			OrderTableModel otm = orderRepository.findById(id).get();
 			map.put("message", "Order get successfully");
			map.put("data", otm);
			return ResponseEntity.status(HttpStatus.OK).body(map);
		} catch (Exception e) {
			map.put("message", e.getLocalizedMessage());
			map.put("data", null);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
		
	}
	
		@GetMapping("search/{trackingNum}")
	public ResponseEntity<Map> findByTrackingNum(@PathVariable(value = "trackingNum") String trackingNum){
		Map<String, Object> map = new HashMap<>();
		
		try {
			List<OrderTableModel> otms = orderRepository.findByTrackingNumber(trackingNum);
 			map.put("message", "Order get successfully");
			map.put("data", otms.get(0));
			return ResponseEntity.status(HttpStatus.OK).body(map);
		} catch (Exception e) {
			map.put("message", e.getLocalizedMessage());
			map.put("data", null);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
		
	}
	@GetMapping("order_update")
	public ResponseEntity<Map> update(@RequestBody OrderTableModel entity) {
		Map<String, Object> map = new HashMap<>();
		try {
			OrderTableModel otm=  orderRepository.save(entity);
			
			map.put("message", " data update successful");
			map.put("data", otm);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		}catch (Exception e) {
			
			map.put("message", "data update failed");
			map.put("data", null);
			map.put("status", "failed");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	@PostMapping(value = "order/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		Map<String, Object> map = new HashMap<>();
		
		try {
		 orderRepository.deleteById(id);	
			map.put("message", "Data deleted successfully");
			map.put("Data", "deleted");
			map.put("Status code", "success");
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Data deletation failed");
			map.put("Data", null);
			map.put("Status code", "fail");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
}
