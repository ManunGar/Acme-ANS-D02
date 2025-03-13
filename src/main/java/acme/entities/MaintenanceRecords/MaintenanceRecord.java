
package acme.entities.MaintenanceRecords;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.constraints.ValidLongText;
import acme.entities.Aircrafts.Aircraft;
import acme.realms.Technician;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MaintenanceRecord extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				maintenanceMoment;

	@Mandatory
	@Valid
	@Automapped
	private MaintenanceStatus	status;

	@Mandatory
	@ValidMoment(past = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				nextInspection;

	@Mandatory
	@Min(0)
	@Automapped
	private Double				estimatedCost;

	@Optional
	@ValidLongText
	@Automapped
	private String				notes;

	@Mandatory
	@Valid
	@ManyToOne
	private Technician			technician;

	@Mandatory
	@Valid
	@ManyToOne
	private Aircraft			aircraft;
}
