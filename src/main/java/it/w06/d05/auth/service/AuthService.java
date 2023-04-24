package  it.w06.d05.auth.service;

import it.w06.d05.auth.payload.LoginDto;
import it.w06.d05.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
