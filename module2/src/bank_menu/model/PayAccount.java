package bank_menu.model;

public class PayAccount extends BankAccount {
    private String cardCode;
    private int moneyInAccount;

    public PayAccount() {
    }

    public PayAccount(int id, String codeAccount, String ownerName, String dateCreated, String cardCode, int moneyInAccount) {
        super(id, codeAccount, ownerName, dateCreated);
        this.cardCode = cardCode;
        this.moneyInAccount = moneyInAccount;
    }


    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public int getMoneyInAccount() {
        return moneyInAccount;
    }

    public void setMoneyInAccount(int moneyInAccount) {
        this.moneyInAccount = moneyInAccount;
    }

    @Override
    public String getInformation() {
        return String.format("%s,%s,%s,%s,%s,%s", this.getId(), this.getCodeAccount(), this.getOwnerName(), this.getDateCreated(), this.getCardCode(), this.getMoneyInAccount());
    }

    @Override
    public String toString() {
        return "Tài khoản thanh toán[ " +
                super.toString() +
                "Số thẻ: " + cardCode +
                ", Tiền trong tài khoản: " + moneyInAccount +
                " ]";
    }
}
