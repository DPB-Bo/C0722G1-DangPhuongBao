package bank_menu.model;

public abstract class BankAccount {
    private int id;
    private String codeAccount;
    private String ownerName;
    private String dateCreated;

    public BankAccount() {
    }

    public BankAccount(int id, String codeAccount, String ownerName, String dateCreated) {
        this.codeAccount = codeAccount;
        this.id = id;
        this.ownerName = ownerName;
        this.dateCreated = dateCreated;
    }

    public abstract String getInformation();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeAccount() {
        return codeAccount;
    }

    public void setCodeAccount(String idAccount) {
        this.codeAccount = idAccount;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return " ID tài khoản: " + id +
                ", Mã tài khoản: " + codeAccount +
                ", Tên chủ sở hữu: " + ownerName +
                ", Ngày tạo tài khoản: " + dateCreated;
    }
}
