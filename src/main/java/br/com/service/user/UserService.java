package br.com.service.user;

import br.com.repository.entity.Company;
import br.com.repository.entity.User;
import br.com.repository.entity.UserType;
import br.com.repository.UserRepository;
import br.com.service.model.UserTO;
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

    public User insertUserConstructor(UserTO userTO, long companyId){
        validateEmailUsed(userTO.getEmail());

        UserType userType = UserType.builder()
                .id(UserTypeEnum.CONSTRUCTOR.getValue())
                .build();

        Company company = Company.builder()
                .id(companyId)
                .build();

        User user = User.builder()
                .email(userTO.getEmail())
                .password(userTO.getPassword())
                .userType(userType)
                .name(userTO.getName())
                .company(company)
                .build();

       return this.userRepository.save(user);
    }

    private void validateEmailUsed(String email){
        Optional<User> user = this.userRepository.findUserByEmail(email);

        if (user.isPresent()){

        }
    }
}
