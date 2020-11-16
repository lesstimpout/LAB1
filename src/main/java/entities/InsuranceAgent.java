package entities;

public class InsuranceAgent {
    private int id;
    private String name;
    private String lastName;
    private String agencyName;
    private int agreementId;

    public InsuranceAgent(int id, String name, String lastName, String agencyName, int agreementId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.agencyName = agencyName;
        this.agreementId = agreementId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public int getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(int agreementId) {
        this.agreementId = agreementId;
    }
}
