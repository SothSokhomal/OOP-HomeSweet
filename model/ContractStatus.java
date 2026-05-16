package model;

public enum ContractStatus {
    PENDING, ACTIVE, CANCELLED, EXPIRED;

    public static ContractStatus fromString(String status) {
        if (status == null) return PENDING; 
        try {
            return valueOf(status.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return PENDING; 
        }
    }
}
