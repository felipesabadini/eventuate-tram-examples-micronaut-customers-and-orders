package io.eventuate.examples.tram.ordersandcustomers.orderhistoryservice.web.customers;

import io.eventuate.examples.tram.ordersandcustomers.orderhistory.backend.CustomerViewRepository;
import io.eventuate.examples.tram.ordersandcustomers.orderhistory.common.CustomerView;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class CustomerOrderHistoryController {

  private CustomerViewRepository customerViewRepository;

  public CustomerOrderHistoryController(CustomerViewRepository customerViewRepository) {
    this.customerViewRepository = customerViewRepository;
  }

  @Get("/customers/{customerId}")
  public HttpResponse<CustomerView> getCustomer(Long customerId) {
    return customerViewRepository
            .findById(customerId)
            .map(HttpResponse::ok)
            .orElseGet(HttpResponse::notFound);
  }
}
