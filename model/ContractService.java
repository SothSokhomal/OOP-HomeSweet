package model;

import java.util.ArrayList;
import java.util.List;
import interfaces.Searchable;

public class ContractService implements Searchable<Contract> {
    private List<Contract> contracts = new ArrayList<>();

    public void addContract(Contract c) {
        contracts.add(c);
    }

    public void viewContracts() {
        System.out.println("\n--- Contract List ---");
        for (Contract c : contracts) {
            c.displayInfo();
        }
    }

    @Override
    public List<Contract> search(String keyword) {
        List<Contract> results = new ArrayList<>();
        for (Contract c : contracts) {
            if (c.getStatus().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(c);
            }
        }
        return results;
    }

    @Override
    public Contract findById(int id) {
        for (Contract c : contracts) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}
