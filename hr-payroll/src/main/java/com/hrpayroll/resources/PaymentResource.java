package com.hrpayroll.resources;

import com.hrpayroll.entities.Payment;
import com.hrpayroll.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentResource {

    private final PaymentService paymentService;


    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable final Long workerId, @PathVariable final Integer days) {
        return ResponseEntity.ok(paymentService.getPayment(workerId, days));
    }
}
