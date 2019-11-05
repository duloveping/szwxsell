package cn.net.szwx.sell.entity.system.user;

import cn.net.szwx.sell.entity.EntitySupport;
import cn.net.szwx.sell.entity.SOSupport;

/**
 * 账号
 * @author 广东鼎和信息科技有限公司 - 杜永生
 * @version 0.0.1
 */
public abstract class AccountSO extends SOSupport {
    private static final long serialVersionUID = -264312330317090798L;
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

    public AccountSO() {
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
