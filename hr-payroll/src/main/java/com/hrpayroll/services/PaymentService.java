package com.hrpayroll.services;

import com.hrpayroll.entities.Payment;
import com.hrpayroll.entities.Worker;
import com.hrpayroll.feignClients.WorkerFeignClients;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PaymentService {

    private final WorkerFeignClients workerFeignClients;


    public Payment getPayment(final long workerId, final int days) {

        final Worker worker = workerFeignClients.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

/*
    //Método usando uma bean RestTemplate para fazer requisição a uma app externa

    @Value("${hr-worker.host}")
    private String workerHost;

    private final RestTemplate restTemplate;

    public Payment getPayment(final long workerId, final int days) {
        final Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));
        final Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);

    }
 */

}
