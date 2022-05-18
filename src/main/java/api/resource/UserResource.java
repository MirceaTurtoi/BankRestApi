package api.resource;

import api.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.service.UserService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserResource {

    private UserService userService;

    @GetMapping("/{userId}/accounts")
    public ResponseEntity<List<AccountDto>> getAccountsByUser(@PathVariable Long userId) {
        log.info("here");
        return ResponseEntity.ok(userService.getAccountsByUser(userId));
    }
}
