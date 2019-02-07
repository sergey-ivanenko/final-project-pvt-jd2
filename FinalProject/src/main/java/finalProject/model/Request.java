package finalProject.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "requests", catalog = "labour_system")
public class Request implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "request_id", nullable = false, unique = true)	
	private int requestId;
	
	@Column(name = "job", nullable = false, length = 40)
	private String job;
	
	@Column(name = "payment")
	private int payment;
	
	@Column(name = "hours_in_week")
	private int hoursInWeek;
	
	@Column(name = "type")
	private int type;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private Client requester;

	public Request(Client requester, String job, int payment, int hoursInWeek, int type) {
		this.requester = requester;
		this.job = job;
		this.payment = payment;
		this.hoursInWeek = hoursInWeek;
		this.type = type;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	
	public Client getRequester() {
		return requester;
	}

	public String getJob() {
		return job;
	}

	public int getPayment() {
		return payment;
	}

	public int getHoursInWeek() {
		return hoursInWeek;
	}

	public int getType() {
		return type;
	}	
}
