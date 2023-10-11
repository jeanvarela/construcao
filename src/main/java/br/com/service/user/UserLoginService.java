package br.com.service.user;

import br.com.repository.UserLoginRepository;
import br.com.repository.entity.UserLogin;
import br.com.repository.entity.UserLoginType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserLoginService {

    private final UserLoginRepository userLoginRepository;
    public UserLogin createUserLogin(String login, String password, long userTypeId){
        UserLogin userLogin = UserLogin.builder()
                                       .login(login)
                                       .password(password)
                                       .userLoginType(UserLoginType.builder().id(userTypeId).build())
                                       .build();

        return this.userLoginRepository.save(userLogin);
    }
}
