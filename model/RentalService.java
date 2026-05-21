package model;

import java.util.List;

public class RentalService {

    public Contract createContract(Student student, House house, String start, String end) {
        return new Contract(
                student.getName(),
                start,
                end,
                house.getRentPrice(),
                ContractStatus.PENDING.name(),
                student,
                house);
    }

    public void processRental(Student student, House house, Contract contract, List<Payment> payments) {
        if (house.isAvailable()) {
            student.setContract(contract);
            house.markUnavailable();

            Payment payment = new Payment(contract, house.getRentPrice(), PaymentStatus.PENDING.name());
            payment.processPayment(); // Process payment immediately — activates contract
            payments.add(payment);

            System.out.println("Rental Processed for: " + student.getName() + ", at house: " + house.getAddress());
        } else {
            System.out.println("House is NOT available!");
        }
    }
}
