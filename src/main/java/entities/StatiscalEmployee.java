package entities;

import jakarta.persistence.Entity;

@jakarta.persistence.DiscriminatorValue("statiscal_employee")
@Entity
public class StatiscalEmployee extends Person implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6806766646736629471L;

}
