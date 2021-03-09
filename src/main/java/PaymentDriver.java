import com.model.Payment;
import com.service.PaymentService;

public class PaymentDriver {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        float carPrice = 28000;
        float downPayment = 3000;
        float loanAmount = paymentService.calculateLoanAmount(carPrice, downPayment);
        float interestRate = 3.12f;
        int months = 60;
        Payment payment = new Payment(carPrice,downPayment,loanAmount,interestRate,months);
        System.out.println(paymentService.calculateMonthlyPayment(payment));
    }
}
