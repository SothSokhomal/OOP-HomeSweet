package model;

public interface StatusManageable {
    void updateStatus(String status);
    String getCurrentStatus();
}
