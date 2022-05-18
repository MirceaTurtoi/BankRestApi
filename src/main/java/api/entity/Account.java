package api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import api.utils.Currency;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "balance", nullable = true)
    private Double balance;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "accountFrom", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Transaction> transactionSet1;

    @OneToMany(mappedBy = "accountTo", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Transaction> transactionSet2;

    public Account(String name, Double balance, Currency currency, User user) {
        this.name = name;
        this.balance = balance;
        this.currency = currency;
        this.user = user;
    }
}
