package tables;

import entities.InsuranceAgent;

import javax.enterprise.context.SessionScoped;
import javax.inject.Qualifier;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
@interface InsuranceAgentAnnotation {}

@SessionScoped
@InsuranceAgentAnnotation
public class InsuranceAgentTable implements Serializable, InsuranceElement {
    private List<InsuranceAgent> insuranceAgents;

    public InsuranceAgentTable() {
        insuranceAgents = new ArrayList<>();
        insuranceAgents.add(new InsuranceAgent(1, "Анатолий", "Щербунь", "Страх компани", 1));
        insuranceAgents.add(new InsuranceAgent(2, "Руслан", "Белый", "Страховка24", 2));
        insuranceAgents.add(new InsuranceAgent(3, "Мария", "Бондаренко", "Insurance", 3));
        insuranceAgents.add(new InsuranceAgent(4, "Вадим", "Борзенко", "Страхова Гарантія", 4));
        insuranceAgents.add(new InsuranceAgent(5, "Владислав", "Коваленко", "Страхова Компанія Престиж", 5));
        insuranceAgents.add(new InsuranceAgent(6, "Юрий", "Ковалёв", "Страховка24", 6));
        insuranceAgents.add(new InsuranceAgent(7, "Анна", "Соловьёва", "Страх компани", 7));
        insuranceAgents.add(new InsuranceAgent(8, "Алексей", "Мотыгин", "Insurance", 8));
        insuranceAgents.add(new InsuranceAgent(9, "Кирилл", "Лазагович", "Страх компани", 9));
        insuranceAgents.add(new InsuranceAgent(10, "Александр", "Петров", "Страхова Гарантія", 10));
    }

    public List<InsuranceAgent> getInsuranceAgents() {
        return insuranceAgents;
    }
}
