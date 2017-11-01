package cc.sportsdb.manager.dto.manager;

import cc.sportsdb.common.dto.DTOAttributes;
import cc.sportsdb.manager.domain.manager.Manager;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


public class ManagerDTO implements DTOAttributes<Manager> {

    @Email(message = "Email format incorrect.")
    private String email;
    @NotBlank(message = "Password can not be blank.")
    private String password;

    private String nickname;
    private String avatar;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public Manager toPO() {
        Manager manager = new Manager();
        manager.setEmail(email);
        manager.setPassword(password);
        manager.setNickname(nickname);
        manager.setAvatar(avatar);
        return manager;
    }
}
