package model;

import java.util.ArrayList;
import java.util.List;
public class ContractService {
    private List<Contract> contracts = new ArrayList<>();

    public void addContract(Contract c) {
        contracts.add(c);
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void viewContracts() {
        System.out.println("\n--- Contract List ---");
        for (Contract c : contracts) {
            c.displayInfo();
        }
    }

    public List<Contract> search(String keyword) {
        List<Contract> results = new ArrayList<>();
        for (Contract c : contracts) {
            if (c.getStatus().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(c);
            }
        }
        return results;
    }

    public Contract findById(int id) {
        for (Contract c : contracts) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}
