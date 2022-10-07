package case_study.model.contract;

public class Contract {
    private String contractCode;
    private String bookingCode;
    private Integer contractDeposit;
    private Integer contractTotalPayment;
    private String customerCode;

    public Contract() {
    }

    public Contract(String contractCode, String bookingCode, String customerCode, Integer contractTotalPayment, Integer contractDeposit) {
        this.contractCode = contractCode;
        this.bookingCode = bookingCode;
        this.contractDeposit = contractDeposit;
        this.contractTotalPayment = contractTotalPayment;
        this.customerCode = customerCode;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Integer getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Integer contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Integer getContractTotalPayment() {
        return contractTotalPayment;
    }

    public void setContractTotalPayment(Integer contractTotalPayment) {
        this.contractTotalPayment = contractTotalPayment;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
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
