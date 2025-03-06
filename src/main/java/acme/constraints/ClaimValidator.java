
package acme.constraints;

import java.util.List;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.components.validation.AbstractValidator;
import acme.entities.Claims.Claim;
import acme.entities.Claims.ClaimRepository;
import acme.entities.TrackingLogs.TrackingLog;

public class ClaimValidator extends AbstractValidator<ValidClaim, Claim> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private ClaimRepository repository;

	// ConstraintValidator interface ------------------------------------------


	@Override
	protected void initialise(final ValidClaim annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final Claim claim, final ConstraintValidatorContext context) {
		// HINT: job can be null
		assert context != null;

		boolean result;

		if (claim == null)
			super.state(context, false, "*", "javax.validation.constraints.NotNull.message");
		else {
			boolean correctIndicator;
			boolean trackingLogAccepted;
			List<TrackingLog> trackingLogs = this.repository.findAllByClaimId(claim.getId());
			if (trackingLogs.stream().filter(x -> x.getResolutionPercentage() == 100.).anyMatch(x -> x.isAccepted()))
				trackingLogAccepted = true;
			else
				trackingLogAccepted = false;

			if (trackingLogs.stream().filter(x -> x.getResolutionPercentage() == 100.).toList().isEmpty())
				correctIndicator = true;
			else
				correctIndicator = claim.isAccepted() == trackingLogAccepted;

			super.state(context, correctIndicator, "indicator", "acme.validation.claim.indicator.message");
		}

		result = !super.hasErrors(context);

		return result;
	}

}
