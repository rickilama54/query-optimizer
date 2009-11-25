package queryopt.pages;

import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import queryopt.entities.Schema;
import queryopt.model.SessionData;

/**
 * Start page of application query_optimizer.
 */
public class Index {
	@SessionState
	private SessionData sessionData;

	@Inject
	private Session session;

	void setupRender() {
		if (sessionData.getSelectedSchema() == null)
			sessionData.setSelectedSchema((Schema) session.createCriteria(Schema.class).addOrder(Order.asc("name"))
					.list().get(0));
		System.out.println("sessinoDAta:" + sessionData);
	}
}
