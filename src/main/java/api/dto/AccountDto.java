package api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import api.utils.Currency;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class AccountDto {

    private Double balance;
    @NotBlank
    private Currency currency;

    private String name;

    public AccountDto(String name, @NotBlank Currency currency, Double balance) {
        this.balance = balance;
        this.currency = currency;
        this.name = name;
    }
}
