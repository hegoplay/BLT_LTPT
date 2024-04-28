package entities;

import java.util.Set;

import jakarta.persistence.Entity;

@jakarta.persistence.DiscriminatorValue("storage_employee")
@Entity
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class StorageEmployee extends Person implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4189187737331148223L;
	@jakarta.persistence.OneToMany(mappedBy = "storageEmployee")
	Set<EditHistory> editHistories;
	@jakarta.persistence.OneToMany(mappedBy = "storageEmployee")
	Set<Order> orders;
}
