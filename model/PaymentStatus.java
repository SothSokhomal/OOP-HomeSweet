package model;
public enum PaymentStatus {
    PENDING, PAID, FAILED;

    public static PaymentStatus fromString(String status) {
        if (status == null) return PENDING; 
        try {
            return valueOf(status.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return PENDING; 
        }
    }
}
