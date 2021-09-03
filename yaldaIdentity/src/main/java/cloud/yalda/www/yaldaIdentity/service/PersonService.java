package cloud.yalda.www.yaldaIdentity.service;

import cloud.yalda.www.yaldaIdentity.CustomeExceptions.UserException;
import cloud.yalda.www.yaldaIdentity.dto.PersonProfileDto;
import cloud.yalda.www.yaldaIdentity.dto.ProfileUpdateDto;
import cloud.yalda.www.yaldaIdentity.dto.UpdatePassDto;
import cloud.yalda.www.yaldaIdentity.model.Person;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    PersonProfileDto getProfile(String id) throws UserException;

    boolean authenticate(String email, String password);

    boolean isExists(String email);

    int update(ProfileUpdateDto dto) throws UserException;

    int updatePassword(UpdatePassDto dto) throws UserException;

    String register(String email) throws UserException;
    List<Person> listAll(Pageable page);
}
