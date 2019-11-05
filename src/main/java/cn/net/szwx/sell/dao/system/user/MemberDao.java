package cn.net.szwx.sell.dao.system.user;

import cn.net.szwx.sell.entity.system.user.Member;
import cn.net.szwx.sell.entity.system.user.MemberSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(Member entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(Member entity);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<Member> list(MemberSO so);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    Member getById(Long id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(Long id);
}
