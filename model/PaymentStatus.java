package model;
public enum PaymentStatus {
    PAID, UNPAID, PENDING;

    public static PaymentStatus fromString(String status) {
        if (status == null) return UNPAID; // Default to UNPAID if null
        try {
            return valueOf(status.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNPAID; // Default to UNPAID if invalid
        }
    }
}
