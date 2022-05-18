package api.resource;

import api.dto.TransactionDto;
import api.entity.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.service.TransactionService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/transactions")
public class TransactionResource {

    TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> requestTransaction(@RequestBody TransactionDto transactionDto){

        return ResponseEntity.ok(transactionService.requestTransaction(transactionDto));
    }

    @GetMapping("/{idAccount}")
    public ResponseEntity<List<Transaction>> getTransactionsByStatus(@PathVariable Long idAccount){
        return ResponseEntity.ok(transactionService.getAccountTransactions(idAccount));
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<Transaction>> getAllTransactions(){
//        return ResponseEntity.ok(transactionService.getAll());
//    }

    @PatchMapping("/{idTransaction}/{response}")
    public ResponseEntity<Transaction> processTransaction(@PathVariable Long idTransaction,@PathVariable Boolean response){
        return ResponseEntity.ok(transactionService.processTransaction(idTransaction, response));
    }

    @GetMapping("/{idAccount}/income")
    public ResponseEntity<List<Transaction>> getIncomeTransactions(@PathVariable Long idAccount){
        return ResponseEntity.ok(transactionService.getIncomeTransactions(idAccount));
    }

    @GetMapping("/{idAccount}/outcome")
    public ResponseEntity<List<Transaction>> getOutcomeTransactions(@PathVariable Long idAccount){
        return ResponseEntity.ok(transactionService.getOutcomeTransactions(idAccount));
    }

}
