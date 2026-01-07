package com.rugved.main;

// import com.rugved.services.FedEx;
import com.rugved.services.IDeliveryService;

// * Always Follow Code to Interface (A good practice)

public class Amazon {

  private IDeliveryService service;  
  
  public Amazon() {

  };

  public Amazon(IDeliveryService service) {
    this.service = service;
  };

  public void setService(IDeliveryService service) {
    this.service = service;
  }

  public Boolean deliverProduct(Double amount) {
    // Boolean status = true;
    // FedEx fedex = new FedEx();
    // fedex.deliverTheProduct(amount);
    // return status;

    // FedEx fedex = new FedEx();
    // return fedex.deliverTheProduct(amount);

    return service.deliverTheProduct(amount);
  }
};