package entities;

import java.util.Set;

import jakarta.persistence.Entity;

@jakarta.persistence.DiscriminatorValue("storage_employee")
@Entity
public class StorageEmployee extends Person{
	@jakarta.persistence.OneToMany(mappedBy = "storageEmployee")
	Set<EditHistory> editHistories;
	@jakarta.persistence.OneToMany(mappedBy = "storageEmployee")
	Set<Order> orders;
}
