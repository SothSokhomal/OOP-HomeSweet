package model;

public enum OrderStatus {
    PENDING, CONFIRMED, CANCELLED, ACTIVE;

    public static OrderStatus fromString(String status) {
        if (status == null) return PENDING; // Default to PENDING if null
        try {
            return valueOf(status.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return PENDING; // Default to PENDING if invalid
        }
    }
}
