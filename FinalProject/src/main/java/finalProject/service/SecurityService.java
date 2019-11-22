package finalProject.service;

/**
 * Service for Security.
 *
 * @author Sergey Ivanenko
 * @version 1.0
 */

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
