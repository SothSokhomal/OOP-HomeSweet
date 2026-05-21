package interfaces;

import model.Student;
import model.Landlord;
import model.House;
import model.Contract;
import model.Payment;

public interface Searchable {
    Student findStudentById(int id);
    Landlord findLandlordById(int id);
    House findHouseById(int id);
    Contract findContractById(int id);
    Payment findPaymentById(int id);
}
