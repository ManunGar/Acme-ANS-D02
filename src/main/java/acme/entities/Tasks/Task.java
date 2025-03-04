
package acme.entities.Tasks;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.PositiveOrZero;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@Enumerated(EnumType.STRING)
	@Automapped
	private TaskType			type;

	@Mandatory
	@ValidString
	@Automapped
	private String				description;

	@Mandatory
	@ValidNumber(min = 0, max = 10)
	@Automapped
	private Integer				priority;

	@Mandatory
	@PositiveOrZero
	@Automapped
	private Integer				estimatedDuration;
}
