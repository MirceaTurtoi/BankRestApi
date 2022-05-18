package api.service;

import api.dto.TransactionDto;
import api.entity.Account;
import api.entity.Transaction;
import api.exeptions.AccountNotFoundException;
import api.exeptions.TransactionAlreadyProcessedException;
import api.exeptions.TransactionNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import api.repository.AccountRepository;
import api.repository.TransactionRepository;
import api.utils.Fees;
import api.utils.TransactionStatus;

import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class TransactionService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public Transaction requestTransaction(TransactionDto transactionDto) {

        Double amount = transactionDto.getAmount();
        Long idAccountTo = transactionDto.getIdAccountTo();
        Long idAccountFrom = transactionDto.getIdAccountFrom();

        if (!idAccountFrom.equals(idAccountTo) && (amount > 0)){

            Account accountFrom = accountRepository.findById(idAccountFrom).orElseThrow(() -> new AccountNotFoundException("Account not found!"));
            Account accountTo = accountRepository.findById(idAccountTo).orElseThrow(() -> new AccountNotFoundException("Account not found!"));

            Fees fees = new Fees();

            Transaction transaction = new Transaction(transactionDto.getAmount(),
                    fees.getFee(accountFrom.getCurrency(), accountTo.getCurrency()),
                    new Date(),
                    TransactionStatus.PENDING,
                    accountFrom,
                    accountTo);



            return transactionRepository.save(transaction);
        } else throw  new IllegalArgumentException();
    }

    public Transaction processTransaction(Long idTransaction, Boolean response){

        Transaction transaction = transactionRepository.findById(idTransaction)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));

        if (transaction.getStatus().equals(TransactionStatus.PENDING)) {

            if (response){

                Account accountFrom = transaction.getAccountFrom();
                Account accountTo = transaction.getAccountTo();
                double amount = transaction.getAmount();
                double fee = transaction.getFee();

                accountFrom.setBalance(accountFrom.getBalance() - amount*fee);
                accountTo.setBalance(accountTo.getBalance() + amount);

                transaction.setStatus(TransactionStatus.APPROVED);
            } else {
                transaction.setStatus(TransactionStatus.DENIED);
            }

            return transactionRepository.save(transaction);

        } else throw new TransactionAlreadyProcessedException("Transaction already processed!");
    }

    public List<Transaction> getAccountTransactions(Long idAccount){
        return transactionRepository.findByAccountIfPending(idAccount);
    }

    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }

    public List<Transaction> getOutcomeTransactions(Long idAccount){
        return transactionRepository.findByAccountFromIfApproved(idAccount);
    }

    public List<Transaction> getIncomeTransactions(Long idAccount){
        return transactionRepository.findByAccountToIfApproved(idAccount);
    }


}
