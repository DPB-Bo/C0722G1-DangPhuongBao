package bank_menu.model;

public class SaveAccount extends BankAccount {
    private int saveMoney;
    private String dateSaved;
    private int bonus;
    private int limitTime;

    public SaveAccount() {
    }

    public SaveAccount(int id, String codeAccount, String ownerName, String dateCreated, int saveMoney, String dateSaved, int bonus, int limitTime) {
        super(id, codeAccount, ownerName, dateCreated);
        this.saveMoney = saveMoney;
        this.dateSaved = dateSaved;
        this.bonus = bonus;
        this.limitTime = limitTime;
    }

    public int getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(int saveMoney) {
        this.saveMoney = saveMoney;
    }

    public String getDateSaved() {
        return dateSaved;
    }

    public void setDateSaved(String dateSaved) {
        this.dateSaved = dateSaved;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(int limitTime) {
        this.limitTime = limitTime;
    }

    @Override
    public String getInformation() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", this.getId(), this.getCodeAccount(), this.getOwnerName(), this.getDateCreated(), this.getSaveMoney(), this.getDateSaved(), this.getBonus(), this.getLimitTime());
    }

    @Override
    public String toString() {
        return "Tài khoản tiết kiệm[ " +
                super.toString() +
                ", Số tiền gửi tiết kiệm: " + saveMoney +
                ", Ngày gửi tiết kiệm: " + dateSaved +
                ", Lãi suất: " + bonus +
                ", Kì hạn: " + limitTime +
                " ]";
    }
}
