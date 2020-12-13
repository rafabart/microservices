package com.hrpayroll.services;

import com.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    public Payment getPayment(final long workerId, final int days) {
        return new Payment("Bart", 100.00, days);
    }
}
