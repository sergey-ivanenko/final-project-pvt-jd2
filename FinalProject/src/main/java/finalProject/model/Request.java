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

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "payment")
    private Integer payment;

    @Column(name = "hours_in_week")
    private Integer hoursInWeek;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(/*cascade = CascadeType.ALL,*/ /*fetch = FetchType.LAZY*/)
    @JoinColumn(name = "user_id", nullable = false)
    private Client requester;

    public Request() {
    }

    public Request(Client requester, String job, String description, int payment, int hoursInWeek, Type type) {
        this.requester = requester;
        this.job = job;
        this.description = description;
        this.payment = payment;
        this.hoursInWeek = hoursInWeek;
        this.type = type;
    }

    public int getRequestId() {
        return requestId;
    }

    public Client getRequester() {
        return requester;
    }

    public String getJob() {
        return job;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPayment() {
        return payment;
    }

    public Integer getHoursInWeek() {
        return hoursInWeek;
    }

    public Type getType() {
        return type;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public void setHoursInWeek(Integer hoursInWeek) {
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
