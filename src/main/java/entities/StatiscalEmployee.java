package entities;

import jakarta.persistence.Entity;

@jakarta.persistence.DiscriminatorValue("statiscal_employee")
@Entity
public class StatiscalEmployee extends Person {

}
