package case_study.model.contract;

public class Contract {
    private String contractCode;
    private String bookingCode;
    private Double contractDeposit;
    private Double contractTotalPayment;
    private String customerCode;

    public Contract() {
    }

    public Contract(String contractCode, String bookingCode, Double contractDeposit, Double contractTotalPayment, String customerCode) {
        this.contractCode = contractCode;
        this.bookingCode = bookingCode;
        this.contractDeposit = contractDeposit;
        this.contractTotalPayment = contractTotalPayment;
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractCode='" + contractCode + '\'' +
                ", bookingCode='" + bookingCode + '\'' +
                ", contractDeposit=" + contractDeposit +
                ", contractTotalPayment=" + contractTotalPayment +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
