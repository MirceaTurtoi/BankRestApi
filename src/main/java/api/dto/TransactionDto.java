package api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private Long id;
    private Double amount;
    private Double fee;
    private String date;
    private String Status;
    private Long idAccountFrom;
    private Long idAccountTo;
}
