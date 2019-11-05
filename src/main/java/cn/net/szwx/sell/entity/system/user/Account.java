package cn.net.szwx.sell.entity.system.user;

import cn.net.szwx.sell.entity.EntitySupport;

/**
 * 账号
 * @author 广东鼎和信息科技有限公司 - 杜永生
 * @version 0.0.1
 */
public abstract class Account extends EntitySupport {
    private static final long serialVersionUID = 3497336301519255714L;
    /** 用户名 */
    private String username;
    /** 姓名 */
    private String fullname;
    /** 昵称 */
    private String nickname;
    /** 密码 */
    private String password;
    /** 锁定状态 */
    private Integer lockState;

    public Account() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLockState() {
        return lockState;
    }

    public void setLockState(Integer lockState) {
        this.lockState = lockState;
    }
}
