package com.meisterlampe.dockertestingarea2.serviceImpl;
import com.meisterlampe.dockertestingarea2.entities.User;
import com.meisterlampe.dockertestingarea2.repository.UserRepository;
import com.meisterlampe.dockertestingarea2.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;



@Service
public class UserServiceImpl implements UserService {

    @Resource
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDetailsService userDetailsService(){
            return new UserDetailsService() {
                @Override
                public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

                    User user;
                    if(usernameOrEmail.contains("@")){
                        user =userRepository.findByEmail(usernameOrEmail).orElseThrow(() -> new UsernameNotFoundException("Email nicht gefunden"));
                    }
                    else {
                        user= userRepository.findByUsername(usernameOrEmail).orElseThrow(() -> new UsernameNotFoundException("User nicht gefunden!"));
                    }

                return user;
                }
            };
    }

    public Optional<User> findByUsername(String username) {

        Optional<User> user = userRepository.findByUsername(username);

        if(user.isPresent()) {
            return user;
        }
        return Optional.empty();
    }

    public Optional<User> findByEmail(String email) {

        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()){
            return user;
        }
        return Optional.empty();


    }


    @Override
    public Iterable<User> getAllCustomers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> updateCustomerById(int iduser, User user) {

        Optional<User> optionalCustomerDTO = userRepository.findById(iduser);

        if (optionalCustomerDTO.isPresent()) {
            User existingCustomer = optionalCustomerDTO.get();

            if (user.getUsername() != null) {
                existingCustomer.setUsername(user.getUsername());
            }

            if (user.getAddress() != null) {
                existingCustomer.setAddress(user.getAddress());
            }

            if (user.getFirstname() != null) {
                existingCustomer.setFirstname(user.getFirstname());
            }

            if (user.getLastname() != null) {
                existingCustomer.setLastname(user.getLastname());
            }

            if (user.getZipcode() != null) {
                existingCustomer.setZipcode(user.getZipcode());
            }

            if (user.getEmail() != null) {
                existingCustomer.setEmail(user.getEmail());
            }

            if (user.getPassword() != null) {
                existingCustomer.setPassword(user.getPassword());
            }

            if (user.getCountry() != null) {
                existingCustomer.setCountry(user.getCountry());
            }

            if (user.getDob() != null) {
                existingCustomer.setDob(user.getDob());
            }

            if (user.getCreatedAt() != null) {
                existingCustomer.setCreatedAt(user.getCreatedAt());
            }


            userRepository.save(existingCustomer);

            return Optional.of(existingCustomer);

        } else {
            return Optional.empty();

        }
    }

}
