package tables;

import javax.inject.Inject;

public class CommonTable {
    @Inject
    ClientTable clientTable;
    @Inject
    AgreementTable agreementTable;
    @Inject
    InsuranceAgentTable insuranceAgentTable;

    public ClientTable getClientTable() {
        clientTable.getClients().forEach(c -> System.out.println(c.getName()+ " " + c.getLastName()));
        return clientTable;
    }

    public AgreementTable getAgreementTable() {
        return agreementTable;
    }

    public InsuranceAgentTable getInsuranceAgentTable() {
        return insuranceAgentTable;
    }
}
