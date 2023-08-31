package PsychologyClinic.API.domain.controller;

import PsychologyClinic.API.domain.user.PostAuthenticationData;
import PsychologyClinic.API.domain.user.User;
import PsychologyClinic.API.infra.security.DtoTokenJWTData;
import PsychologyClinic.API.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity doLogin(@RequestBody @Valid PostAuthenticationData data) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = authManager.authenticate(authenticationToken);



        var tokenJWT = tokenService.createToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new DtoTokenJWTData(tokenJWT));
    }

}
