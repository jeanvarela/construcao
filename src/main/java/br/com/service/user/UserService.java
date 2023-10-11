package br.com.service.user;

import br.com.repository.entity.*;
import br.com.repository.UserRepository;
import br.com.service.model.UserTO;
import br.com.service.model.enumeration.UserLoginEnum;
import br.com.service.model.enumeration.UserTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    private final UserLoginService userLoginService;

    public User insertUserConstructor(UserTO userTO, long companyId){
        validateEmailUsed(userTO.getEmail());

        UserLogin userLogin = this.userLoginService.createUserLogin(userTO.getEmail(),userTO.getPassword(), UserLoginEnum.USER.getValue());

        UserType userType = UserType.builder()
                .id(UserTypeEnum.CONSTRUCTOR.getValue())
                .build();

        Company company = Company.builder()
                .id(companyId)
                .build();

        User user = User.builder()
                .email(userTO.getEmail())
                .userType(userType)
                .name(userTO.getName())
                .company(company)
                .userLogin(userLogin)
                .build();

       return this.userRepository.save(user);
    }

    public void validateEmailUsed(String email){
        Optional<User> user = this.userRepository.findUserByEmail(email);

        if (user.isPresent()){
            System.out.println("Ocorreu erro");
        }
    }
}
