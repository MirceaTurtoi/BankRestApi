package api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import api.utils.TransactionStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Double fee;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Account accountFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Account accountTo;

    public Transaction(Double amount, Double fee, Date date, TransactionStatus status, Account accountFrom, Account accountTo) {
        this.amount = amount;
        this.fee = fee;
        this.date = date;
        this.status = status;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", fee=" + fee +
                ", date=" + date +
                ", status=" + status +
                ", accountFrom=" + accountFrom.getName() +
                ", accountTo=" + accountTo.getName() +
                '}';
    }
}
