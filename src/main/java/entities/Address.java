package entities;

import jakarta.persistence.Embeddable;

@Embeddable
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Address {
	private String zip;
	private String city;
	private String street;
	private String number;
}
