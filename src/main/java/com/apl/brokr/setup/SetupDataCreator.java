package com.apl.brokr.setup;

import com.apl.brokr.model.entities.Address;
import com.apl.brokr.model.entities.User;
import com.apl.brokr.model.entities.UserRole;
import com.apl.brokr.model.repositories.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Component
public class SetupDataCreator implements ApplicationRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public SetupDataCreator(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        createMainUsers();
        createTestUsers();
    }


    private void createUserIfNotExists(
            String username,
            String password,
            String email,
            String phoneNumber,
            Address address,
            String companyName,
            String firstName,
            String lastName,
            String krsNumber,
            String nipNumber,
            String regonNumber,
            String pkdNumber,
            String... roles) {

        userRepository.findUserByUsername(username)
                .ifPresentOrElse(
                        user -> System.out.print(""),
                        () -> {
                            User user = new User();
                            user.setUsername(username);
                            user.setPassword(passwordEncoder.encode(password));
                            user.setEmail(email);
                            user.setPhoneNumber(phoneNumber);
                            user.setAddress(address);
                            user.setCompanyName(companyName);
                            user.setFirstName(firstName);
                            user.setLastName(lastName);
                            user.setKrsNumber(krsNumber);
                            user.setNipNumber(nipNumber);
                            user.setRegonNumber(regonNumber);
                            user.setPkdNumber(pkdNumber);
                            user.getRoles().addAll(Arrays.stream(roles).map(s -> "ROLE_".concat(s)).map(s -> new UserRole(s)).collect(Collectors.toSet()));
                            userRepository.save(user);
                        });
    }

    private void createMainUsers() {

        Address clientAddress = new Address("Wroclaw", "Kliencka 12", "51-112", "Wroclaw", "Wroclaw", "Dolnoslaskie", "Polska");
        Address brokerAddress = new Address("Wroclaw", "Brokerska 12", "51-112", "Wroclaw", "Wroclaw", "Dolnoslaskie", "Polska");
        Address adminAddress = new Address("Wroclaw", "Adminowska 12", "51-112", "Wroclaw", "Wroclaw", "Dolnoslaskie", "Polska");

        createUserIfNotExists(
                "client", "pass", "client@client.eu", "614614614", clientAddress, "ABC Corp",
                "John", "Doe", "krs_1234", "nip_1234", "regon_1234", "pkd_1234", "CLIENT");

        createUserIfNotExists(
                "broker", "pass", "broker@broker.eu", "614884614", brokerAddress, "Broker S.A.",
                "Ann", "Smith", "krs_4434", "nip_4434", "regon_4434", "pkd_4434", "BROKER");

        createUserIfNotExists(
                "admin", "pass", "admin@admin.eu", "617774614", adminAddress, "IT Corp",
                "Mat", "Trent", "krs_8834", "nip_8834", "regon_8834", "pkd_8834", "ADMIN");
    }

    private void createTestUsers(){
        LongStream.rangeClosed(1, 20).forEach(number -> createTestUser(number));
    }

    private void createTestUser(Long id){
        Address address = new Address("Wroclaw", "Testowa " + id, "51-112", "Wroclaw", "Wroclaw", "Dolnoslaskie", "Polska");

        createUserIfNotExists(
                "client" + id, "pass" + id, "client"  + id +"@client.eu", "617774" + id, address, "Top " + id + " Corp",
                "Anna", "Kowalska" + id, "krs_88" + id, "nip_88" + id, "regon_88" + id, "pkd_88" + id, "CLIENT");
    }
}



