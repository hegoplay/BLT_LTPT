package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Table(name = "accounts")
public class Account {
	@jakarta.persistence.Id
	@jakarta.persistence.Column(name = "user_name")
	private String userName;
	private String password;
}
