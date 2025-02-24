
package acme.entities.Airports;

import javax.persistence.Column;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;

public class Airport extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@ValidString(max = 50)
	@Automapped
	private String				name;

	@Mandatory
	@ValidString(max = 3, pattern = "^[A-Z]+$")
	@Column(unique = true)
	private String				IATAcode;

	@Mandatory
	@Automapped
	private OperationalScope	operationalScope;

	@Mandatory
	@ValidString(max = 50)
	@Automapped
	private String				city;

	@Mandatory
	@ValidString(max = 50)
	@Automapped
	private String				country;

	@Optional
	@ValidUrl
	@Automapped
	private String				website;

	@Optional
	@ValidString
	@Column(unique = true)
	private String				address;

	@Optional
	@ValidString(pattern = "^\\+?\\d{6,15}$")
	@Automapped
	private String				contactPhoneNumber;

}
