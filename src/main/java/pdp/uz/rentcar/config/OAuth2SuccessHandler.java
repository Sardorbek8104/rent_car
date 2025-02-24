//package pdp.uz.rentcar.config;
//
//import jakarta.persistence.AttributeOverride;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//import pdp.uz.rentcar.entity.User;
//import pdp.uz.rentcar.entity.enums.AuthProvider;
//import pdp.uz.rentcar.service.UserService;
//import pdp.uz.rentcar.service.jwt.JwtService;
//
//import java.io.IOException;
//import java.util.Map;
//import java.util.Optional;
//
//@Component
//public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//    @Autowired
//    private JwtService jwtService;
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        DefaultOAuth2User oauthUser = (DefaultOAuth2User) authentication.getPrincipal();
//        Map<String, Object> attributes = oauthUser.getAttributes();
//
//        String email = (String) attributes.get("email");
//        String username = (String) attributes.get("username");
//        String provider;
//        if (authentication instanceof OAuth2AuthenticationToken oAuthToken) {
//            provider = oAuthToken.getAuthorizedClientRegistrationId().toUpperCase();
//        } else {
//            provider = "OAUTH2";
//        }
//        Optional<User> existingUser = userService.getUserByEmail(email);
//        User user = existingUser.orElseGet(() -> {
//            User newUser = new User();
//            newUser.setEmail(email);
//            newUser.setUsername(username);
//            newUser.setProvider(AuthProvider.valueOf(provider));
//            return userService.save(newUser);
//        });
//
//        String accessToken = jwtService.generateAccessToken(user);
//        String refreshToken = jwtService.generateRefreshToken(user);
//    }
//}
