package tables;

import entities.Agreement;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class AgreementTable implements Serializable {
    private List<Agreement> agreements;

    public AgreementTable() {
        agreements = new ArrayList<>();
        agreements.add(new Agreement(1, "G9VE9NCFH0EWFHWH", 1, 10));
        agreements.add(new Agreement(2, "R8YER98EYF9HE8RY", 2, 9));
        agreements.add(new Agreement(3, "L3K4M34FN34F33N4", 3, 8));
        agreements.add(new Agreement(4, "9UER9ERG90ERGJER", 4, 7));
        agreements.add(new Agreement(5, "LM23M23F23IF2U7F", 5, 6));
        agreements.add(new Agreement(6, "JBFWFUF8H8YF38FH", 6, 5));
        agreements.add(new Agreement(7, "K3N453KF349F034J", 7, 4));
        agreements.add(new Agreement(8, "KLOIGWE98FYWEHFE", 8, 3));
        agreements.add(new Agreement(9, "MNVBJG34439FJ39F", 9, 2));
        agreements.add(new Agreement(10, "23K423D23023F9FI", 10, 1));
    }

    public List<Agreement> getAgreements() {
        return agreements;
    }
}
