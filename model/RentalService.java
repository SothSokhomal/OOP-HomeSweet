package model;

import java.util.ArrayList;

public class RentalService {

    public Contract createContract(Student student, House house, String start, String end) {
        return new Contract(
                student.getName(),
                start,
                end,
                house.getRentPrice(),
                OrderStatus.PENDING.name(),
                student,
                house);
    }

    public void processRental(Student student, House house, Contract contract, ArrayList<Payment> payments) {

        if (house.isAvailable()) {
            student.setContract(contract);
            house.setAvailable(false);

            payments.add(new Payment(contract, house.getRentPrice(), PaymentStatus.UNPAID.name()));

            System.out.println("Rental Processed for: " + student.getName() + ", at house: " + house.getAddress());
        } else {
            System.out.println("House is NOT available!");
        }
    }
}