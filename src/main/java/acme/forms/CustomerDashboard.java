
package acme.forms;

import acme.client.components.basis.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDashboard extends AbstractForm {

	private static final long	serialVersionUID	= 1L;

	String[]					lastFiveDestinations;
	Double						moneySpentInBookingsLastYear;
	Integer						numberOfBookingsEconomy;
	Integer						numberOfBookingsBusiness;
	Integer						countOfBookingsLastFiveYears;
	Double						averageCostOfBookingsLastFiveYears;
	Double						minimumCostOfBookingsLastFiveYears;
	Double						maximumCostOfBookingsLastFiveYears;
	Double						standardDeviationCostOfBookingsLastFiveYears;
	Integer						countOfPassengersInBookings;
	Double						averagePassengersInBookings;
	Integer						minimumPassengersInBookings;
	Integer						maximumPassengersInBookings;
	Double						standardDeviationPassengersInBookings;

}
