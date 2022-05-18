package api.service;

import api.dto.AccountDto;
import api.entity.Account;
import api.exeptions.UserNotFoundExeption;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import api.repository.AccountRepository;
import api.repository.UserRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public List<AccountDto> getAccountsByUser(long userId) {
        log.info("userId"+userId);
        Set<Account> accounts = userRepository.findById(userId).orElseThrow(UserNotFoundExeption::new).getAccountSet();

        return accounts.stream()
                .map(account -> new AccountDto(account.getName(), account.getCurrency(), account.getBalance()))
                .collect(Collectors.toList());
    }
}
