package it.w06.d05.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "utenti")

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nomeutente;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(	name = "dispositivi_assegnati", 
				joinColumns = @JoinColumn(name = "id_utente"), 
				inverseJoinColumns = @JoinColumn(name = "id_dispositivo"))
	private Set<Dispositivo> dispositivi = new HashSet<>();	

}
