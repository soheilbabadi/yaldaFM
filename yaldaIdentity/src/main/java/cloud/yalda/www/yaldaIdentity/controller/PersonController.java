package cloud.yalda.www.yaldaIdentity.controller;

import cloud.yalda.www.yaldaIdentity.CustomeExceptions.UserException;
import cloud.yalda.www.yaldaIdentity.dto.AuthenticateDto;
import cloud.yalda.www.yaldaIdentity.dto.ProfileUpdateDto;
import cloud.yalda.www.yaldaIdentity.dto.UpdatePassDto;
import cloud.yalda.www.yaldaIdentity.helper.ApiResult;
import cloud.yalda.www.yaldaIdentity.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "Identity manager",path = "/identity/person/v1")
public class PersonController {
   @Autowired
    private final PersonService _personService;
    @Autowired
    private final ApiResult _result;

    public PersonController(PersonService personService, ApiResult result) {
        _personService = personService;
        _result = result;
    }

    @GetMapping(name = "get",path = "/{id}")
    public ApiResult get(@PathVariable String id){

        try {
            var result= _personService.getProfile(id);
            _result.setData(result);

        } catch (Exception e) {
        _result.fatalError(e);
        }
        return _result;
    }

    @PostMapping(name = "list-all",path = "/list-all")
    public ApiResult listAll(@RequestBody Pageable page){

        try {
            var result= _personService.listAll(page);
            _result.setData(result);

        } catch (Exception e) {
            _result.fatalError(e);
        }
        return _result;
    }

    @PostMapping(name = "post",path = "/{email}")
    public ApiResult post(@PathVariable String email){

        try {
            var result= _personService.register(email);
            _result.saved();
            _result.setData(result);

        } catch (Exception e) {_result.fatalError(e);

        }
        return _result;
    }
    @PostMapping(name = "authenticate",path = "/authenticate")
    public ApiResult post(@RequestBody AuthenticateDto dto){

        try {
            var result= _personService.authenticate(dto.getEmail(),dto.getPassword());
          _result.setData(result);

        } catch (Exception e) {
            _result.fatalError(e);
        }
        return _result;
    }
    @PutMapping(name = "putPassword",path = "/put-password")
    public ApiResult putPassword(@RequestBody UpdatePassDto dto){
        try {
            _personService.updatePassword(dto);
            _result.saved();

        } catch (Exception e) {_result.fatalError(e); }
        return _result;
    }
    @PutMapping(name = "put",path = "/")
    public ApiResult put(@RequestBody ProfileUpdateDto dto){

        try {
            _personService.update(dto);
            _result.saved();


        } catch (Exception e) {_result.fatalError(e);
        }
        return _result;
    }

}
