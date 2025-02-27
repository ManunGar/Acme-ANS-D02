
package acme.entities.TrackingLogs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrackingLog extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@ValidMoment(past = true)
	@Automapped
	private Date				lastUpdateMoment;

	@Mandatory
	@ValidString(max = 50)
	@Column(length = 50)
	private String				step;

	@Mandatory
	@ValidNumber(min = 0, max = 100)
	@Automapped
	private double				resolutionPercentage;

	@Mandatory
	@Automapped
	private boolean				indicator;

	@Optional
	@ValidString(max = 255)
	@Column(length = 255)
	private String				resolution;

}
