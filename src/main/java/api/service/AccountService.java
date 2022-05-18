package api.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import api.repository.AccountRepository;

@Component
@AllArgsConstructor
public class AccountService {

    AccountRepository accountRepository;

}
