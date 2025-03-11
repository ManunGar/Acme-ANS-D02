
package acme.entities.MaintenanceRecords;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import acme.client.components.basis.AbstractEntity;
import acme.entities.Tasks.Task;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MaintenanceRecordTask extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@ManyToOne(optional = false)
	private MaintenanceRecord	maintenanceRecord;

	@ManyToOne(optional = false)
	private Task				task;
}
