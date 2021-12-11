public interface DatabaseConnection {
    boolean isOpened();
    void open();
    boolean close();
}
