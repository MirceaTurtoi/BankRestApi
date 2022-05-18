package api.resource;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.service.AccountService;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountResource {
    private AccountService accountService;
}
//Transaction history should be possible only after selecting an account
