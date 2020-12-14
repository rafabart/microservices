package com.hrpayroll.resources;

import com.hrpayroll.entities.Payment;
import com.hrpayroll.services.PaymentService;
import com.hrpayroll.utils.LogExecutionTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentResource {

    private final PaymentService paymentService;


    @LogExecutionTime
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable final Long workerId, @PathVariable final Integer days) {
        return ResponseEntity.ok(paymentService.getPayment(workerId, days));
    }
}
