package cn.net.szwx.sell.service.mall.product;

import cn.net.szwx.sell.dao.mall.product.LoanBankDao;
import cn.net.szwx.sell.entity.mall.product.LoanBank;
import cn.net.szwx.sell.entity.mall.product.LoanBankSO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class LoanBankServiceImpl implements LoanBankService {
    @Autowired
    private LoanBankDao loanBankDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(LoanBank entity) {
        entity.preInsert();
        return loanBankDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(LoanBank entity) {
        entity.preUpdate();
        return loanBankDao.update(entity);
    }

    @Override
    public List<LoanBank> list(LoanBankSO so) {
        return loanBankDao.list(so);
    }

    @Override
    public PageInfo<LoanBank> findPage(LoanBankSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<LoanBank> pageInfo = new PageInfo(loanBankDao.list(so));
        return pageInfo;
    }

    @Override
    public LoanBank getById(Long id) {
        return loanBankDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(Long id) {
        return loanBankDao.deleteById(id);
    }
}
