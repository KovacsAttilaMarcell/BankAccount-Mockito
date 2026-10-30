public class BankService {

    private final BankAccount account;
    private final NotificationService notificationService;

    public BankService(BankAccount account, NotificationService notificationService) {
        this.account = account;
        this.notificationService = notificationService;
    }

    public void deposit(double amount) {
        account.deposit(amount);
        notificationService.send("Sikeres befizetés: " + amount);
    }
}
