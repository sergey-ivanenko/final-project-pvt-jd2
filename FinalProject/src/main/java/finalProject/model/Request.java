package finalProject.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "request", catalog = "labour_system")
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
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Client requester;

    public Request() {
    }

    public Request(Client requester, String job, int payment, int hoursInWeek, Type type) {
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

    public Type getType() {
        return type;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setHoursInWeek(int hoursInWeek) {
        this.hoursInWeek = hoursInWeek;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setRequester(Client requester) {
        this.requester = requester;
    }

    @Override
    public String toString() {
        return "Request:" + "requestId = " + requestId + ", job = " + job 
                          + ", payment = " + payment
                          + ", hoursInWeek = " + hoursInWeek + ", type = " + type;
    }
}
