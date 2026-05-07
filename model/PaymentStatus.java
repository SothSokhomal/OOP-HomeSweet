package model;
public enum PaymentStatus {
    PAID, UNPAID, PENDING;

    public static PaymentStatus fromString(String status) {
        if (status == null) return UNPAID; 
        try {
            return valueOf(status.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNPAID; 
        }
    }
}
