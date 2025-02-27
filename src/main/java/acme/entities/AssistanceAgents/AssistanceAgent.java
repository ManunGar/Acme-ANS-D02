
package acme.entities.AssistanceAgents;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import acme.client.components.basis.AbstractRole;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import acme.entities.Airlines.Airline;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class AssistanceAgent extends AbstractRole {

	private static final long	serialVersionUID	= 1L;

	//Attributes

	@Mandatory
	@ValidString(pattern = "^[A-Z]{2-3}\\d{6}$")
	@Column(unique = true)
	private String				employeeCode;

	@Mandatory
	@ValidString(max = 255)		//It is a List delimitated by comas
	@Column(length = 255)
	private String				spokenLanguages;

	@Mandatory
	@ValidMoment(past = true)
	@Automapped
	private Date				moment;

	@Optional
	@ValidString(max = 255)
	@Column(length = 255)
	private String				briefBio;

	@Optional
	@ValidMoney
	@Automapped
	private Money				salary;

	@Mandatory
	@ValidUrl
	@Automapped
	private String				photo;
	// Relationships

	@Mandatory
	@Valid
	@ManyToOne
	private Airline				airline;

}
