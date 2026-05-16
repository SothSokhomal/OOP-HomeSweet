package interfaces;

public interface StatusManageable {
    void updateStatus(String status);

    String getCurrentStatus();
}
