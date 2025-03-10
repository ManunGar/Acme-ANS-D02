
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.components.validation.AbstractValidator;
import acme.entities.Reviews.Review;
import acme.entities.Reviews.ReviewRepository;

public class ReviewValidator extends AbstractValidator<ValidReview, Review> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private ReviewRepository reviewRepository;

	// ConstraintValidator interface ------------------------------------------


	@Override
	protected void initialise(final ValidReview annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final Review review, final ConstraintValidatorContext context) {
		assert context != null;

		boolean result;

		if (review == null)
			super.state(context, false, "*", "javax.validation.constraints.NotNull.message");
		else {
			boolean oneRelationship;
			if (review.getAirline() != null && review.getAirport() == null && review.getService() == null || review.getAirline() == null && review.getAirport() != null && review.getService() == null
				|| review.getAirline() == null && review.getAirport() == null && review.getService() != null)
				oneRelationship = true;
			else
				oneRelationship = false;

			super.state(context, oneRelationship, "*", "acme.validation.Review.NotRelation");

		}

		result = !super.hasErrors(context);

		return result;
	}

}
