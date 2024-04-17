package run;

import jakarta.persistence.Persistence;

public class Ex {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("JPA_SQL_SERVER");
	}
}
