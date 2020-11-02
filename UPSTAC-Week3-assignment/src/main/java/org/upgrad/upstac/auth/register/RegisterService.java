package org.upgrad.upstac.auth.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upgrad.upstac.exception.AppException;
import org.upgrad.upstac.users.User;
import org.upgrad.upstac.users.UserService;
import org.upgrad.upstac.users.models.AccountStatus;
import org.upgrad.upstac.users.roles.UserRole;

import java.time.LocalDateTime;

import static org.upgrad.upstac.shared.DateParser.getDateFromString;


@Service
public class RegisterService {

    @Autowired
    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(RegisterService.class);

    public User addUser(RegisterRequest addUserRegisterRequest) {

/*      User should be validated before registration.
                the username , email and phone number should be unique (i.e should throw AppException if the RegisterRequest has the same username or email or phone number)
                    hint:
                        userService.findByUserName
                        userService.findByEmail
                        userService.findByPhoneNumber

         A new User Object should be created with same details as registerRequest
                password should be encrypted with help of   userService.toEncrypted
                roles should be set with help of  userService.getRoleFor(UserRole.USER)
                status should be set to AccountStatus.APPROVED

        And finally
            Call userService.saveInDatabase to save the new user and return the saved user
*/
        if(userService.findByUserName(addUserRegisterRequest.getUserName()) != null){
            throw new AppException("User Already Exists!");
        }

        if(userService.findByEmail(addUserRegisterRequest.getEmail()) != null){
            throw new AppException("Email already taken!");
        }

        if(userService.findByPhoneNumber(addUserRegisterRequest.getPhoneNumber()) != null){
            throw new AppException("Phone Number already taken!");
        }
        User newUser = new User();
        newUser.setUserName(addUserRegisterRequest.getUserName());
        newUser.setPassword(userService.toEncrypted(addUserRegisterRequest.getPassword()));
        newUser.setRoles(userService.getRoleFor(UserRole.USER));
        newUser.setCreated(LocalDateTime.now());
        newUser.setUpdated(LocalDateTime.now());
        newUser.setAddress(addUserRegisterRequest.getAddress());
        newUser.setFirstName(addUserRegisterRequest.getFirstName());
        newUser.setLastName(addUserRegisterRequest.getLastName());
        newUser.setEmail(addUserRegisterRequest.getEmail());
        newUser.setPhoneNumber(addUserRegisterRequest.getPhoneNumber());
        newUser.setPinCode(addUserRegisterRequest.getPinCode());
        newUser.setGender(addUserRegisterRequest.getGender());
        newUser.setAddress(addUserRegisterRequest.getAddress());
        newUser.setDateOfBirth(getDateFromString(addUserRegisterRequest.getDateOfBirth()));
        newUser.setStatus(AccountStatus.APPROVED);
        return userService.saveInDatabase(newUser);
    }

    public User addDoctor(RegisterRequest addDoctorRegisterRequest) {
/*      Doctor should be validated before registration.
                the username , email and phone number should be unique (i.e should throw AppException if the RegisterRequest has the same username or email or phone number)
                    hint:
                        userService.findByUserName
                        userService.findByEmail
                        userService.findByPhoneNumber

         A new User Object should be created with same details as registerRequest
                password should be encrypted with help of   userService.toEncrypted
                roles should be set with help of  userService.getRoleFor(UserRole.DOCTOR)
                status should be set to AccountStatus.INITIATED

        And finally
            Call userService.saveInDatabase to save the newly registered doctor and return the saved value
*/
        if(userService.findByUserName(addDoctorRegisterRequest.getUserName()) != null){
            throw new AppException("Doctor Already Exists!");
        }

        if(userService.findByEmail(addDoctorRegisterRequest.getEmail()) != null){
            throw new AppException("Doctor Email already taken!");
        }

        if(userService.findByPhoneNumber(addDoctorRegisterRequest.getPhoneNumber()) != null){
            throw new AppException("Doctor Phone Number already taken!");
        }

        User newDoctor = new User();
        newDoctor.setUserName(addDoctorRegisterRequest.getUserName());
        newDoctor.setPassword(userService.toEncrypted(addDoctorRegisterRequest.getPassword()));
        newDoctor.setRoles(userService.getRoleFor(UserRole.DOCTOR));
        newDoctor.setCreated(LocalDateTime.now());
        newDoctor.setUpdated(LocalDateTime.now());
        newDoctor.setAddress(addDoctorRegisterRequest.getAddress());
        newDoctor.setFirstName(addDoctorRegisterRequest.getFirstName());
        newDoctor.setLastName(addDoctorRegisterRequest.getLastName());
        newDoctor.setEmail(addDoctorRegisterRequest.getEmail());
        newDoctor.setPhoneNumber(addDoctorRegisterRequest.getPhoneNumber());
        newDoctor.setPinCode(addDoctorRegisterRequest.getPinCode());
        newDoctor.setGender(addDoctorRegisterRequest.getGender());
        newDoctor.setAddress(addDoctorRegisterRequest.getAddress());
        newDoctor.setDateOfBirth(getDateFromString(addDoctorRegisterRequest.getDateOfBirth()));
        newDoctor.setStatus(AccountStatus.INITIATED);
        return userService.saveInDatabase(newDoctor);
    }

    public User addTester(RegisterRequest addTesterRegisterRequest) {
/*      Tester should be validated before registration.
                the username , email and phone number should be unique (i.e should throw AppException if the RegisterRequest has the same username or email or phone number)
                    hint:
                        userService.findByUserName
                        userService.findByEmail
                        userService.findByPhoneNumber

         A new User Object should be created with same details as registerRequest
                password should be encrypted with help of   userService.toEncrypted
                roles should be set with help of  userService.getRoleFor(UserRole.TESTER)
                status should be set to AccountStatus.INITIATED

        And finally
            Call userService.saveInDatabase to save newly registered tester and return the saved value
*/

        if(userService.findByUserName(addTesterRegisterRequest.getUserName()) != null){
            throw new AppException("Tester Already Exists!");
        }

        if(userService.findByEmail(addTesterRegisterRequest.getEmail()) != null){
            throw new AppException("Tester Email already taken!");
        }

        if(userService.findByPhoneNumber(addTesterRegisterRequest.getPhoneNumber()) != null){
            throw new AppException("Tester Phone Number already taken!");
        }
        User newTester = new User();
        newTester.setUserName(addTesterRegisterRequest.getUserName());
        newTester.setPassword(userService.toEncrypted(addTesterRegisterRequest.getPassword()));
        newTester.setRoles(userService.getRoleFor(UserRole.TESTER));
        newTester.setCreated(LocalDateTime.now());
        newTester.setUpdated(LocalDateTime.now());
        newTester.setAddress(addTesterRegisterRequest.getAddress());
        newTester.setFirstName(addTesterRegisterRequest.getFirstName());
        newTester.setLastName(addTesterRegisterRequest.getLastName());
        newTester.setEmail(addTesterRegisterRequest.getEmail());
        newTester.setPhoneNumber(addTesterRegisterRequest.getPhoneNumber());
        newTester.setPinCode(addTesterRegisterRequest.getPinCode());
        newTester.setGender(addTesterRegisterRequest.getGender());
        newTester.setAddress(addTesterRegisterRequest.getAddress());
        newTester.setDateOfBirth(getDateFromString(addTesterRegisterRequest.getDateOfBirth()));
        newTester.setStatus(AccountStatus.INITIATED);
        return userService.saveInDatabase(newTester);
    }


}
