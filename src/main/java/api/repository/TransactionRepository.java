package api.repository;

import api.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM transaction t WHERE (t.status = 'PENDING') AND (t.account_from_id = ?1 OR t.account_to_id = ?1)")
    List<Transaction> findByAccountIfPending(Long idAccount);

    @Query(value = "SELECT * FROM transaction t WHERE t.status = 'APPROVED' and t.account_from_id = ?1", nativeQuery = true)
    List<Transaction> findByAccountFromIfApproved(Long accountId);

    @Query(value = "SELECT * FROM transaction t WHERE t.status = 'APPROVED' and t.account_to_id = ?1", nativeQuery = true)
    List<Transaction> findByAccountToIfApproved(Long accountId);
}
