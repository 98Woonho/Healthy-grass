package com.example.app.shopping.domain.service.user;

import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 지정된 범위의 랜덤 숫자를 생성하여 반환하는 함수.
     *
     * @param length 생성할 랜덤 숫자의 자릿수
     * @param min    최소값 (포함)
     * @param max    최대값 (포함)
     * @return 랜덤 숫자
     */
    public static String RandomString(int length) {
        // 랜덤 문자를 선택할 문자열
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();

        // Random 객체 생성
        Random random = new Random();

        // 문자열 길이만큼 반복하여 랜덤 문자 생성
        for (int i = 0; i < length; i++) {
            // characters 문자열에서 랜덤으로 한 문자 선택하여 추가
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        // 최종적으로 생성된 랜덤 문자열 반환
        return stringBuilder.toString();
    }

    private static String RandomNumber(int length) {
        Random random = new Random();
        StringBuilder randomNumberBuilder = new StringBuilder();

        // 첫 자리 숫자를 1에서 9 사이로 생성하여 0이 맨 앞에 오지 않도록 합니다.
        randomNumberBuilder.append(random.nextInt(9) + 1);

        // 나머지 자리를 0에서 9 사이의 숫자로 생성합니다.
        for (int i = 1; i < length; i++) {
            randomNumberBuilder.append(random.nextInt(10));
        }

        return randomNumberBuilder.toString();
    }


    public boolean isUserExists(String id) {
        UserDto selectUserById = userMapper.getUserById(id);
        //만약 유저를 조회해서 유저가 있다면 false 없다면 true 반환
        return selectUserById == null;
    }

    // 전화번호 형식을 변환하는 메서드
    public String formatPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 11) { // 전화번호가 11자리인지 확인
            return phoneNumber.replaceFirst("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3");
        }
        // 유효한 전화번호가 아닐 경우 원래 값을 반환하거나 예외를 처리할 수 있음
        return phoneNumber;
    }

    public String userJoin(UserDto userDto) {
        if (!isUserExists(userDto.getId())) {
            return "FAILURE_DUPLICATED_USER_ID";
        } else {
            UserDto result = UserDto.builder()
                    .id(userDto.getId())
                    .name(userDto.getName())
                    .phone(formatPhoneNumber(userDto.getPhone()))
                    .email(userDto.getEmail())
                    .password(passwordEncoder.encode(userDto.getPassword()))
                    .streetAdr(userDto.getStreetAdr())
                    .zipcode(userDto.getZipcode())
                    .detailAdr(userDto.getDetailAdr())
                    .role("ROLE_USER")
                    .build();
            userMapper.insertUser(result);
            return "SUCCESS";
        }
    }

    public String confirmUserId(String id) {
        UserDto UserId = userMapper.getUserById(id);
        if (UserId != null && UserId.getId().equals(id)) {
            return "FAILURE_DUPLICATED_USER_ID";
        }
        return "SUCCESS";
    }

    public String userUpdate(UserDto userDto) {
        if (userDto != null) {
            System.out.println(userDto);
            UserDto result = UserDto.builder()
                    .id(userDto.getId())
                    .name(userDto.getName())
                    .phone(userDto.getPhone())
                    .email(userDto.getEmail())
                    .password(passwordEncoder.encode(userDto.getPassword()))
                    .streetAdr(userDto.getStreetAdr())
                    .zipcode(userDto.getZipcode())
                    .detailAdr(userDto.getDetailAdr())
                    .role("ROLE_USER")
                    .build();
            userMapper.updateUser(result);
            return "SUCCESS";
        }
        return "FAILURE_UPDATE";
    }

    String userid = null;

    public String deleteUser(String id) {
        if (id != null) {
            userMapper.deleteUserById(id);
            return "SUCCESS";
        }
        return "FAILURE_DELETE_NOT_FIND_USER";
    }

    public String findUserIdByEmailAndUserName(UserDto userDto) {
        List<String> userIdByEmailAndUserName = userMapper.findUserIdByEmailAndUserName(userDto.getEmail(), userDto.getName());
        if (userIdByEmailAndUserName.isEmpty()) {
            return "FAILURE_NOT_FOUND_USER_ID";
        } else {
            userIdByEmailAndUserName.forEach(user -> {
                userid = user;
            });
        }
        return userid;
    }

    public String findUserIdByPhoneAndUserName(UserDto userDto) {
        List<String> userIdByPhoneAndUserName = userMapper.findUserIdByPhoneAndUserName(userDto.getPhone(), userDto.getName());
        if (userIdByPhoneAndUserName.isEmpty()) {
            return "FAILURE_NOT_FOUND_USER_ID";
        } else {
            userIdByPhoneAndUserName.forEach(user -> {
                userid = user;
            });
        }
        return userid;
    }

    String randomSixNumber = null;
    String userId = null;
    String userEmail = null;

    public String findUserPasswordByEmailAndUserIdAsRandomValue(UserDto userDto) {
        String userPassword = userMapper.findUserPasswordByEmailAndUserId(userDto.getEmail(), userDto.getId());
        System.out.println("userPassword : " + userPassword);
        if (userPassword == null) {
            return "FAILURE_NOT_FOUND_USER_PASSWORD";
        } else {
            userId = userDto.getId();
            userEmail = userDto.getEmail();
            String randomNumber = RandomNumber(6);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(userDto.getEmail());
            message.setSubject("[쇼핑몰]");
            message.setText(randomNumber); //랜덤 숫자 6개

            //메일발송
            javaMailSender.send(message);
            randomSixNumber = randomNumber;
            return "SUCCESS";
        }
    }

    public String checkPasswordAuthenticationCode(Map<String, String> request) {
        String passwordCheck = request.get("passwordCheck");
        if (passwordCheck == null){
            return "FAILURE_NOT_FOUND_CODE";
        } else if(!randomSixNumber.equals(request.get("passwordCheck"))) {
            return "FAILURE_ANOTHER_CODE";
        }
        String randomString = RandomString(8);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setSubject("[쇼핑몰]");
        message.setText(randomString); //랜덤 문자 8개

        //메일발송
        javaMailSender.send(message);
        //비밀번호 재설정
        userMapper.updateUserPassword(passwordEncoder.encode(randomString), userId);

        return "SUCCESS";
    }
}

