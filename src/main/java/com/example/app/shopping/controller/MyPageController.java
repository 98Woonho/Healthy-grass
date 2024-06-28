package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.config.auth.jwt.JwtProperties;
import com.example.app.shopping.config.auth.jwt.JwtTokenProvider;
import com.example.app.shopping.config.auth.jwt.TokenInfo;
import com.example.app.shopping.domain.dto.ShippingAddressDto;
import com.example.app.shopping.domain.dto.UserDto;

import com.example.app.shopping.domain.dto.WishDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.dto.common.PageDto;
import com.example.app.shopping.domain.service.PaymentService;

import com.example.app.shopping.domain.service.myPage.MyPageService;
import com.example.app.shopping.domain.service.orderItem.OrderItemService;
import com.example.app.shopping.domain.service.user.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("myPage")
public class MyPageController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private MyPageService myPageService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("")
    public String myPage(Authentication authentication){
        if (authentication != null) {
            return "myPage/mypage";
        }
        return "redirect:user/loginForm";
    }

    @GetMapping("wishList")
    public String getWishList(Criteria criteria, Authentication authentication, Model model) {
        // 현재 로그인 한 유저
        String Uid = ((PrincipalDetails) authentication.getPrincipal()).getUsername();

        // 표시할 게시물 양
        criteria.setAmount(10);

        int count = myPageService.getWishCount(Uid);
        PageDto pageDto = new PageDto(count, criteria);

        int offset = (criteria.getPageno() - 1) * criteria.getAmount();

        List<Map<String, Object>> wishList = myPageService.getWishList(criteria, offset, Uid);

        // 2페이지 이상 && 찜한 상품이 없으면 이전 페이지로 return
        if (wishList.size() == 0 && criteria.getPageno() > 1) {
            criteria.setPageno(criteria.getPageno() - 1);
            return "redirect:myPage/wishList?pageno=" + criteria.getPageno();
        }

        model.addAttribute("wishList", wishList);
        model.addAttribute("pageDto", pageDto);

        return "myPage/wishList";
    }

    // 찜리스트에 제품 저장
    @PostMapping("wish")
    public ResponseEntity<String> postWish(@RequestBody WishDto wishDto, Authentication authentication) {
        String Uid = ((PrincipalDetails) authentication.getPrincipal()).getUsername();
        wishDto.setUid(Uid);

        String result = myPageService.addWish(wishDto);

        if (result.equals("FAILURE_DUPLICATE_WISH")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 찜리스트에 등록된 제품입니다.");
        }

        return ResponseEntity.ok("찜리스트에 제품이 등록 되었습니다.");
    }

    @DeleteMapping("wish/{pIds}")
    public ResponseEntity<String> deleteWish(@PathVariable(value="pIds") List<Long> pIdList, Authentication authentication) {
        String uId = ((PrincipalDetails) authentication.getPrincipal()).getUsername();

        myPageService.deleteWish(pIdList, uId);

        return ResponseEntity.ok("");
    }

    @GetMapping("editAddress")
    public void getEditAddress(Authentication authentication, Model model) {
        // 현재 로그인 한 유저의 정보 가져오기
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        UserDto userDto = principalDetails.getUserDto();

        // 배송지 db에서 현재 로그인 한 유저의 배송지 가져오기
        ShippingAddressDto shippingAddressDto = myPageService.isExistShippingAddress(userDto.getId());

        model.addAttribute("shippingAddress", shippingAddressDto);
    }

    @PostMapping("editAddress")
    public ResponseEntity<String> postEditAddress(Authentication authentication, ShippingAddressDto shippingAddressDto) {
        // 현재 로그인 한 유저의 정보 가져오기
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        UserDto userDto = principalDetails.getUserDto();

        // 배송지 정보에 현재 로그인 한 유저의 id set
        shippingAddressDto.setUid(userDto.getId());

        // 배송지 db에서 현재 로그인 한 유저의 배송지 가져오기
        ShippingAddressDto existingShippingAddressDto = myPageService.isExistShippingAddress(userDto.getId());

        if (existingShippingAddressDto != null) {
            // 현재 로그인한 유저의 배송지가 있으면 수정
            shippingAddressDto.setId(existingShippingAddressDto.getId());
            myPageService.modifyShippingAddress(shippingAddressDto);
        } else {
            // 현재 로그인한 유저의 배송지가 없으면 등록
            myPageService.registerShippingAddress(shippingAddressDto);

        }
        return ResponseEntity.ok("배송지가 저장 되었습니다.");
    }

    @GetMapping("user/searchForm") //회원정보 조회
    public String userSearchForm(Authentication authentication, Model model) {
        if (authentication != null) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal(); // authentication안에 userDto를 꺼내려면 PrincipalDetails안에 들어있는 userDto의 정보를 꺼내와야한다.
            UserDto userDto = principalDetails.getUserDto();
            model.addAttribute("userDto", userDto);

            return "myPage/searchForm";
        } else {
            return "redirect:user/loginForm";
        }
    }

    @GetMapping("user/modifyForm") // 회원정보 수정 페이지로 가기
    public String userModifyForm(Authentication authentication, Model model) {
        if (authentication != null && passwordCheck) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            // authentication안에 userDto를 꺼내려면 PrincipalDetails안에 들어있는 userDto의 정보를 꺼내와야한다.
            UserDto userDto = principalDetails.getUserDto();
            model.addAttribute("userDto", userDto);
            return "myPage/modifyForm";
        } else if (authentication != null) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            // authentication안에 userDto를 꺼내려면 PrincipalDetails안에 들어있는 userDto의 정보를 꺼내와야한다.
            UserDto userDto = principalDetails.getUserDto();
            model.addAttribute("userDto", userDto);
            model.addAttribute("tmp", "modify");
            return "myPage/passwordCheckForm";
        }

        return "redirect:user/loginForm";
    }

    @PostMapping("user/modify") // 회원정보 수정
    public @ResponseBody ResponseEntity<String> userModify(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        System.out.println(userDto);

        // id 필드에 대한 에러를 수동으로 제거하기 위해 새 리스트 생성
        List<FieldError> fieldErrors = bindingResult.getFieldErrors().stream()
                .filter(error -> !"id".equals(error.getField()))
                .collect(Collectors.toList());

        System.out.println(fieldErrors);

        if (!fieldErrors.isEmpty()) {
            // 유효성 검사 실패 시 오류 메시지 알려줌
            Map<String, String> errors = new HashMap<>();
            fieldErrors.forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
            );
            return new ResponseEntity<>("FAIL", HttpStatus.BAD_GATEWAY);
        }

        String response = userService.userUpdate(userDto);

        // 수정 시 세션도 수정된 값 전달
        UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getId());


        //Authentication 구현체
        UsernamePasswordAuthenticationToken newAuth = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        // SecurityContext에 새로운 Authentication 객체 설정
        SecurityContextHolder.getContext().setAuthentication(newAuth);

        //--------------------------------------
        //JWT Modify
        //--------------------------------------

        TokenInfo tokenInfo = jwtTokenProvider.generateToken(newAuth);
        // 쿠키 생성
        Cookie cookie = new Cookie(JwtProperties.COOKIE_NAME, tokenInfo.getAccessToken());
        cookie.setMaxAge(JwtProperties.EXPIRATION_TIME); // 쿠키의 만료시간 설정
        cookie.setPath("/");

        // 쿠키를 HTTP 응답 헤더에 추가하여 클라이언트에게 전달
        HttpServletResponse servletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        servletResponse.addCookie(cookie);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("user/deleteForm") // 회원정보 삭제 페이지로 가기
    public String userDeleteForm(Authentication authentication, Model model) {
        if (authentication != null && passwordCheck) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            // authentication안에 userDto를 꺼내려면 PrincipalDetails안에 들어있는 userDto의 정보를 꺼내와야한다.
            UserDto userDto = principalDetails.getUserDto();
            model.addAttribute("userDto", userDto);
            return "myPage/deleteForm";}
        else if (authentication != null) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            // authentication안에 userDto를 꺼내려면 PrincipalDetails안에 들어있는 userDto의 정보를 꺼내와야한다.
            UserDto userDto = principalDetails.getUserDto();
            model.addAttribute("userDto", userDto);
            model.addAttribute("tmp", "delete");
            return "myPage/passwordCheckForm";
        }
        return "redirect:user/loginForm";
    }

    @DeleteMapping("user/delete")
    public @ResponseBody String userDelete(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
        String result = userService.deleteUser(id);

        if (result.equals("SUCCESS")) {
            // 삭제 시 세션과 인증 정보를 무효화하여 보안강화를 하기 위한 목적.
            SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
            logoutHandler.logout(request, response, SecurityContextHolder.getContext().getAuthentication());
            return result;
         }

        return result;
    }

    //유저 패스워드 재확인 폼으로 이동
    @GetMapping("user/passwordCheckForm")
    public String passwordCheckForm(Authentication authentication, Model model) {
        if (authentication != null) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            // authentication안에 userDto를 꺼내려면 PrincipalDetails안에 들어있는 userDto의 정보를 꺼내와야한다.
            UserDto userDto = principalDetails.getUserDto();
            model.addAttribute("userDto", userDto);
            return "myPage/passwordCheckForm";
        }
        return "redirect:user/loginForm";
    }
    boolean passwordCheck = false;
    @PostMapping("user/passwordCheck") // 회원정보 수정 페이지나, 삭제페이지 갈때 비밀번호 재확인 받는 코드
    @ResponseBody
    public String checkPasswordIntoMyPage(@RequestBody UserDto userDto, Authentication authentication) {
        if (authentication != null) {
            String key = userService.userIdAndPasswordCheck(userDto.getId(), userDto.getPassword());
            System.out.println("key : " + key);
            if (key.equals("SUCCESS")){
                passwordCheck = true;
            }
            return key;
        }
        return "redirect:user/loginForm";
    }

    /*
        마이 페이지 결제 목록 게시판 페이지로 이동합니다.
    */
    @GetMapping("paymentList")
    public String getMyPaymentBoard(@ModelAttribute Criteria criteria, Authentication authentication, Model model) {
        log.info("MyPageController's getMyPaymentBoard criteria: " + criteria);

        if (criteria.getPageno() == null) {
            criteria.setPageno(1);
        }

        criteria.setAmount(6);

        String uId =
                authentication != null ? authentication.getName() : "";

        try {
            Map<String, Object> serviceReturnVal = paymentService.getMyPayments(criteria, uId);
            model.addAttribute("success", true);
            model.addAttribute("list", serviceReturnVal.get("list"));
            model.addAttribute("pageDto", serviceReturnVal.get("pageDto"));
        } catch(Exception e) {
            model.addAttribute("success", false);
        }

        return "myPage/paymentList";
    }

    /*
        payment 의 refund status 를 수정 요청 합니다.
        request 에 id 만 있다면 사용자의 환불 요청
        request 에 id, status 가 있다면 관리자의 환불 승인

        관리자라면 검증과정 없이 수정 작업을 수행
        사용자라면 해당 payment 가 본인의 것인지 검증하는 작업이 포함됩니다.
    */
    @PutMapping("payment")
    public @ResponseBody Map<String, Object> putPayment(@RequestBody Map<String, Object> request, Authentication authentication) {
        log.info("MyPageController's putPayment request: " + request);

        Map<String, Object> response = new HashMap<>();

        if (authentication == null) {
            response.put("success", false);
            response.put("msg", "비회원은 이용할 수 없는 서비스입니다.");

            return response;
        }

        boolean isAdmin = false;

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        String userName = principalDetails.getUsername();
        Collection<? extends GrantedAuthority> authorities = principalDetails.getAuthorities();
        isAdmin = authorities.stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        try {
            // 권한 체크 및 로그인 정보가 본인인지 검증합니다.
            Map<String, Object> paymentInfo = paymentService.getPaymentById(request.get("id"));

            if (!isAdmin && !userName.equals(paymentInfo.get("userid"))) {
                // 관리자가 아니고 자신의 payment 에 대한 수정 요청이 아닐시
                response.put("success", false);
                response.put("msg", "본인이 작성한 게시글만 삭제할 수 있습니다.");
            } else {
                // payment 수정
                boolean isUpdated = paymentService.putPaymentServ(request);

                if (isUpdated) {
                    response.put("success", true);
                    response.put("msg", "환불 요청이 성공적으로 처리되었습니다.");
                } else {
                    response.put("success", false);
                    response.put("msg", "환불 요청 처리에 실패하였습니다.");
                }
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", "환불 요청 처리 중 오류가 발생하였습니다.");
        }

        return response;
    }
    
    /*
        payment 상세보기 페이지 이동
        payment id 를 사용하여 구매한 order_item 목록도 가져온다
    */
    @GetMapping("payment")
    public String getPayment(@RequestParam(name = "id", defaultValue = "0", required = false) Long id, Model model, Authentication authentication) {
        log.info("MyPageController's getPayment id: " + id);
        Map<String, Object> response = new HashMap<>();

        // 비회원일 시 결제 정보 조회가 불가능하다
        if (authentication == null) {
            model.addAttribute("success", false);
            model.addAttribute("msg", "비회원은 이용할 수 없는 서비스입니다.");

            return "myPage/paymentDetail";
        }

        boolean isAdmin = false;

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        String userName = principalDetails.getUsername();
        Collection<? extends GrantedAuthority> authorities = principalDetails.getAuthorities();
        isAdmin = authorities.stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        try {
            // 권한 체크 및 로그인 정보가 본인인지 검증합니다.
            Map<String, Object> paymentInfo = paymentService.getPaymentById(id);

            if (!isAdmin && !userName.equals(paymentInfo.get("userid"))) {
                // 관리자가 아니고 자신의 payment 에 대한 조회 요청이 아닐시
                model.addAttribute("success", false);
                model.addAttribute("msg", "본인의 결제 정보만 조회할 수 있습니다.");
            } else {
                // 만약 payment 조회 결과가 없다면 에러처리
                if (paymentInfo.isEmpty()) {
                    throw new Exception();
                }

                // 조회 로직 작성 (payment에 대한 정보와 order_item 리스트가 필요)
                Long orderId = (Long) paymentInfo.get("Oid");

                model.addAttribute("payment", paymentInfo);
                model.addAttribute("orderItemList",
                        orderItemService.getOrderItemsWithProductByOid(orderId)
                );
                model.addAttribute("success", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("success", false);
            model.addAttribute("msg", "조회중 오류가 발생했습니다.");
        }

        return "myPage/paymentDetail";
    }

}
