package model;

public enum OrderStatus {
    PENDING, CONFIRMED, CANCELLED, ACTIVE;

    public static OrderStatus fromString(String status) {
        if (status == null) return PENDING; 
        try {
            return valueOf(status.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return PENDING; 
        }
    }
}
