package cn.net.szwx.sell.service.system.user;

import cn.net.szwx.sell.dao.system.user.MemberDao;
import cn.net.szwx.sell.entity.system.user.Member;
import cn.net.szwx.sell.entity.system.user.MemberSO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(Member entity) {
        entity.preInsert();
        return memberDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(Member entity) {
        entity.preUpdate();
        return memberDao.update(entity);
    }

    @Override
    public List<Member> list(MemberSO so) {
        return memberDao.list(so);
    }

    @Override
    public PageInfo<Member> findPage(MemberSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<Member> pageInfo = new PageInfo(memberDao.list(so));
        return pageInfo;
    }

    @Override
    public Member getById(Long id) {
        return memberDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(Long id) {
        return memberDao.deleteById(id);
    }
}
