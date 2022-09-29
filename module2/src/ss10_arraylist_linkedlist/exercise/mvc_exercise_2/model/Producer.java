package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model;

public class Producer {
    private String code;
    private String name;
    private String nation;

    public Producer(String code, String name, String nation) {
        this.code = code;
        this.name = name;
        this.nation = nation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return name + "{" +
                " Mã hãng sản xuất: " + code +
                ", Quốc gia: " + nation +
                '}';
    }

    public String getInformation() {
        return String.format("%s,%s,%s", this.code, this.name, this.nation);
    }
}
