package tables;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.io.Serializable;

@SessionScoped
public class CommonTable implements Serializable{
    @Inject
    String tableName;
    @Inject @ClientAnnotation
    InsuranceElement clientTable;
    @Inject @InsuranceAgentAnnotation
    InsuranceElement insuranceAgentTable;
    @Inject @AgreementAnnotation
    InsuranceElement agreementTable;

    public ClientTable getClientTable() {
        return (ClientTable) clientTable;
    }

    public AgreementTable getAgreementTable() {
        return (AgreementTable) agreementTable;
    }

    public InsuranceAgentTable getInsuranceAgentTable() {
        return (InsuranceAgentTable) insuranceAgentTable;
    }
}

class CommonTableProducer{
    @Produces
    String tableName = "Таблицы клиентов, страховых агентов и соглашений";
}
